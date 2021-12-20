package com.example.gonzalez_marrcos_examen1tadultos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gonzalez_marrcos_examen1tadultos.databinding.ActivityMainBinding
import com.example.gonzalez_marrcos_examen1tadultos.databinding.ActivityRegistrarBinding

class RegistrarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registrar.setOnClickListener {

            try{
                comprobarEmail()
                comprobarContrasena()
                binding.confirmarContrasena.text.toString()
                Toast.makeText(this, R.string.usuarioRegistrado, Toast.LENGTH_SHORT).show()
            }catch (e:Excepciones.EmailInvalido){
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }catch (e:Excepciones.ContrasenaAusente){
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }catch (e:Excepciones.ContrasenaCorta){
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }catch (e:Excepciones.ContrasenaNoCoincide){
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }

    }
    }


    private fun comprobarEmail(){
        if (binding.email.text.isEmpty()) throw Excepciones.EmailInvalido()
    }

    private fun comprobarContrasena(){
        if (binding.contrasena.text.isEmpty()) throw Excepciones.ContrasenaAusente()
        if (binding.contrasena.text.length<9) throw Excepciones.ContrasenaCorta()
        if (!binding.contrasena.text.toString().equals(binding.confirmarContrasena.text.toString())) throw Excepciones.ContrasenaNoCoincide()
    }













}
