import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    var color by mutableStateOf("#AAAAAA")
    var nearestColorName by mutableStateOf(nearest(color))
    var nearestColorNameFA by mutableStateOf(nearest(color, Language.FARSI))
    var furthestColorName by mutableStateOf(furthest(color))

    renderComposable(rootElementId = "root") {
        Div({
            style {
                display(DisplayStyle.Block)
                backgroundColor(Color(furthestColorName.hex))
                width(100.vw)
                height(100.vh)
            }
        }) {
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