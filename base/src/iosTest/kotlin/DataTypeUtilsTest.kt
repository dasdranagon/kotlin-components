/*
 Copyright (c) 2020. Splendo Consulting B.V. The Netherlands

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

import com.splendo.kaluga.test.BaseTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class DataTypeUtilsTest : BaseTest() {

    @Test
    fun testByteArrayConverter() {
        val byteArray = byteArrayOf(0x2F, 0x4A, 0x0, 0x01)
        val byteData = byteArray.toNSData()
        assertEquals(byteArray.size.toULong(), byteData.length)
        assertEquals(true, byteData.toByteArray().contentEquals(byteArray))
    }

    @Test
    fun testTypedArray() {
        val typedArray = listOf(1, 2, 3)
        val untypedArray: List<*> = typedArray
        val retypedArray: List<Int> = untypedArray.typedList()
        assertEquals(typedArray, retypedArray)
    }

    @Test
    fun testArrayTypedToWrongType() {
        val array: List<*> = listOf(1, "two", 3)
        val typedArray: List<String> = array.typedList()
        assertEquals(1, typedArray.size)
        assertEquals("two", typedArray[0])
    }

    @Test
    fun testTypedMap() {
        val typedMap = mapOf(1 to "one", 2 to "two", 3 to "three")
        val untypedMap: Map<*, *> = typedMap
        val retypedMap: Map<Int, String> = untypedMap.typedMap()
        assertEquals(typedMap, retypedMap)
    }

    @Test
    fun testMapTypedToWrongType() {
        val map: Map<*, *> = mapOf(1 to "one", "two" to 2, "three" to "three")
        val typedMap: Map<String, Int> = map.typedMap()
        assertEquals(1, typedMap.size)
        assertEquals(2, typedMap["two"])
    }

}

