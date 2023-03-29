package com.example.coingeckocryptoapp.domain.use_cases

import com.example.coingeckocryptoapp.domain.model.Coin
import com.example.coingeckocryptoapp.domain.repository.CoinRepository
import com.example.coingeckocryptoapp.utils.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class CoinListUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(page: String): Flow<ResponseState<List<Coin>>> = flow {
        try {
            emit(ResponseState.Loading<List<Coin>>())
            val coins = repository.getAllCoins(page).map {
                it.toCoin()
            }
            emit(ResponseState.Success<List<Coin>>(coins))
        }
        catch(e: HttpException) {
            emit(ResponseState.Error<List<Coin>>(e.localizedMessage?:"An Unexpected Error Occurred"))
        }
        catch(e: IOException) {
            emit(ResponseState.Error<List<Coin>>("Error Occurred"))
        }
    }
}