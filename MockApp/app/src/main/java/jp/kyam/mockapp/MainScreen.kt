package jp.kyam.mockapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import jp.kyam.mockapp.ui.theme.MockAppTheme
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import kotlin.math.roundToInt

@Composable
fun MainScreen(viewModel: MainViewModel) {
    val state = viewModel.collectAsState().value

    viewModel.collectSideEffect {
        //TODO SideEffectが必要な処理を追記
    }

    Contents(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        name = "Android",
        elevation = state.elevationValue,
        onElevationChanged = { elevation -> viewModel.onElevationChanged(elevation) }
    )
}

@Composable
fun Contents(
    modifier: Modifier = Modifier,
    name: String = "",
    elevation: Dp = 0.dp,
    onElevationChanged: (Dp) -> Unit = {}
) {
    Column(
        modifier = modifier
    ) {
        DummyButton(
            name = name,
            buttonElevation = ButtonDefaults.buttonElevation(
                defaultElevation = elevation
            )
        )
        ElevationSlider(
            onValueChanged = onElevationChanged
        )
    }
}

@Composable
fun DummyButton(
    modifier: Modifier = Modifier,
    name: String = "",
    buttonElevation: ButtonElevation = ButtonDefaults.buttonElevation()
) {
    Button(
        modifier = modifier,
        onClick = { /*Do nothing*/ },
        elevation = buttonElevation
    ) {
        Text(
            text = "Hello $name!"
        )
    }
}

@Composable
fun ElevationSlider(
    modifier: Modifier = Modifier,
    onValueChanged: (Dp) -> Unit = {}
) {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    val elevationTokens = listOf(0.dp, 1.dp, 3.dp, 6.dp, 8.dp, 12.dp)
    Column(
        modifier = modifier
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { value ->
                sliderPosition = value
                val position = value.roundToInt()
                onValueChanged(
                    elevationTokens[position]
                )
            },
            steps = 4,
            valueRange = 0f..5f
        )
        Text(
            text = "${elevationTokens[sliderPosition.roundToInt()]}"
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview(
    name: String = "Android"
) {
    Contents(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp),
        name = name
    )
}

@Preview(showBackground = true)
@Composable
fun DummyButtonPreview() {
    MockAppTheme {
        DummyButton(name = "Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ElevationSliderPreview() {
    MockAppTheme {
        ElevationSlider()
    }
}
