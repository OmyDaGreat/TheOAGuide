import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.net.URI

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    var state: String? = null
    var showPopup by remember { mutableStateOf(false) }

    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                state?.let {
                    text = "Hello, World!"
                    state = null
                } ?: run {
                    text = "Hello, Desktop!"
                    state = "California"
                }
                showPopup = true
            }) {
                Text(text)
            }
        }
    }

    if (showPopup) {
        PopupWindow(onCloseRequest = { showPopup = false })
    }
}

@Composable
fun PopupWindow(onCloseRequest: () -> Unit) {
    Window(onCloseRequest = onCloseRequest) {
        val imageUrl = "https://oxford.auhsd.us/files/user/5529/image/Screen-Shot-2023-06-29-at-12_58_28-PM.png"
        val imageBitmap: ImageBitmap = loadImageBitmap(URI(imageUrl).toURL().openStream())

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(bitmap = imageBitmap, contentDescription = "Popup Image")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = {}) {
        App()
    }
}