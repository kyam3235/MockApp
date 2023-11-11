package jp.kyam.mockapp

data class MainState(
    val param: Int = 0
)

sealed class MainSideEffect {
    data class Toast(val text: String) : MainSideEffect()
}
