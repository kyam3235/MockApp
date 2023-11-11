package jp.kyam.mockapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import jp.kyam.mockapp.ui.theme.MockAppTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val state = viewModel.collectAsState().value

    viewModel.collectSideEffect {
        //TODO SideEffectが必要な処理を追記
    }

    Greeting("Android")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MockAppTheme {
        Greeting("Android")
    }
}