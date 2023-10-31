package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

//activity allows user to roll a dice and view the result
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
    }
//function to roll the dice and update the screen
    private fun rollDice() {
    //create a new dice with 6 sides
        val dice = Dice(6)
        val dice2 = Dice(6)

    //update the screen with the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        val dice2Image: ImageView = findViewById(R.id.imageView2)

        //function that takes a dice, roll it and return the image
        val drawableResource = { dice: Dice ->
            when (dice.roll()) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        }

        //rendering the image of each dice
        diceImage.setImageResource(drawableResource(dice))
        diceImage.contentDescription = dice.roll().toString()

        dice2Image.setImageResource(drawableResource(dice2))
        dice2Image.contentDescription = dice2.roll().toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}