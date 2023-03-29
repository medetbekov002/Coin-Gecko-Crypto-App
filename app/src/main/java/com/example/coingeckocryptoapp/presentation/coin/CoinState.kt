package com.example.coingeckocryptoapp.presentation.coin

import com.example.coingeckocryptoapp.domain.model.CoinDetail


data class CoinState(
    val isLoading: Boolean = false,
    val coinDetail: CoinDetail? = null,
    val error : String = ""
)
