package com.example.coingeckocryptoapp.di

import com.example.coingeckocryptoapp.data.data_source.CoinGeckoApi
import com.example.coingeckocryptoapp.data.repository.CoinRepositoryImpl
import com.example.coingeckocryptoapp.domain.repository.CoinRepository
import com.example.coingeckocryptoapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoinGeckoModule {

    @Provides
    @Singleton
    fun provideCoinGeckoApi(): CoinGeckoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinGeckoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinGeckoRepository(api: CoinGeckoApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}