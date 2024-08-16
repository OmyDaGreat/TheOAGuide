package windows

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.window.Window

/**
 * Composable function to display a window with links to AP guides.
 * @param onCloseRequest Lambda function to handle the window close request.
 */
@Composable
fun APle(onCloseRequest: () -> Unit) {
    Window(onCloseRequest = onCloseRequest, title = "AP Guides") {
        val uriHandler = LocalUriHandler.current
        val links = remember {
            listOf(
                "https://example.com/ap-guide-1",
                "https://example.com/ap-guide-2",
                "https://example.com/ap-guide-3"
            )
        }

        MaterialTheme {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                links.forEach { link ->
                    Text(
                        text = AnnotatedString(link),
                        modifier = Modifier.clickable { uriHandler.openUri(link) }
                    )
                }
            }
        }
    }
}