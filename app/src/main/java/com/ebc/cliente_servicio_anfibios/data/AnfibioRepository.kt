package com.ebc.cliente_servicio_anfibios.data

import com.ebc.cliente_servicio_anfibios.controller.AnfibiosApiService
import com.ebc.cliente_servicio_anfibios.models.Anfibio

interface AnfibioRepository {
    suspend fun getAnfibios(): List<Anfibio>
}

class DefaultAnfibioRepository(
    private val anfibiosApiService: AnfibiosApiService
) : AnfibioRepository {

    override suspend fun getAnfibios(): List<Anfibio> {
        return anfibiosApiService.getAnfibios()
    }

}