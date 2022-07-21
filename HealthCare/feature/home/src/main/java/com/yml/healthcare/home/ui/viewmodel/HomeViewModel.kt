package com.yml.healthcare.home.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yml.healthcare.home.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val homeRepository: HomeRepository) : ViewModel() {

/*    // Create Initial State of View
    private val initialState: HomeViewState by lazy {  }*/

    private val _viewState: MutableStateFlow<HomeViewState> =
        MutableStateFlow(HomeViewState.UnInitialized())
    val viewState get() = _viewState.asStateFlow()

    private val intent: MutableSharedFlow<HomeUserIntent> = MutableSharedFlow()

    private val _effect: Channel<HomeEffect> = Channel()
    val homeEffect
        get() = _effect.receiveAsFlow()

    init {
        subscribeIntent()
    }

    /**
     * Start listening to Intent
     */
    private fun subscribeIntent() {
        viewModelScope.launch {
            intent.collect {
                handleUserIntent(it)
            }
        }
    }

    /**
     * Set new UserIntent
     */
    fun performAction(intent: HomeUserIntent) {
        viewModelScope.launch {
            this@HomeViewModel.intent.emit(intent)
        }
    }

    /**
     * Emit new ViewState
     */
    private fun emitViewState(reduce: HomeViewState.() -> HomeViewState) {
        val newState = viewState.value.reduce()
        _viewState.value = newState
    }

    /**
     * Set new NavEffect
     */
    private fun sendNavEffect(builder: () -> HomeEffect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }

    private fun handleUserIntent(intent: HomeUserIntent) {
        when (intent) {
            HomeUserIntent.FetchHomeData -> {
                emitViewState {
                    HomeViewState.InitialLoading()
                }
                viewModelScope.launch {
                    val list = homeRepository.fetchHomeData()
                    emitViewState {
                        HomeViewState.Loaded(list)
                    }
                }
            }
        }
    }

}