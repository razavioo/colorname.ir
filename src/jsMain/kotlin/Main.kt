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
    var color by mutableStateOf("#AAAAAA")
    var nearestColorName by mutableStateOf(nearest(color))
    var nearestColorNameFA by mutableStateOf(nearest(color, Language.FARSI))
    var furthestColorName by mutableStateOf(furthest(color))

    renderComposable(rootElementId = "root") {
        Div({
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                backgroundColor(Color(furthestColorName.hex))
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
                    backgroundImageUrl("https://raw.githubusercontent.com/razavioo/colorname.ir/main/src/jsMain/resources/top-bar-filter.png")
                    width(100.vw)
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
                                    width(40.px)
                                    height(40.px)
                                }
                            }
                        )
                    }

                    Span(
                        {
                            style {
                                marginLeft(10.px)
                                color(Color.white)
                                fontSize(24.px)
                            }
                        }
                    ) {
                        Text("Color Name")
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
                                        width(40.px)
                                        height(40.px)
                                    }
                                }
                            )
                        }
                    }

                    Span({
                        style {
                            color(Color.white)
                            fontSize(24.px)
                        }
                    }) {
                        A(
                            attrs = {
                                href("https://github.com/razavioo/colorname.ir")
                                target(ATarget.Blank)
                            }
                        ) {
                            Text("Source Code")
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
                    backgroundSize("100% 100%")
                    backgroundImageUrl("https://raw.githubusercontent.com/razavioo/colorname.ir/main/src/jsMain/resources/background-main.png")
                    width(100.vw)
                    height(100.vh)
                }
            }) {
                Div({
                    style {
                        display(DisplayStyle.Flex)
                        flexDirection(FlexDirection.Column)
                        alignItems(AlignItems.Center)
                        justifyContent(JustifyContent.Center)
                        width(500.px)
                        height(auto)
                        backgroundImageUrl("https://raw.githubusercontent.com/razavioo/colorname.ir/ef1a34cc276efce76349b11044de687c54b7e45e/src/jsMain/resources/background-center-box.svg")
                        borderRadius(32.px)
                        padding(10.px)
                    }
                }) {
                    Div({
                        style {
                            display(DisplayStyle.Flex)
                            flexDirection(FlexDirection.Row)
                            alignItems(AlignItems.Center)
                            justifyContent(JustifyContent.Center)
                            width(100.vw)
                            height(auto)
                        }
                    }) {
                        P({
                            style {
                                color(Color.white)
                            }
                        }) {
                            Text("Select a color to know it's name:")
                        }
                    }

                    Div({
                        style {
                            display(DisplayStyle.Flex)
                            flexDirection(FlexDirection.Row)
                            alignItems(AlignItems.Center)
                            justifyContent(JustifyContent.Center)
                            width(100.vw)
                            height(auto)
                        }
                    }) {
                        Input(
                            type = InputType.Color,
                            attrs = {
                                style {
                                    width(120.px)
                                    height(120.px)
                                    border {
                                        style(LineStyle.None)
                                    }
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
                    }

                    Div({
                        style {
                            display(DisplayStyle.Flex)
                            flexDirection(FlexDirection.Row)
                            alignItems(AlignItems.Center)
                            justifyContent(JustifyContent.Center)
                            width(100.vw)
                            height(auto)
                        }
                    }) {
                        P({
                            style {
                                color(Color.white)
                            }
                        }) {
                            Text(nearestColorName.name)
                        }

                        Input(
                            type = InputType.Color,
                            attrs = {
                                style {
                                    width(32.px)
                                    height(32.px)
                                    border {
                                        style(LineStyle.None)
                                    }
                                }
                                onInput { event ->
                                    color = event.value
                                    nearestColorName = nearest(color)
                                    nearestColorNameFA = nearest(color, Language.FARSI)
                                    furthestColorName = furthest(color)
                                }
                                value(nearestColorName.hex)
                            }
                        )
                    }

                    Div({
                        style {
                            display(DisplayStyle.Flex)
                            flexDirection(FlexDirection.Row)
                            alignItems(AlignItems.Center)
                            justifyContent(JustifyContent.Center)
                            width(100.vw)
                            height(auto)
                        }
                    }) {
                        P({
                            style {
                                color(Color.white)
                            }
                        }) {
                            Text(nearestColorNameFA.name)
                        }

                        Input(
                            type = InputType.Color,
                            attrs = {
                                style {
                                    width(32.px)
                                    height(32.px)
                                    border {
                                        style(LineStyle.None)
                                    }
                                }
                                onInput { event ->
                                    color = event.value
                                    nearestColorName = nearest(color)
                                    nearestColorNameFA = nearest(color, Language.FARSI)
                                    furthestColorName = furthest(color)
                                }
                                value(nearestColorNameFA.hex)
                            }
                        )
                    }
                }
            }
        }
    }
}

fun StyleScope.backgroundImageUrl(value: String) {
    property("background-image", "url($value)")
}