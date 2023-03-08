import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.href
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    val hexColor = randomHexColor()
    var color by mutableStateOf(hexColor)
    var nearestColorName by mutableStateOf(nearest(color))
    var nearestColorNameFA by mutableStateOf(nearest(color, Language.FARSI))
    var furthestColorName by mutableStateOf(furthest(color))

    renderComposable(rootElementId = "root") {
        Div({
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                backgroundColor(Color(color))
                backgroundSize("100% 100%")
                backgroundImageUrl("https://raw.githubusercontent.com/razavioo/colorname.ir/main/src/jsMain/resources/background-main.png")
                width(100.vw)
                height(100.vh)
            }
        }) {
            Div({
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Row)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    backgroundImageUrl("https://raw.githubusercontent.com/razavioo/colorname.ir/main/src/jsMain/resources/background-top-bar.svg")
                    width(100.percent)
                    height(72.px)
                }
            }) {
                Div({
                    style {
                        display(DisplayStyle.Flex)
                        flex(1)
                        justifyContent(JustifyContent.Start)
                        alignItems(AlignItems.Center)
                        marginLeft(120.px)
                    }
                }) {
                    Span {
                        Img(
                            src = "https://raw.githubusercontent.com/razavioo/colorname.ir/main/src/jsMain/resources/logo.png",
                            alt = "color-name-logo",
                            attrs = {
                                style {
                                    width(32.px)
                                    height(32.px)
                                }
                            }
                        )
                    }

                    Span(
                        {
                            style {
                                marginLeft(10.px)
                                color(Color.white)
                                fontSize(20.px)
                                fontFamily("Pacifico")
                            }
                        }
                    ) {
                        Text("ColorName")
                    }
                }

                Div({
                    style {
                        display(DisplayStyle.Flex)
                        justifyContent(JustifyContent.End)
                        alignItems(AlignItems.Center)
                        marginRight(120.px)
                    }
                }) {
                    Span({
                        style {
                            color(Color.white)
                            marginRight(10.px)
                        }
                    }) {
                        A(
                            attrs = {
                                href("https://github.com/razavioo/colorname.ir")
                                target(ATarget.Blank)
                            }
                        ) {
                            Img(
                                src = "https://raw.githubusercontent.com/razavioo/colorname.ir/main/src/jsMain/resources/github-mark-white.png",
                                alt = "github-logo",
                                attrs = {
                                    style {
                                        width(32.px)
                                        height(32.px)
                                    }
                                }
                            )
                        }
                    }
                }
            }

            Div({
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                    alignItems(AlignItems.Center)
                    justifyContent(JustifyContent.Center)
                    width(100.percent)
                    height(100.percent)
                }
            }) {
                Div({
                    style {
                        display(DisplayStyle.Flex)
                        flexDirection(FlexDirection.Column)
                        alignItems(AlignItems.Center)
                        justifyContent(JustifyContent.Center)
                        width(40.percent)
                        height(auto)
                        backgroundImageUrl("https://raw.githubusercontent.com/razavioo/colorname.ir/main/src/jsMain/resources/background-center-box.svg")
                        borderRadius(32.px)
                        padding(32.px)
                        paddingLeft(64.px)
                        paddingRight(64.px)
                    }
                }) {
                    Div({
                        style {
                            display(DisplayStyle.Flex)
                            flexDirection(FlexDirection.Row)
                            alignItems(AlignItems.Center)
                            justifyContent(JustifyContent.Center)
                            width(100.percent)
                            height(auto)
                        }
                    }) {
                        P({
                            style {
                                color(Color.white)
                                fontSize(24.px)
                                fontFamily("Sanchez", "serif")
                            }
                        }) {
                            Text("Select a color to find it's name:")
                        }
                    }

                    Div({
                        style {
                            display(DisplayStyle.Flex)
                            flexDirection(FlexDirection.Row)
                            alignItems(AlignItems.Center)
                            justifyContent(JustifyContent.Center)
                            width(100.percent)
                            height(auto)
                        }
                    }) {
                        Div({
                            style {
                                position(Position.Relative)
                                width(120.px)
                                height(120.px)
                            }
                        }) {
                            Input(
                                type = InputType.Color,
                                attrs = {
                                    style {
                                        border {
                                            style(LineStyle.None)
                                        }

                                        width(100.percent)
                                        height(100.percent)
                                        position(Position.Absolute)
                                    }
                                    onInput { event ->
                                        color = event.value
                                        nearestColorName = nearest(color)
                                        nearestColorNameFA = nearest(color, Language.FARSI)
                                        furthestColorName = furthest(color)
                                    }
                                    value(color)
                                }
                            )

                            Span(
                                {
                                    style {
                                        color(Color.white)
                                        fontSize(15.px)
                                        position(Position.Absolute)
                                        bottom(0.px)
                                        left(0.px)
                                        right(0.px)
                                        margin(4.px)
                                        backgroundColor(Color.gray)
                                        padding(4.px)
                                        textAlign("center")
                                        fontFamily("Sanchez", "serif")
                                    }
                                }
                            ) {
                                Text(color.uppercase())
                            }
                        }
                    }

                    Div({
                        style {
                            display(DisplayStyle.Flex)
                            flexDirection(FlexDirection.Row)
                            alignItems(AlignItems.Center)
                            justifyContent(JustifyContent.Center)
                            width(100.percent)
                            height(auto)
                            marginTop(16.px)
                        }
                    }) {
                        P({
                            style {
                                color(Color.white)
                                fontFamily("Sanchez", "serif")
                            }
                        }) {
                            Text(nearestColorName.name)
                        }

                        Span({
                            style {
                                color(Color.white)
                                marginLeft(4.px)
                                fontFamily("Sanchez", "serif")
                            }
                        }) {
                            Text("(")
                        }

                        Span({
                            style {
                                color(Color.white)
                                fontFamily("Sanchez", "serif")
                            }
                        }) {
                            Text(nearestColorName.hex.uppercase())
                        }

                        Span({
                            style {
                                color(Color.white)
                                flex(1)
                                fontFamily("Sanchez", "serif")
                            }
                        }) {
                            Text(")")
                        }

                        Button(
                            attrs = {
                                style {
                                    width(32.px)
                                    height(32.px)
                                    borderRadius(4.px)
                                    border {
                                        style(LineStyle.Solid)
                                        width(2.px)
                                        color(Color.white)
                                    }
                                    backgroundColor(Color(nearestColorName.hex))
                                }
                                onClick {
                                    color = nearestColorName.hex
                                    nearestColorName = nearest(color)
                                    nearestColorNameFA = nearest(color, Language.FARSI)
                                    furthestColorName = furthest(color)
                                }
                            }
                        )
                    }

                    Div({
                        style {
                            display(DisplayStyle.Flex)
                            flexDirection(FlexDirection.Row)
                            alignItems(AlignItems.Center)
                            justifyContent(JustifyContent.Center)
                            width(100.percent)
                            height(auto)
                        }
                    }) {
                        P({
                            style {
                                color(Color.white)
                                fontFamily("Vazirmatn", "sans-serif")
                            }
                        }) {
                            Text(nearestColorNameFA.name)
                        }

                        Span({
                            style {
                                color(Color.white)
                                marginLeft(4.px)
                                fontFamily("Sanchez", "serif")
                            }
                        }) {
                            Text("(")
                        }

                        Span({
                            style {
                                color(Color.white)
                                fontFamily("Sanchez", "serif")
                            }
                        }) {
                            Text(nearestColorNameFA.hex.uppercase())
                        }

                        Span({
                            style {
                                color(Color.white)
                                flex(1)
                                fontFamily("Sanchez", "serif")
                            }
                        }) {
                            Text(")")
                        }

                        Button(
                            attrs = {
                                style {
                                    width(32.px)
                                    height(32.px)
                                    borderRadius(4.px)
                                    border {
                                        style(LineStyle.Solid)
                                        width(2.px)
                                        color(Color.white)
                                    }
                                    backgroundColor(Color(nearestColorNameFA.hex))
                                }
                                onClick {
                                    color = nearestColorNameFA.hex
                                    nearestColorName = nearest(color)
                                    nearestColorNameFA = nearest(color, Language.FARSI)
                                    furthestColorName = furthest(color)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

private fun randomHexColor() = "#${(0..0xFFFFFF).random().toString(16).padStart(6, '0')}"

fun StyleScope.backgroundImageUrl(value: String) {
    property("background-image", "url($value)")
}