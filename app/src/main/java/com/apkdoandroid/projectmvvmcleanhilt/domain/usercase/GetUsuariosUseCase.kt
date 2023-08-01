package com.apkdoandroid.projectmvvmcleanhilt.domain.usercase

import com.apkdoandroid.projectmvvmcleanhilt.domain.model.Usuario
import com.apkdoandroid.projectmvvmcleanhilt.domain.repository.UsuarioRepository
import javax.inject.Inject

class GetUsuariosUseCase @Inject constructor(
    private val usuarioRepository: UsuarioRepository
) {

    //Data -> UsuarioDTO
    //Domínio -> Usuario
    //Presentation -> UsuarioPresentation
    suspend operator fun invoke() : List<Usuario> {
        return try {

            //Regras de negócios
            usuarioRepository.recuperarUsuarios()

            /*//Verificar os usuários mais próximos
                getMotoristaUseCase.recuperarMotorista()
                getMotoristaUseCase.notificarMotorista()*/


        }catch (erroRecuperarUsuarios: Exception){
            erroRecuperarUsuarios.printStackTrace()
            emptyList()
        }
    }

}