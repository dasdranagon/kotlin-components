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

package com.splendo.kaluga.resources.uikit

import com.splendo.kaluga.resources.stylable.BackgroundStyle
import com.splendo.kaluga.resources.stylable.GradientStyle
import kotlinx.cinterop.CValue
import kotlinx.cinterop.useContents
import platform.CoreFoundation.CFRetain
import platform.CoreGraphics.CGColorRef
import platform.CoreGraphics.CGFloat
import platform.CoreGraphics.CGPathRef
import platform.CoreGraphics.CGPointMake
import platform.CoreGraphics.CGRect
import platform.CoreGraphics.CGSizeMake
import platform.Foundation.CFBridgingRelease
import platform.QuartzCore.CAGradientLayer
import platform.QuartzCore.CALayer
import platform.QuartzCore.CAShapeLayer
import platform.QuartzCore.kCAGradientLayerAxial
import platform.QuartzCore.kCAGradientLayerConic
import platform.QuartzCore.kCAGradientLayerRadial
import platform.UIKit.UIBezierPath
import platform.UIKit.UIColor
import platform.UIKit.UIRectCornerBottomLeft
import platform.UIKit.UIRectCornerBottomRight
import platform.UIKit.UIRectCornerTopLeft
import platform.UIKit.UIRectCornerTopRight
import platform.UIKit.UIView

fun UIView.applyBackgroundStyle(style: BackgroundStyle) = layer.applyBackgroundStyle(style, bounds)

fun CALayer.applyBackgroundStyle(style: BackgroundStyle, bounds: CValue<CGRect>) = apply {
    val maskPath = pathForShape(style.shape, bounds)
    mask = CAShapeLayer(this).apply {
        frame = bounds
        path = maskPath
    }
    applyFillStyle(style.fillStyle, bounds)
    applyStroke(style.strokeStyle, maskPath, bounds)
}

private fun pathForShape(shape: BackgroundStyle.Shape, bounds: CValue<CGRect>): CGPathRef? =
    when (shape) {
        is BackgroundStyle.Shape.Rectangle -> UIBezierPath.bezierPathWithRoundedRect(
            bounds,
            shape.roundedCorners.fold(0U) { acc, corner ->
                acc or when (corner) {
                    BackgroundStyle.Shape.Rectangle.Corner.TOP_LEFT -> UIRectCornerTopLeft
                    BackgroundStyle.Shape.Rectangle.Corner.TOP_RIGHT -> UIRectCornerTopRight
                    BackgroundStyle.Shape.Rectangle.Corner.BOTTOM_LEFT -> UIRectCornerBottomLeft
                    BackgroundStyle.Shape.Rectangle.Corner.BOTTOM_RIGHT -> UIRectCornerBottomRight
                }
            },
            CGSizeMake(
                shape.cornerRadiusX.toDouble() as CGFloat,
                shape.cornerRadiusY.toDouble() as CGFloat
            )
        )
        is BackgroundStyle.Shape.Oval -> UIBezierPath.bezierPathWithOvalInRect(bounds)
    }.CGPath

private fun CALayer.applyFillStyle(fillStyle: BackgroundStyle.FillStyle, bounds: CValue<CGRect>) {
    addSublayer(
        CAGradientLayer(this).apply {
            frame = bounds
            when (fillStyle) {
                is BackgroundStyle.FillStyle.Solid -> {
                    type = kCAGradientLayerAxial
                    colors = listOfNotNull(
                        fillStyle.color.uiColor.CGColor,
                        fillStyle.color.uiColor.CGColor
                    ).mapToCGColor()
                }
                is BackgroundStyle.FillStyle.Gradient -> {
                    val sortedColorPoints =
                        fillStyle.gradientStyle.colorPoints.sortedBy { it.offset }
                    colors =
                        sortedColorPoints.mapNotNull { it.color.uiColor.CGColor }.mapToCGColor()
                    locations = sortedColorPoints.map { it.offset }
                    applyGradientStyle(fillStyle.gradientStyle, bounds)
                }
            }
        }
    )
}

fun List<CGColorRef>.mapToCGColor() = map {
    CFBridgingRelease(CFRetain(it))
}

