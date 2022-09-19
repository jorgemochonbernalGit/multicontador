package com.example.multicontador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //botones reset
    lateinit var btnReset1:Button
    lateinit var btnReset2:Button
    lateinit var btnReset3:Button
    lateinit var btnReset4:Button

    //botob reset all
    lateinit var btnResetAll:Button

    //resultados
    lateinit var resultado1:TextView
    lateinit var resultado2:TextView
    lateinit var resultado3:TextView
    lateinit var resultado4:TextView

    //resultado global
    lateinit var resultadoGlobal:TextView

    //botones incrementos
    lateinit var btnIncremento1:Button
    lateinit var btnIncremento2:Button
    lateinit var btnIncremento3:Button
    lateinit var btnIncremento4:Button

    //funcion padre, iniciamos todas las funciones
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        instanciar()
        eventosReset()
        eventosIncremento()
    }

    //seleccionamos  los id de los componentes
    fun instanciar() {
        //botones reset
        btnReset1  = findViewById<Button>(R.id.btnReset1)
        btnReset2  = findViewById<Button>(R.id.btnReset2)
        btnReset3  = findViewById<Button>(R.id.btnReset3)
        btnReset4  = findViewById<Button>(R.id.btnReset4)

        //boton reset all
        btnResetAll = findViewById<Button>(R.id.btnResetAll)

        //resultado global
        resultadoGlobal = findViewById(R.id.resultadoGlobal)

        //resultados
        resultado1 = findViewById(R.id.resultado1)
        resultado2 = findViewById(R.id.resultado2)
        resultado3 = findViewById(R.id.resultado3)
        resultado4 = findViewById(R.id.resultado4)

        //botones incrementos
        btnIncremento1 = findViewById<Button>(R.id.btnIncremento1)
        btnIncremento2 = findViewById<Button>(R.id.btnIncremento2)
        btnIncremento3 = findViewById<Button>(R.id.btnIncremento3)
        btnIncremento4 = findViewById<Button>(R.id.btnIncremento4)
    }

    //evento onclick para el reseteo a 0
    fun eventosReset() {
        btnReset1.setOnClickListener {
            resetGlobal(1)
            resultado1.setText("0")
        };
        btnReset2!!.setOnClickListener {
            resetGlobal(2)
            resultado2.setText("0")
        };
        btnReset3.setOnClickListener {
            resetGlobal(3)
            resultado3.setText("0")
        };
        btnReset4.setOnClickListener {
            resetGlobal(4)
            resultado4.setText("0")
        };

        //boton reset all
        btnResetAll.setOnClickListener {
            resultado1.setText("0")
            resultado2.setText("0")
            resultado3.setText("0")
            resultado4.setText("0")
            resultadoGlobal.setText("0")
        };
    }

    //evento
    fun eventosIncremento() {
        btnIncremento1.setOnClickListener {
            var total1 = resultado1.getText().toString().toInt() + 1
            resultado1.setText(total1.toString())
            incrementarGlobal()
        }
        btnIncremento2.setOnClickListener {
            var total2 = resultado2.getText().toString().toInt() + 1
            resultado2.setText(total2.toString())
            incrementarGlobal()
        }
        btnIncremento3.setOnClickListener {
            var total3 = resultado3!!.getText().toString().toInt() + 1
            resultado3.setText(total3.toString())
            incrementarGlobal()
        }
        btnIncremento4.setOnClickListener {
            var total4 = resultado4.getText().toString().toInt() + 1
            resultado4.setText(total4.toString())
            incrementarGlobal()
        }
    }

    fun incrementarGlobal() {
        var total = resultado1.getText().toString().toInt() + resultado2.getText().toString().toInt() + resultado3.getText().toString().toInt() + resultado4.getText().toString().toInt()
        resultadoGlobal.setText(total.toString())
    }

    fun resetGlobal(btnN: Int) {
        when(btnN) {
            1-> resultadoGlobal.setText((resultadoGlobal.getText().toString().toInt() - resultado1.getText().toString().toInt()).toString())
            2-> resultadoGlobal!!.setText((resultadoGlobal.getText().toString().toInt() - resultado2.getText().toString().toInt()).toString())
            3-> resultadoGlobal!!.setText((resultadoGlobal.getText().toString().toInt() - resultado3.getText().toString().toInt()).toString())
            4-> resultadoGlobal!!.setText((resultadoGlobal.getText().toString().toInt() - resultado4.getText().toString().toInt()).toString())
        }
    }
}


