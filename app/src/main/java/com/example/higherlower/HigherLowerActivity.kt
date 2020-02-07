package com.example.higherlower

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        btnLower.setOnClickListener {onLowerClick()}
        btnEqual.setOnClickListener {onEqualClick()}
        btnHigher.setOnClickListener {onHigherClick()}
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

    private fun onAnswerCorrect() {
        Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, R.string.incorrect, Toast.LENGTH_SHORT).show()
    }

    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow) onAnswerCorrect() else onAnswerIncorrect()
    }

    private fun onEqualClick() {
        rollDice()
        if (currentThrow == lastThrow) onAnswerCorrect() else onAnswerIncorrect()
    }

    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) onAnswerCorrect() else onAnswerIncorrect()
    }
}
