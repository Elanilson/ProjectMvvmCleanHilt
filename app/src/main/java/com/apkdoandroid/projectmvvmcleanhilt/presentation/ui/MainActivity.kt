package com.apkdoandroid.projectmvvmcleanhilt.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.apkdoandroid.projectmvvmcleanhilt.R
import com.apkdoandroid.projectmvvmcleanhilt.databinding.ActivityMainBinding
import com.apkdoandroid.projectmvvmcleanhilt.presentation.viewModel.UsuariosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }
    private val usuariosViewModel: UsuariosViewModel by viewModels()
    //private val usuariosViewModel by viewModels<UsuariosViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        /*usuariosViewModel =
            ViewModelProvider(this)[UsuariosViewModel::class.java]*/
        usuariosViewModel.recuperarUsuarios()

        usuariosViewModel.usuarios.observe(this){ listaUsuarios ->
            var listaResultado = ""
            listaUsuarios.forEach { usuario ->
                val nome = usuario.nome
                val sobrenome = usuario.sobrenome
                val idade = usuario.idade

                listaResultado += "+) $nome - $sobrenome - $idade \n"
            }
            binding.textResultado.text = listaResultado
        }


    }
}