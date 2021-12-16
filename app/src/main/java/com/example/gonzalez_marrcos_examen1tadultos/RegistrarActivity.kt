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
            if (binding.email.text.isEmpty()) {
                Toast.makeText(this, R.string.emailInvalido, Toast.LENGTH_SHORT).show()
            } else if (binding.contrasena.text.isEmpty()) {
                Toast.makeText(this, R.string.contrasenaInvalida, Toast.LENGTH_SHORT).show()
            } else if (binding.contrasena.text.length < 9) {
                Toast.makeText(this, R.string.contrasenaCorta, Toast.LENGTH_SHORT).show()
            } else if (!binding.contrasena.text.toString()
                    .equals(binding.confirmarContrasena.text.toString())
            ) {
                Toast.makeText(this, R.string.contrasenasDiferentes, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, R.string.usuarioRegistrado, Toast.LENGTH_SHORT).show()
            }
        }
    }







}
