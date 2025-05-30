package com.ebc.cliente_servicio_anfibios

import android.app.Application
import com.ebc.cliente_servicio_anfibios.data.AnfibioContainer
import com.ebc.cliente_servicio_anfibios.data.DefaultAnfibioContainer

class AnfibiosApplication: Application() {
    lateinit var container: AnfibioContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAnfibioContainer()
    }
}