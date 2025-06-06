package com.ebc.cliente_servicio_anfibios.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.ebc.cliente_servicio_anfibios.AnfibiosApplication
import com.ebc.cliente_servicio_anfibios.data.AnfibioRepository
import com.ebc.cliente_servicio_anfibios.models.Anfibio
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface AnfibioUiState {
    data class Success(val anfibios: List<Anfibio>) : AnfibioUiState
    object Error : AnfibioUiState
    object Loading : AnfibioUiState
}

class AnfibiosViewModel(private val anfibioRepository: AnfibioRepository): ViewModel() {

    var amphibiansUiState: AnfibioUiState by mutableStateOf(AnfibioUiState.Loading)
        private set

    init {
        getAnfibios()
    }

    fun getAnfibios() {
        viewModelScope.launch {
            amphibiansUiState = AnfibioUiState.Loading
            amphibiansUiState = try {
                AnfibioUiState.Success(anfibioRepository.getAnfibios())
            } catch (e: IOException) {
                AnfibioUiState.Error
            } catch (e: HttpException) {
                AnfibioUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as AnfibiosApplication)
                val anfibioRepository = application.container.anfibioRepository
                AnfibiosViewModel(anfibioRepository = anfibioRepository)
            }
        }
    }

}