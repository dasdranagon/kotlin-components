/*
 Copyright 2020 Splendo Consulting B.V. The Netherlands

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 */

package com.splendo.kaluga.system.network

import com.splendo.kaluga.system.network.state.NetworkState
import com.splendo.kaluga.system.network.state.NetworkStateRepo
import com.splendo.kaluga.system.network.state.online
import com.splendo.kaluga.test.FlowTest
import com.splendo.kaluga.test.FlowTestBlock
import kotlinx.coroutines.flow.first
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NetworkStateTest : FlowTest<NetworkState, NetworkStateRepo>() {

    override val flow = suspend { MockNetworkStateRepoBuilder().create() }

    private fun testNetworkState(test: FlowTestBlock<NetworkState, NetworkStateRepo>) {
        testWithFlow(test)
    }

    @Test
    fun testInitialValueUnknown() = testNetworkState {
        assertInitialValue(this)
    }

    @Test
    fun testNetworkStateChanged() = testNetworkState { networkStateRepo ->
        assertInitialValue(this)

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Wifi())
        }

        test {
            assertTrue { it is NetworkState.Available }
            assertEquals(Network.Known.Wifi(), it.networkType)
        }

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Absent)
        }

        test {
            assertTrue { it is NetworkState.Unavailable }
            assertEquals(Network.Known.Absent, it.networkType)
        }

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Cellular())
        }

        test {
            assertTrue { it is NetworkState.Available }
            assertEquals(Network.Known.Cellular(), it.networkType)
        }
    }

    @Test
    fun testAvailableTransition() = testNetworkState { networkStateRepo ->
        assertInitialValue(this)

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Wifi())
        }

        test {
            assertTrue { it is NetworkState.Available }
            assertTrue { it.networkType is Network.Known.Wifi }
        }

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(
                Network.Unknown.WithLastNetwork(
                    Network.Known.Wifi(),
                    Network.Unknown.Reason.NOT_CLEAR
                )
            )
        }

        test {
            assertTrue { it.networkType is Network.Unknown.WithLastNetwork }
            assertTrue { (it.networkType as Network.Unknown.WithLastNetwork).lastKnownNetwork is Network.Known.Wifi }
        }

        resetStateTo<NetworkState.Available>(networkStateRepo, Network.Known.Wifi(), this)

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Cellular())
        }

        test {
            assertTrue { it is NetworkState.Available }
            assertTrue { it.networkType is Network.Known.Cellular }
        }

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Absent)
        }

        test {
            assertTrue { it is NetworkState.Unavailable }
            assertTrue { it.networkType is Network.Known.Absent }
        }
    }

    @Test
    fun testUnavailableTransition() = testNetworkState { networkStateRepo ->
        assertInitialValue(this)

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Absent)
        }

        test {
            assertTrue { it is NetworkState.Unavailable }
            assertTrue { it.networkType is Network.Known.Absent }
        }

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Cellular())
        }

        test {
            assertTrue { it.networkType is Network.Known.Cellular }
        }

        resetStateTo<NetworkState.Unavailable>(networkStateRepo, Network.Known.Absent, this)

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Wifi())
        }

        test {
            assertTrue { it is NetworkState.Available }
            assertTrue { it.networkType is Network.Known.Wifi }
        }
    }

    @Test
    fun testUnknownTransition() = testNetworkState { networkStateRepo ->
        networkStateRepo.lastKnownNetwork = Network.Unknown.WithoutLastNetwork(
            Network.Unknown.Reason.NOT_CLEAR
        )

        test {
            assertTrue { it is NetworkState.Unknown }
            assertTrue { it.networkType is Network.Unknown.WithoutLastNetwork }
        }

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Cellular())
        }

        test {
            assertTrue { it.networkType is Network.Known.Cellular }
        }

        resetStateTo<NetworkState.Unknown>(
            networkStateRepo,
            Network.Unknown.WithoutLastNetwork(
                Network.Unknown.Reason.NOT_CLEAR
            ),
            this
        )

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Wifi())
        }

        test {
            assertTrue { it is NetworkState.Available }
            assertTrue { it.networkType is Network.Known.Wifi }
        }

        resetStateTo<NetworkState.Unknown>(
            networkStateRepo,
            Network.Unknown.WithoutLastNetwork(
                Network.Unknown.Reason.NOT_CLEAR
            ),
            this
        )

        action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(Network.Known.Absent)
        }

        test {
            assertTrue { it is NetworkState.Unavailable }
            assertTrue { it.networkType is Network.Known.Absent }
        }
    }

    @Test
    fun test_online_convenience_method_is_online() = testNetworkState { networkStateRepo ->
        val mockNetworkStateRepo = networkStateRepo as MockNetworkStateRepo

        action {
            mockNetworkStateRepo.simulateNetworkStateChange(Network.Known.Wifi())
        }
        test {
            val isOnline = networkStateRepo.online().first()
            assertTrue { isOnline }
        }

        action {
            networkStateRepo.simulateNetworkStateChange(Network.Known.Cellular())
        }
        test {
            val isOnline = networkStateRepo.online().first()
            assertTrue { isOnline }
        }
    }

    @Test
    fun test_online_convenience_method_is_not_online() = testNetworkState { networkStateRepo ->
        val mockNetworkStateRepo = networkStateRepo as MockNetworkStateRepo

        action {
            mockNetworkStateRepo.simulateNetworkStateChange(
                Network.Unknown.WithLastNetwork(
                    lastKnownNetwork = Network.Known.Absent,
                    reason = Network.Unknown.Reason.NOT_CLEAR
                )
            )
        }
        test {
            val isOnline = networkStateRepo.online().first()
            assertFalse { isOnline }
        }

        action {
            mockNetworkStateRepo.simulateNetworkStateChange(Network.Known.Absent)
        }
        test {
            val isOnline = networkStateRepo.online().first()
            assertFalse { isOnline }
        }

        action {
            mockNetworkStateRepo.simulateNetworkStateChange(
                Network.Unknown.WithoutLastNetwork(
                    reason = Network.Unknown.Reason.NOT_CLEAR
                )
            )
        }
        test {
            val isOnline = networkStateRepo.online().first()
            assertFalse { isOnline }
        }
    }

    private suspend inline fun <reified T> resetStateTo(networkStateRepo: NetworkStateRepo, network: Network, testBlock: FlowTest<NetworkState, NetworkStateRepo>) {
        testBlock.action {
            (networkStateRepo as MockNetworkStateRepo).simulateNetworkStateChange(network)
        }
        testBlock.test {
            assertTrue { it is T }
        }
    }

    private suspend fun assertInitialValue(testBlock: FlowTest<NetworkState, NetworkStateRepo>) {
        testBlock.test {
            assertTrue { it is NetworkState.Unknown }
            assertTrue { it.networkType is Network.Unknown.WithoutLastNetwork }
            assertEquals(Network.Unknown.Reason.NOT_CLEAR, (it.networkType as Network.Unknown.WithoutLastNetwork).reason)
        }
    }
}
