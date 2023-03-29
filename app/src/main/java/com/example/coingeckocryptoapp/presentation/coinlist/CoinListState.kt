package com.example.coingeckocryptoapp.presentation.coinlist

import com.example.coingeckocryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coinList : List<Coin> = emptyList(),
    val error : String = ""
)