package com.ebc.cliente_servicio_anfibios.data

import com.ebc.cliente_servicio_anfibios.controller.AnfibiosApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AnfibioContainer {
    val anfibioRepository: AnfibioRepository
}

class DefaultAnfibioContainer: AnfibioContainer {
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: AnfibiosApiService by lazy {
        retrofit.create(AnfibiosApiService::class.java)
    }

    override val anfibioRepository: AnfibioRepository by lazy {
        DefaultAnfibioRepository(retrofitService)
    }

}