package com.apkdoandroid.projectmvvmcleanhilt.di

import com.apkdoandroid.projectmvvmcleanhilt.data.remote.DummyAPI
import com.apkdoandroid.projectmvvmcleanhilt.data.repository.UsuarioRepositoryImpl
import com.apkdoandroid.projectmvvmcleanhilt.domain.repository.UsuarioRepository
import com.apkdoandroid.projectmvvmcleanhilt.domain.usercase.GetUsuariosUseCase
import com.apkdoandroid.projectmvvmcleanhilt.util.Constantes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn( ViewModelComponent::class )
object AppModulo {

    //provide
    @Provides
    fun proverRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl( Constantes.BASE_URL )
            .addConverterFactory( GsonConverterFactory.create() )
            .build()
    }

    @Provides
    fun proverDummyAPI(
        retrofit: Retrofit
    ) : DummyAPI {
        return retrofit.create( DummyAPI::class.java )
    }

    @Provides
    fun proverUsuarioRepository(
        dummyAPI: DummyAPI
    ) : UsuarioRepository {
        return UsuarioRepositoryImpl( dummyAPI )
    }

    @Provides
    fun proverUsuarioUseCase(
        usuarioRepository: UsuarioRepository
    ) : GetUsuariosUseCase {
        return GetUsuariosUseCase( usuarioRepository )
    }

    /*@Provides
    fun proverMotoristaUseCase() : GetMotoristaUseCase {
        return GetMotoristaUseCase()
    }*/

}