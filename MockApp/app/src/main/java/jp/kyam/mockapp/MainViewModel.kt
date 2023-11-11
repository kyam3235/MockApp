package jp.kyam.mockapp

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ContainerHost<MainState, MainSideEffect>, ViewModel() {
    override val container = container<MainState, MainSideEffect>(MainState())

    // TODO 以下にメソッドを追加
}