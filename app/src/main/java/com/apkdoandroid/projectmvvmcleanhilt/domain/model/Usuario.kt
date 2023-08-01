package com.apkdoandroid.projectmvvmcleanhilt.domain.model

import com.apkdoandroid.projectmvvmcleanhilt.data.dto.UsuarioDTO

data class Usuario(
    val nome: String,
    val sobrenome: String,
    val idade: Int,
    val email: String,
    val telefone: String,
    val imagem: String
)

