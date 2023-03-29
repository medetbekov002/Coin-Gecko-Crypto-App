package com.example.coingeckocryptoapp.data.data_source

import com.example.coingeckocryptoapp.data.data_source.CoinDetailDTO.CoinDetailDTO
import com.example.coingeckocryptoapp.data.data_source.CoinListDTO.CoinListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinGeckoApi {

    @GET("/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=100&sparkline=false")
    suspend fun getAllCoins(@Query("page")page: String): CoinListDTO

    @GET("/api/v3/coins/{id}")
    suspend fun getCoinByID(@Path("id")id:String): CoinDetailDTO
}