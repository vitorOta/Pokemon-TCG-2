package com.vitorota.pokemontcg2.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientBuilder {
    private val baseUrl = "https://api.pokemontcg.io/v2/"
    private val baseGson = GsonBuilder().setDateFormat("YYYY/MM/dd HH:mm:ss").create()
    private val baseClientHttp = OkHttpClient.Builder().build()

    fun <T> createApi(
        apiInterface: Class<T>
    ): T {
        val client = baseClientHttp.newBuilder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(baseGson))
            .build()

        return retrofit.create(apiInterface)
    }
}