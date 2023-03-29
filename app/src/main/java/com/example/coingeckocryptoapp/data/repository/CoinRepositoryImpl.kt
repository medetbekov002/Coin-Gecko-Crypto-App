package com.example.coingeckocryptoapp.data.repository

import com.example.coingeckocryptoapp.data.data_source.CoinDetailDTO.CoinDetailDTO
import com.example.coingeckocryptoapp.data.data_source.CoinGeckoApi
import com.example.coingeckocryptoapp.data.data_source.CoinListDTO.CoinListDTO
import com.example.coingeckocryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinGeckoApi
) : CoinRepository {
    override suspend fun getAllCoins(page: String): CoinListDTO {
        return coinApi.getAllCoins(page = page)
    }

    override suspend fun getCoinByID(id: String): CoinDetailDTO {
        return coinApi.getCoinByID(id = id)
    }
}