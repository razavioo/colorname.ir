import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
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
                    backgroundColor(Color("#AAAAAA"))
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
                                color(Color("#FFFFFF"))
                            }
                        }
                    ) {
                        Text("Color Name")
                    }
                }

                Div({
                    style {
                        display(DisplayStyle.Flex)
                        flex(1)
                        justifyContent(JustifyContent.End)
                        alignItems(AlignItems.Center)
                        marginRight(120.px)
                    }
                }) {
                    Span({
                        style {
                            color(Color("#FFFFFF"))
                            marginRight(10.px)
                        }
                    }) {
                        Text("Github")
                    }

                    Span({
                        style {
                            color(Color("#FFFFFF"))
                        }
                    }) {
                        Text("Source Code")
                    }
                }
            }
            Div({
                style {
                    flexDirection(FlexDirection.Row)
                    alignItems(AlignItems.Center)
                }
            }) {
                Input(
                    type = InputType.Color,
                    attrs = {
                        style {
                            width(100.px)
                            height(100.px)
                        }
                        onInput { event ->
                            color = event.value
                            nearestColorName = nearest(color)
                            nearestColorNameFA = nearest(color, Language.FARSI)
                            furthestColorName = furthest(color)
                        }
                    }
                )

                Span({
                    style {
                        color(Color(nearestColorName.hex))
                        marginLeft(10.px)
                    }
                }) {
                    Text(nearestColorName.name)
                }

                Span({
                    style {
                        color(Color(nearestColorNameFA.hex))
                        marginLeft(10.px)
                    }
                }) {
                    Text(nearestColorNameFA.name)
                }
            }
        }
    }
}