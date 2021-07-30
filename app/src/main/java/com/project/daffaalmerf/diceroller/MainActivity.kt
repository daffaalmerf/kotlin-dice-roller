package com.project.daffaalmerf.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
        rollButton.setOnClickListener{ rollDie() }

    }

    /**
     * Roll the die and update on the screen with the result
     */

    private fun rollDie(){
        // Create an instance of die with a side of 6
        val dieOne = Die(6)
        val dieTwo = Die(6)
        // Update the screen with the dice roll
        val dieNumberOne: TextView = findViewById(R.id.txtNumberOne)
        val dieNumberTwo: TextView = findViewById(R.id.txtNumberTwo)
        dieNumberOne.setText(dieOne.roll().toString())
        dieNumberTwo.setText(dieTwo.roll().toString())
        Toast.makeText(this, "Die rolled!", Toast.LENGTH_SHORT).show()
    }
}

/**
 * Class of die with a function to generate a random number
 * with a limit depending on the number of sides
 */
class Die(private val sides: Int){
    fun roll(): Int{ return (1..sides).random() }
}