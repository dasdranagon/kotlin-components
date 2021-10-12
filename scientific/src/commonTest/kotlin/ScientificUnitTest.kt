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
package com.splendo.kaluga.scientific

import com.splendo.kaluga.base.utils.times
import com.splendo.kaluga.base.utils.toDecimal
import com.splendo.kaluga.base.utils.toDouble
import kotlin.test.Test
import kotlin.test.assertEquals

class ScientificUnitTest {

    private val unitTranslationErrorTolerance = 0.000001

    @Test
    fun weighConversionTest() {
        assertForWeight(1000, Microgram, Kilogram, 1e-9)
        assertForWeight(1000, Milligram, Kilogram, 1e-6)
        assertForWeight(1000, Gram, Kilogram, 0.001)
        assertForWeight(1000, Tonne, Kilogram, 1000.0)
        assertForWeight(1000, Dram, Kilogram, 0.0017718451953125, unitTranslationErrorTolerance)
        assertForWeight(1000, Grain, Kilogram, 0.00006479891, unitTranslationErrorTolerance)
        assertForWeight(1000, Ounce, Kilogram, 0.028349523125, unitTranslationErrorTolerance)
        assertForWeight(1000, Pound, Kilogram, 0.45359237, unitTranslationErrorTolerance)
        assertForWeight(1000, Stone, Kilogram, 6.35029318, unitTranslationErrorTolerance)
        assertForWeight(1000, UsTon, Kilogram, 907.18474, unitTranslationErrorTolerance)
        assertForWeight(1000, ImperialTon, Kilogram, 1016.0469088, unitTranslationErrorTolerance)

        assertForWeight(1000, Kilogram, Microgram, 1.0E9)
        assertForWeight(1000, Kilogram, Milligram, 1000000.0)
        assertForWeight(1000, Kilogram, Gram, 1000.0)
        assertForWeight(1000, Kilogram, Tonne, 0.001)
        assertForWeight(1000, Kilogram, Dram, 564.3833911932866, unitTranslationErrorTolerance)
        assertForWeight(1000, Kilogram, Grain, 15432.358352941432, unitTranslationErrorTolerance)
        assertForWeight(1000, Kilogram, Ounce, 35.27396194958041, unitTranslationErrorTolerance)
        assertForWeight(1000, Kilogram, Pound, 2.204622621848776, unitTranslationErrorTolerance)
        assertForWeight(1000, Kilogram, Stone, 0.1574730444177697, unitTranslationErrorTolerance)
        assertForWeight(1000, Kilogram, UsTon, 0.001102311310924, unitTranslationErrorTolerance)
        assertForWeight(1000, Kilogram, ImperialTon, 0.000984206527611, unitTranslationErrorTolerance)
    }

    @Test
    fun temperatureConversionTest() {
        assertEquals(Celsius.convert(0.0.toDecimal(), Fahrenheit).toDouble(), 32.0, unitTranslationErrorTolerance)
        assertEquals(Celsius.convert(0.0.toDecimal(), Kelvin).toDouble(), 273.15, unitTranslationErrorTolerance)

        assertEquals(Fahrenheit.convert(0.0.toDecimal(), Kelvin).toDouble(), 255.372222, unitTranslationErrorTolerance)
        assertEquals(Fahrenheit.convert(0.0.toDecimal(), Celsius).toDouble(), -17.777778, unitTranslationErrorTolerance)

        assertEquals(Kelvin.convert(0.0.toDecimal(), Fahrenheit).toDouble(), -459.67, unitTranslationErrorTolerance)
        assertEquals(Kelvin.convert(0.0.toDecimal(), Celsius).toDouble(), -273.15, unitTranslationErrorTolerance)
    }

    @Test
    fun lengthConversionTest() {
        assertForLength(1000, Millimeter, Meter, 0.001)
        assertForLength(1000, Centimeter, Meter, 0.01)
        assertForLength(1000, Decimeter, Meter, 0.1)
        assertForLength(1000, Decameter, Meter, 10.0)
        assertForLength(1000, Hectometer, Meter, 100.0)
        assertForLength(1000, Kilometer, Meter, 1000.0)
        assertForLength(1000, Inch, Meter, 0.0254, unitTranslationErrorTolerance)
        assertForLength(1000, Foot, Meter, 0.3048, unitTranslationErrorTolerance)
        assertForLength(1000, Yard, Meter, 0.9144, unitTranslationErrorTolerance)
        assertForLength(1000, Mile, Meter, 1609.344, unitTranslationErrorTolerance)

        assertForLength(1000, Meter, Millimeter, 1000.0)
        assertForLength(1000, Meter, Centimeter, 100.0)
        assertForLength(1000, Meter, Decimeter, 10.0)
        assertForLength(1000, Meter, Hectometer, 0.01)
        assertForLength(1000, Meter, Kilometer, 0.001)
        assertForLength(1000, Meter, Inch, 39.37007874, unitTranslationErrorTolerance)
        assertForLength(1000, Meter, Foot, 3.280839895, unitTranslationErrorTolerance)
        assertForLength(1000, Meter, Yard, 1.0936132983, unitTranslationErrorTolerance)
        assertForLength(1000, Meter, Mile, 0.000621371, unitTranslationErrorTolerance)
    }