private fun CAGradientLayer.applyGradientStyle(
    gradientStyle: GradientStyle,
    bounds: CValue<CGRect>
) = when (gradientStyle) {
    is GradientStyle.Linear -> {
        type = kCAGradientLayerAxial
        val startAndEndPoint = when (gradientStyle.orientation) {
            GradientStyle.Linear.Orientation.TOP_LEFT_BOTTOM_RIGHT -> Pair(
                CGPointMake(0.0 as CGFloat, 0.0 as CGFloat),
                CGPointMake(1.0 as CGFloat, 1.0 as CGFloat)
            )
            GradientStyle.Linear.Orientation.TOP_RIGHT_BOTTOM_LEFT -> Pair(
                CGPointMake(1.0 as CGFloat, 0.0 as CGFloat),
                CGPointMake(0.0 as CGFloat, 0.0 as CGFloat)
            )
            GradientStyle.Linear.Orientation.TOP_BOTTOM -> Pair(
                CGPointMake(0.5 as CGFloat, 0.0 as CGFloat),
                CGPointMake(0.5 as CGFloat, 1.0 as CGFloat)
            )
            GradientStyle.Linear.Orientation.LEFT_RIGHT -> Pair(
                CGPointMake(0.0 as CGFloat, 0.5 as CGFloat),
                CGPointMake(1.0 as CGFloat, 0.5 as CGFloat)
            )
            GradientStyle.Linear.Orientation.BOTTOM_LEFT_TOP_RIGHT -> Pair(
                CGPointMake(0.0 as CGFloat, 1.0 as CGFloat),
                CGPointMake(1.0 as CGFloat, 0.0 as CGFloat)
            )
            GradientStyle.Linear.Orientation.BOTTOM_RIGHT_TOP_LEFT -> Pair(
                CGPointMake(1.0 as CGFloat, 1.0 as CGFloat),
                CGPointMake(0.0 as CGFloat, 0.0 as CGFloat)
            )
            GradientStyle.Linear.Orientation.BOTTOM_TOP -> Pair(
                CGPointMake(0.5 as CGFloat, 1.0 as CGFloat),
                CGPointMake(0.5 as CGFloat, 0.0 as CGFloat)
            )
            GradientStyle.Linear.Orientation.RIGHT_LEFT -> Pair(
                CGPointMake(1.0 as CGFloat, 0.5 as CGFloat),
                CGPointMake(0.0 as CGFloat, 0.5 as CGFloat)
            )
        }
        startPoint = startAndEndPoint.first
        endPoint = startAndEndPoint.second
    }
    is GradientStyle.Radial -> {
        type = kCAGradientLayerRadial
        startPoint = CGPointMake(
            gradientStyle.centerPoint.x.toDouble() as CGFloat,
            gradientStyle.centerPoint.y.toDouble() as CGFloat
        )
        endPoint = CGPointMake(
            gradientStyle.centerPoint.x.toDouble() as CGFloat + (gradientStyle.radius / bounds.useContents { size.width }),
            gradientStyle.centerPoint.y.toDouble() as CGFloat + (gradientStyle.radius / bounds.useContents { size.height })
        )
    }
    is GradientStyle.Angular -> {
        type = kCAGradientLayerConic
        startPoint = CGPointMake(gradientStyle.centerPoint.x.toDouble() as CGFloat, gradientStyle.centerPoint.y.toDouble() as CGFloat)
        endPoint = CGPointMake(1.0 as CGFloat, gradientStyle.centerPoint.y.toDouble() as CGFloat)
    }
}

private fun CALayer.applyStroke(
    strokeStyle: BackgroundStyle.StrokeStyle,
    path: CGPathRef?,
    bounds: CValue<CGRect>
) {
    addSublayer(
        CAShapeLayer(this).apply {
            frame = bounds
            this.path = path
            when (strokeStyle) {
                is BackgroundStyle.StrokeStyle.Stroke -> {
                    lineWidth = strokeStyle.width.toDouble() as CGFloat
                    strokeColor = strokeStyle.color.uiColor.CGColor
                }
                is BackgroundStyle.StrokeStyle.None -> {
                    lineWidth = 0.0 as CGFloat
                    strokeColor = UIColor.clearColor.CGColor
                }
            }
            fillColor = null
        }
    )
}
