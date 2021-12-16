package com.example.gonzalez_marrcos_examen1tadultos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.gonzalez_marrcos_examen1tadultos.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var flag = true
        set(value){
            binding.verContrasena.text=
                if(value) getString(R.string.verContrasena)
                else getString(R.string.ocultar)
            field=value
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.entrar.setOnClickListener {
            try{
                comprobarEmail()
                comprobarContrasena()
                startActivity(Intent(this, ContadoresActivity::class.java))
            }catch (e:Excepciones.EmailInvalido){
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }catch (e:ContrasenaAusente){
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }catch (e:ContrasenaCorta){
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }

        binding.verContrasena.setOnClickListener {
            visibilidadContrasena()
        }

        binding.registrarse.setOnClickListener {
            startActivity(Intent(this, RegistrarActivity::class.java))
        }

    }

    class ContrasenaAusente(message: String) : RuntimeException(message)
    class ContrasenaCorta(message: String) : RuntimeException(message)


    private fun comprobarEmail(){
        if (binding.email.text.isEmpty()) throw Excepciones.EmailInvalido()
    }

    private fun comprobarContrasena(){
        if (binding.contrasena.text.isEmpty()) throw ContrasenaAusente(getString(R.string.contrasenaInvalida))
        if (binding.contrasena.text.length<9) throw ContrasenaCorta(getString(R.string.contrasenaCorta))
    }


    private fun visibilidadContrasena(){
        binding.contrasena.transformationMethod=
            if (flag) PasswordTransformationMethod()
            else HideReturnsTransformationMethod.getInstance()
        flag=!flag
    }





}