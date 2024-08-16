import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import windows.*

/**
 * Main composable function for the application.
 * Displays buttons to show a popup image and AP Guides in separate windows.
 */
@Composable
@Preview
fun App() {
    // State variables to control the visibility of the popup windows
    var showSchb by remember { mutableStateOf(false) }
    var showAPle by remember { mutableStateOf(false) }


    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                // Button to show the popup image window
                Button(onClick = {
                    showSchb = true
                }) {
                    Text("Show Popup")
                }
                // Button to show the AP Guides window
                Button(onClick = {
                    showAPle = true
                }) {
                    Text("Show AP Guides")
                }
                Button(onClick = {
                    showAizen = true
                }) {
                    Text("Show mr williams homework answers")
                }
            }
        }
    }

    // Conditionally display the popup image window
    if (showSchb) {
        Schb(onCloseRequest = { showSchb = false })
    }

    // Conditionally display the AP Guides window
    if (showAPle) {
        APle(onCloseRequest = { showAPle = false })
    }
}

/**
 * Main entry point of the application.
 * Sets up the main window and displays the App composable.
 */
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}