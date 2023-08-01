package com.apkdoandroid.projectmvvmcleanhilt.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apkdoandroid.projectmvvmcleanhilt.domain.model.Usuario
import com.apkdoandroid.projectmvvmcleanhilt.domain.usercase.GetUsuariosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsuariosViewModel @Inject constructor(private  val usuariosUseCase: GetUsuariosUseCase) : ViewModel() {

    private val _usuarios = MutableLiveData<List<Usuario>>()

    val usuarios : LiveData<List<Usuario>>
        get() = _usuarios

    init {
        recuperarUsuarios()
    }


    fun recuperarUsuarios(){
        viewModelScope.launch {
            val listaUsuarios = usuariosUseCase()
            _usuarios.value = listaUsuarios
        }
    }
}