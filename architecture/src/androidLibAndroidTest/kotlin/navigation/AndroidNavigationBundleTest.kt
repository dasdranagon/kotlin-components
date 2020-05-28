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

package com.splendo.kaluga.architecture.navigation

import kotlin.test.assertEquals
import org.junit.Test

class AndroidNavigationBundleTest {

    @Test
    fun testConvertBundle() {
        val booleanValue = false
        val serializableValue = MockSerializable("Value")
        val nestedString = "NestedString"
        val nestedSpec = NestedSpec()
        val nestedBundle: NavigationBundle<NestedSpecRow<*>> = nestedSpec.toBundle { entry ->
            when (entry) {
                is NestedSpecRow.StringSpecRow -> entry.associatedType.convertValue(nestedString)
            }
        }
        val optionalString: String? = "Some String"
        val optionalFloat: Float? = null

        val mockSpec = MockSpec()
        val navigationBundle = mockSpec.toBundle { entry ->
            when (entry) {
                is MockSpecRow.BooleanSpecRow -> entry.associatedType.convertValue(booleanValue)
                is MockSpecRow.SerializableSpecRow -> entry.associatedType.convertValue(serializableValue)
                is MockSpecRow.NestedBundleSpecRow -> entry.associatedType.convertValue(nestedBundle)
                is MockSpecRow.OptionalString -> entry.associatedType.convertValue(optionalString)
                is MockSpecRow.OptionalFloat -> entry.associatedType.convertValue(optionalFloat)
            }
        }

        val bundle = navigationBundle.toBundle().toNavigationBundle(mockSpec)

        val booleanResult = bundle.get(MockSpecRow.BooleanSpecRow)
        val serializableResult = bundle.get(MockSpecRow.SerializableSpecRow)
        val bundleResult = bundle.get(MockSpecRow.NestedBundleSpecRow)
        val optionalStringResult = bundle.get(MockSpecRow.OptionalString)
        val optionalFloatResult = bundle.get(MockSpecRow.OptionalFloat)
        assertEquals(booleanValue, booleanResult)
        assertEquals(serializableValue, serializableResult)
        val nestedStringResult = bundleResult.get(NestedSpecRow.StringSpecRow)
        assertEquals(nestedString, nestedStringResult)
        assertEquals(optionalString, optionalStringResult)
        assertEquals(optionalFloat, optionalFloatResult)
    }
}
