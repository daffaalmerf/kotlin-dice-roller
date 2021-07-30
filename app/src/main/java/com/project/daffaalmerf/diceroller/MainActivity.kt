package com.project.daffaalmerf.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows user to roll
 * a die and view the result on screen
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.btnRoll)
        rollButton.setOnClickListener { rollDie() }

    }

    /**
     * Roll the die and update on the screen with the result
     */

    private fun rollDie() {
        // Create an instance of die with a side of 6
        val dieOne = Die(6)
        val dieTwo = Die(6)
        // Update the screen with the dice roll
        val dieOneImage: ImageView = findViewById(R.id.imgDieOne)
        val dieTwoImage: ImageView = findViewById(R.id.imgDieTwo)

        val dieOneNumber = dieOne.roll()
        val dieTwoNumber = dieTwo.roll()

        val dieOneDrawable = changeDrawable(dieOneNumber)
        val dieTwoDrawable = changeDrawable(dieTwoNumber)

        dieOneImage.setImageResource(dieOneDrawable)
        dieOneImage.contentDescription = dieOneNumber.toString()
        dieTwoImage.setImageResource(dieTwoDrawable)
        dieTwoImage.contentDescription = dieTwoNumber.toString()
        Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT).show()
    }

    private fun changeDrawable(number: Int) : Int {
        when (number) {
            1 -> return R.drawable.dice_1
            2 -> return R.drawable.dice_2
            3 -> return R.drawable.dice_3
            4 -> return R.drawable.dice_4
            5 -> return R.drawable.dice_5
            else -> return R.drawable.dice_6
        }
    }
}

/**
 * Class of die with a function to generate a random number
 * with a limit depending on the number of sides
 */
class Die(private val sides: Int){
    fun roll(): Int{ return (1..sides).random() }
}