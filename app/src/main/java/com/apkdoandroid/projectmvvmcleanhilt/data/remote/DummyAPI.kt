package com.apkdoandroid.projectmvvmcleanhilt.data.remote

import com.apkdoandroid.projectmvvmcleanhilt.data.dto.ResultadoAPIDTO
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPI {

    // getUsers()
    @GET("users")
    suspend fun recuperarUsuarios() : Response< ResultadoAPIDTO >

}