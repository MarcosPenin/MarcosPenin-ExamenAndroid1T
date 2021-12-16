package com.example.gonzalez_marrcos_examen1tadultos

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gonzalez_marrcos_examen1tadultos.databinding.ActivityContadoresBinding


class ContadoresActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContadoresBinding

    var contador1 = 0
    var contador2 = 0
    var global = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContadoresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton1.setOnClickListener {
            if (binding.numIncremento1.text.toString()=="") {
                Toast.makeText(this, R.string.incrementoVacio, Toast.LENGTH_SHORT).show()
                binding.incremento1.setTextColor(Color.parseColor("#FF1744"))

            } else {
                contador1 += Integer.parseInt(binding.numIncremento1.text.toString())
                global += Integer.parseInt(binding.numIncremento1.text.toString())
                binding.contador1.setText(contador1.toString())
                binding.globalnum.setText(global.toString())
                binding.incremento1.setTextColor(Color.parseColor("#000000"))
            }
        }

        binding.boton2.setOnClickListener {
            if (binding.numIncremento2.text.toString()=="") {
                Toast.makeText(this, R.string.incrementoVacio, Toast.LENGTH_SHORT).show()
                binding.incremento2.setTextColor(Color.parseColor("#FF1744"))

            } else {
                contador2 += Integer.parseInt(binding.numIncremento2.text.toString())
                global += Integer.parseInt(binding.numIncremento2.text.toString())
                binding.contador2.setText(contador2.toString())
                binding.globalnum.setText(global.toString())
                binding.incremento2.setTextColor(Color.parseColor("#000000"))
            }
        }

        binding.borrar1.setOnClickListener {
            contador1 = 0
            binding.contador1.setText(contador1.toString())

        }

        binding.borrar2.setOnClickListener {
            contador2 = 0
            binding.contador2.setText(contador2.toString())
        }

        binding.borrar3.setOnClickListener {
            global = 0
            binding.globalnum.setText(global.toString())
        }

    }
}

