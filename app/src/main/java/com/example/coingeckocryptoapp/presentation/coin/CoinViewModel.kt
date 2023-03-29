package com.example.coingeckocryptoapp.presentation.coin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coingeckocryptoapp.domain.use_cases.CoinDetailUseCase
import com.example.coingeckocryptoapp.utils.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoinViewModel @Inject constructor(
    private val coinDetailUseCase: CoinDetailUseCase
) : ViewModel() {
    private val coinValue = MutableStateFlow(CoinState())
    val _coinState : StateFlow<CoinState> = coinValue

    fun getCoinByID(id: String)=viewModelScope.launch(Dispatchers.IO) {
        coinDetailUseCase(id).collect {
            when(it) {
                is ResponseState.Success -> {
                    coinValue.value = CoinState(coinDetail = it.data)
                }
                is ResponseState.Loading -> {
                    coinValue.value = CoinState(isLoading = true)
                }
                is ResponseState.Error -> {
                    coinValue.value = CoinState(error = it.message?: "An unexpected Error")
                }
            }
        }
    }
}