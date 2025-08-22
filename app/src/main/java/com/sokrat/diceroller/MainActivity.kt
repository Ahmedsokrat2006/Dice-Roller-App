package com.sokrat.diceroller

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val colorList = listOf(R.color.red, R.color.black)
        val diceList = listOf(
            listOf(
                R.drawable.red_1,
                R.drawable.red_2,
                R.drawable.red_3,
                R.drawable.red_4,
                R.drawable.red_5,
                R.drawable.red_6
            ),
            listOf(
                R.drawable.black_1,
                R.drawable.black_2,
                R.drawable.black_3,
                R.drawable.black_4,
                R.drawable.black_5,
                R.drawable.black_6
            ),
            listOf(
                R.drawable.blue_1,
                R.drawable.blue_2,
                R.drawable.blue_3,
                R.drawable.blue_4,
                R.drawable.blue_5,
                R.drawable.blue_6
            ),
            listOf(
                R.drawable.green_1,
                R.drawable.green_2,
                R.drawable.green_3,
                R.drawable.green_4,
                R.drawable.green_5,
                R.drawable.green_6
            )
        )
        var colorIndex = 0
        val diceImage1 : ImageView = findViewById(R.id.image1)
        val diceImage2 : ImageView = findViewById(R.id.image2)
        val colorButton : Button = findViewById(R.id.colorbutton)
        colorButton.setOnClickListener {
            colorIndex = (colorIndex + 1) % 4
            val color = when(colorIndex){
                0 -> getString(R.string.red)
                1 -> getString(R.string.black)
                2 -> getString(R.string.blue)
                else -> getString(R.string.green)
            }
            Toast.makeText(this, "$color " + getString(R.string.dices), Toast.LENGTH_SHORT).show()
            diceImage1.setImageResource(diceList[colorIndex][0])
            diceImage2.setImageResource(diceList[colorIndex][0])
        }
        val txtview1 : TextView = findViewById(R.id.txtview1)
        val txtview2 : TextView = findViewById(R.id.txtview2)
        val lastresult1 : TextView = findViewById(R.id.lastresult1)
        val lastresult2 : TextView = findViewById(R.id.lastresult2)
        val rollButtom : Button = findViewById(R.id.roll)
        var dice1 = 1
        var dice2 = 1
        rollButtom.setOnClickListener {
            lastresult1.text = getString(R.string.dice) + " 1  \n $dice1"
            lastresult2.text = getString(R.string.dice) +" 2 \n $dice2"
            val randomNo1 = (1..6).random()
            val randomNo2 = (1..6).random()
            dice1 = randomNo1
            dice2 = randomNo2
            diceImage1.setImageResource(diceList[colorIndex][randomNo1 - 1])
            diceImage2.setImageResource(diceList[colorIndex][randomNo2 - 1])
            txtview1.text = getString(R.string.result) + " ${randomNo1}"
            txtview2.text = getString(R.string.result) + " ${randomNo2}"
        }
    }

}