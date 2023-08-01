package com.apkdoandroid.projectmvvmcleanhilt.domain.repository

import com.apkdoandroid.projectmvvmcleanhilt.domain.model.Usuario

interface UsuarioRepository {
    suspend fun recuperarUsuarios() : List<Usuario>
}