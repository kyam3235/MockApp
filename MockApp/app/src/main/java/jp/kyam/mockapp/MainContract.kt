package jp.kyam.mockapp

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class MainState(
    val elevationValue: Dp = 0.dp
)

sealed class MainSideEffect {
    data class Toast(val text: String) : MainSideEffect()
}