    @Test
    fun volumeConversionTest() {
        assertForVolume(1000, Milliliter, CubicMeter, 1e-6)
        assertForVolume(1000, Liter, CubicMeter, 0.001)
        assertForVolume(1000, CubicInch, CubicMeter, 0.000016387064, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicFoot, CubicMeter, 0.028316846592, unitTranslationErrorTolerance)
        assertForVolume(1000, UsFluidDram, CubicMeter, 0.000003696691195313, unitTranslationErrorTolerance)
        assertForVolume(1000, ImperialFluidDram, CubicMeter, 0.0000035516328125, unitTranslationErrorTolerance)
        assertForVolume(1000, UsFluidOunce, CubicMeter, 0.0000295735295625, unitTranslationErrorTolerance)
        assertForVolume(1000, ImperialFluidOunce, CubicMeter, 0.0000284130625, unitTranslationErrorTolerance)
        assertForVolume(1000, UsLegalCup, CubicMeter, 0.0002365882365, unitTranslationErrorTolerance)
        assertForVolume(1000, ImperialCup, CubicMeter, 0.00025, unitTranslationErrorTolerance)
        assertForVolume(1000, UsLiquidPint, CubicMeter, 0.000473176473, unitTranslationErrorTolerance)
        assertForVolume(1000, ImperialPint, CubicMeter, 0.00056826125, unitTranslationErrorTolerance)
        assertForVolume(1000, UsLiquidQuart, CubicMeter, 0.000946352946, unitTranslationErrorTolerance)
        assertForVolume(1000, ImperialQuart, CubicMeter, 0.0011365225, unitTranslationErrorTolerance)
        assertForVolume(1000, UsLiquidGallon, CubicMeter, 0.003785411784, unitTranslationErrorTolerance)
        assertForVolume(1000, ImperialGallon, CubicMeter, 0.00454609, unitTranslationErrorTolerance)

        assertForVolume(1000, CubicMeter, Milliliter, 1e+6)
        assertForVolume(1000, CubicMeter, Liter, 1000.0)
        assertForVolume(1000, CubicMeter, CubicInch, 61023.74409473229, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, CubicFoot, 35.31466672148859, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, UsFluidDram, 270512.18161474395, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, ImperialFluidDram, 281560.63782283233, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, UsFluidOunce, 33814.022701842994, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, ImperialFluidOunce, 35195.07972785405, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, UsLegalCup, 4226.752837730375, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, ImperialCup, 4000.0, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, UsLiquidPint, 2113.376418865187, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, ImperialPint, 1759.753986392702, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, UsLiquidQuart, 1056.688209432594, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, ImperialQuart, 879.8769931963512, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, UsLiquidGallon, 264.1720523581484, unitTranslationErrorTolerance)
        assertForVolume(1000, CubicMeter, ImperialGallon, 219.96924829908778, unitTranslationErrorTolerance)
    }
}

fun assertForLength(
    max: Int,
    inputUnit: ScientificUnit<*, MeasurementType.Length>,
    outputUnit: ScientificUnit<*, MeasurementType.Length>,
    inputToOutputRatio: Double,
    tolerance: Double = 0.0
) {
    for (i in 1..max) {
        val actual = inputToOutputRatio.toDecimal() * i.toDouble().toDecimal()
        assertEquals(
            inputUnit.convert(i.toDouble().toDecimal(), outputUnit).toDouble(),
            actual.toDouble(),
            tolerance
        )
    }
}

fun assertForVolume(
    max: Int,
    inputUnit: ScientificUnit<*, MeasurementType.Volume>,
    outputUnit: ScientificUnit<*, MeasurementType.Volume>,
    inputToOutputRatio: Double,
    tolerance: Double = 0.0
) {
    for (i in 1..max) {
        val actual = inputToOutputRatio.toDecimal() * i.toDouble().toDecimal()
        assertEquals(
            inputUnit.convert(i.toDouble().toDecimal(), outputUnit).toDouble(),
            actual.toDouble(),
            tolerance
        )
    }
}

fun assertForWeight(
    max: Int,
    inputUnit: ScientificUnit<*, MeasurementType.Weight>,
    outputUnit: ScientificUnit<*, MeasurementType.Weight>,
    inputToOutputRatio: Double,
    tolerance: Double = 0.0
) {
    for (i in 1..max) {
        val actual = inputToOutputRatio.toDecimal() * i.toDouble().toDecimal()
        assertEquals(
            inputUnit.convert(i.toDouble().toDecimal(), outputUnit).toDouble(),
            actual.toDouble(),
            tolerance
        )
    }
}
