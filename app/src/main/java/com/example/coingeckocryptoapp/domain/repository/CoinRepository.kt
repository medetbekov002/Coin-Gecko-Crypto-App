package com.example.coingeckocryptoapp.domain.repository

import com.example.coingeckocryptoapp.data.data_source.CoinDetailDTO.CoinDetailDTO
import com.example.coingeckocryptoapp.data.data_source.CoinListDTO.CoinListDTO

interface CoinRepository {

    suspend fun getAllCoins(page: String): CoinListDTO

    suspend fun getCoinByID(page: String): CoinDetailDTO
}