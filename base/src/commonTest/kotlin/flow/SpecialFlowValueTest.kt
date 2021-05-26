/*
 Copyright 2021 Splendo Consulting B.V. The Netherlands

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

package com.splendo.kaluga.base

import com.splendo.kaluga.base.SpecialFlowValueTest.Special.Last
import com.splendo.kaluga.base.SpecialFlowValueTest.Special.More
import com.splendo.kaluga.base.SpecialFlowValueTest.Special.Normal
import com.splendo.kaluga.base.SpecialFlowValueTest.Special.NotImportant
import com.splendo.kaluga.base.flow.SpecialFlowValue
import com.splendo.kaluga.base.flow.collectImportant
import com.splendo.kaluga.base.flow.collectImportantUntilLast
import com.splendo.kaluga.base.flow.collectUntilLast
import com.splendo.kaluga.base.flow.filterOnlyImportant
import com.splendo.kaluga.test.BaseTest
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SpecialFlowValueTest: BaseTest() {

    sealed class Special {
        object Last:SpecialFlowValue.Last,Special()
        object Normal:Special()
        object NotImportant:SpecialFlowValue.NotImportant,Special()
        object More:Special()
    }

    private fun flow() = flowOf(Normal, NotImportant, Last, More)

    @Test
    fun testSpecialValues() = runBlocking {
        assertEquals(
            expected = listOf(Normal, NotImportant, Last, More),
            actual = flow().toList()
        )

        assertEquals(
            expected = listOf(Normal, Last, More),
            actual = flow().filterOnlyImportant().toList()
        )

        val list = mutableListOf<Special>()
        flow().collectImportantUntilLast {
            list.add(it)
        }
        assertEquals(
            expected = listOf(Normal, Last),
            actual = list
        )

        list.clear()
        flow().collectUntilLast {
            list.add(it)
        }
        assertEquals(
            expected = listOf(Normal, NotImportant, Last),
            actual = list
        )

        list.clear()

        launch {
            flow().collectImportant {
                list.add(it)
                if (it is More)
                    assertEquals(
                        expected = listOf(Normal, Last, More),
                        actual = list
                    )
                cancel()
            }
        }.join()
    }
}



