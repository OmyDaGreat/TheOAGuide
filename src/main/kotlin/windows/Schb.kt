package windows

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.window.Window
import java.net.URI


/**
 * Composable function to display a popup window with an image of the schell bedules.
 * @param onCloseRequest Lambda function to handle the window close request.
 */
@Composable
fun Schb(onCloseRequest: () -> Unit) {
    Window(onCloseRequest = onCloseRequest, title = "Schell Bedules") {
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