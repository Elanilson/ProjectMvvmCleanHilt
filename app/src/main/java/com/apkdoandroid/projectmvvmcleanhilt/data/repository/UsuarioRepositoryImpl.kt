package com.apkdoandroid.projectmvvmcleanhilt.data.repository

import android.util.Log
import com.apkdoandroid.projectmvvmcleanhilt.data.dto.toUsuario
import com.apkdoandroid.projectmvvmcleanhilt.data.remote.DummyAPI
import com.apkdoandroid.projectmvvmcleanhilt.domain.model.Usuario
import com.apkdoandroid.projectmvvmcleanhilt.domain.repository.UsuarioRepository
import javax.inject.Inject

class UsuarioRepositoryImpl @Inject constructor(
    private val dummyApi: DummyAPI
) : UsuarioRepository {
    override suspend fun recuperarUsuarios(): List<Usuario> {
        try {

            val resposta = dummyApi.recuperarUsuarios()
            if( resposta.isSuccessful && resposta.body() != null ){
                val resultadoAPIDTO = resposta.body()
                val listaUsuarios = resultadoAPIDTO?.users
                if( listaUsuarios != null ){
                    /*val usuarios = listaUsuarios.map {
                        usuarioDTO.toUsuario()
                    }*/
                    return listaUsuarios.map { it.toUsuario() }
                }
            }else{
                Log.i("lista_usuarios", "${resposta.message()}")
            }

        }catch (erroRecuperarUsuarios: Exception){
            erroRecuperarUsuarios.printStackTrace()
        }
        return emptyList()
    }
}