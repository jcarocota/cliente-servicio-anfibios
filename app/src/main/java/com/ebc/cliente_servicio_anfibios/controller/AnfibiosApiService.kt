package com.ebc.cliente_servicio_anfibios.controller

import com.ebc.cliente_servicio_anfibios.models.Anfibio
import retrofit2.http.GET

interface AnfibiosApiService {

    @GET("amphibians")
    suspend fun getAnfibios(): List<Anfibio>
}