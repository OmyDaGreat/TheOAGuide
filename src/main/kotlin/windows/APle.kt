package windows

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
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
            mapOf(
                "AP Euro, World, US, & Gov" to "https://www.youtube.com/@heimlershistory",
                "AP CSA" to "https://example.com/ap-guide-2",
                "AP CSP" to "https://example.com/ap-guide-3"
            )
        }

        MaterialTheme {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    links.forEach { (name, link) ->
                        Button(onClick = { uriHandler.openUri(link) }) {
                            Text(text = name)
                        }
                    }
                }
            }
        }
    }
}