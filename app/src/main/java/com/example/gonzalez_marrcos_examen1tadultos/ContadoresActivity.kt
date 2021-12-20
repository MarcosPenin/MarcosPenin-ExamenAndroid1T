package com.example.gonzalez_marrcos_examen1tadultos

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.gonzalez_marrcos_examen1tadultos.databinding.ActivityContadoresBinding
import java.lang.NumberFormatException


class ContadoresActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContadoresBinding

    var contador1 = 0
        set(value) {field=value; binding.contador1.text = value.toString()}
    var contador2 = 0
        set(value) {field=value; binding.contador2.text = value.toString()}
    var global = 0
        set(value) {field=value; binding.globalnum.text = value.toString()}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContadoresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.boton1.setOnClickListener {
           try{
               val incremento=binding.numIncremento1.text.toString().toInt()
               contador1+=incremento
               global+=incremento
               alerta(binding.incremento1,false)
           } catch (e: NumberFormatException) {
               alerta(binding.incremento1, true)
               Toast.makeText(this, R.string.incrementoVacio, Toast.LENGTH_SHORT).show()
           }


        }


        binding.boton2.setOnClickListener {
            try{
                val incremento=binding.numIncremento2.text.toString().toInt()
                contador2+=incremento
                global+=incremento
                alerta(binding.incremento2,false)
            } catch (e: NumberFormatException) {  // Si el EditText de incremento no tiene un número
                alerta(binding.incremento2, true)
                Toast.makeText(this, R.string.incrementoVacio, Toast.LENGTH_SHORT).show()
            }
        }

        binding.borrar1.setOnClickListener { contador1 = 0}

        binding.borrar2.setOnClickListener {contador2 = 0}

        binding.borrar3.setOnClickListener { global = 0}

    }

    private fun alerta(tv: TextView, alerta: Boolean) {
        if (alerta) tv.setTextColor(Color.RED)
        else tv.setTextColor(Color.BLACK)
    }
}

