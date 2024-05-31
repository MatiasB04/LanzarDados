package com.example.lanzardados

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets

            val btnLanzar: Button = findViewById(R.id.btnLanzar)

            btnLanzar.setOnClickListener{
                tiempo()
                //val mp3 = MediaPlayer.create(this, R. sound.sonido)
                //mp3.start()
            }

        rollDice()
    }

    private fun rollDice(){
        var numero: Int = lanzar(6)
        val txtResult: TextView = findViewById(R.id.txtResultado)
        txtResult.text = numero.toString()

        val drawableResource = when (numero){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        val imgDado: ImageView = findViewById(R.id.imgDado)
        imgDado.setImageResource(drawableResource)

    }

    private fun lanzar(max: Int): Int{
      return (1..max).random()


    } 

    private fun tiempo(){
        object: CountDownTimer(3000, 200){
            override fun onTick(millisUntilFinished: Long) {
                rollDice()
            }

            override fun onFinish() {

            }
        }.start()
    }
}