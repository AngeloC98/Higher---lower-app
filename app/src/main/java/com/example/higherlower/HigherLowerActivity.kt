package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()
    }

    private fun updateUI() {
        TvLastThrow.text = getString(R.string.last_throw, lastThrow)

        when (currentThrow) {
            1 -> IvDice.setImageResource(R.drawable.dice1)
            2 -> IvDice.setImageResource(R.drawable.dice2)
            3 -> IvDice.setImageResource(R.drawable.dice3)
            4 -> IvDice.setImageResource(R.drawable.dice4)
            5 -> IvDice.setImageResource(R.drawable.dice5)
            6 -> IvDice.setImageResource(R.drawable.dice6)
        }
    }

    private fun initViews() {
        updateUI()
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }
}
