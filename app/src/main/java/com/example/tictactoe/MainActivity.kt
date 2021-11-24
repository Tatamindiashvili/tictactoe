package com.example.tictactoe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.Button
import android.widget.Toast

abstract class MainActivity() : AppCompatActivity(), View.OnClickListener, Parcelable {
    private lateinit var gilaki1: Button
    private lateinit var gilaki2: Button
    private lateinit var gilaki3: Button
    private lateinit var gilaki4: Button
    private lateinit var gilaki5: Button
    private lateinit var gilaki6: Button
    private lateinit var gilaki7: Button
    private lateinit var gilaki8: Button
    private lateinit var gilaki9: Button
    private lateinit var resetgilaki: Button

    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()

    constructor(parcel: Parcel) : this() {
        activePlayer = parcel.readInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        gilaki1 = findViewById(R.id.gilaki1)
        gilaki2 = findViewById(R.id.gilaki2)
        gilaki3 = findViewById(R.id.gilaki3)
        gilaki4 = findViewById(R.id.gilaki4)
        gilaki5 = findViewById(R.id.gilaki5)
        gilaki6 = findViewById(R.id.gilaki6)
        gilaki7 = findViewById(R.id.gilaki7)
        gilaki8 = findViewById(R.id.gilaki8)
        gilaki9 = findViewById(R.id.gilaki9)
        resetgilaki = findViewById(R.id.resetgilaki)
        gilaki1.setOnClickListener(this)
        gilaki2.setOnClickListener(this)
        gilaki3.setOnClickListener(this)
        gilaki4.setOnClickListener(this)
        gilaki5.setOnClickListener(this)
        gilaki6.setOnClickListener(this)
        gilaki7.setOnClickListener(this)
        gilaki8.setOnClickListener(this)
        gilaki9.setOnClickListener(this)
    }

    override fun onClick(Clickedview: View?) {
        if (Clickedview is Button) {
            var buttonNumber = 0

            when (Clickedview.id) {
                R.id.gilaki1 -> buttonNumber = 1
                R.id.gilaki2 -> buttonNumber = 2
                R.id.gilaki3 -> buttonNumber = 3
                R.id.gilaki4 -> buttonNumber = 4
                R.id.gilaki5 -> buttonNumber = 5
                R.id.gilaki6 -> buttonNumber = 6
                R.id.gilaki7 -> buttonNumber = 7
                R.id.gilaki8 -> buttonNumber = 8
                R.id.gilaki9 -> buttonNumber = 9
            }
            if (buttonNumber != 0) {
                playgame(Clickedview, buttonNumber)
            }
        }
    }

    private fun playgame(clickedview: Button, buttonNumber: Int) {
        if (activePlayer == 1) {
            clickedview.text = "X"
            clickedview.setBackgroundColor(Color.RED)
            firstPlayer.add(buttonNumber)
            activePlayer = 2
        } else {
            clickedview.text = "0"
            clickedview.setBackgroundColor(Color.BLACK)
            secondPlayer.add(buttonNumber)
            activePlayer = 1
        }
        clickedview.isEnabled = false
        Check()
    }

    private fun Check() {
        var winnerPlayer = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }
        if (winnerPlayer == 1) {
            Toast.makeText(this, "111", Toast.LENGTH_SHORT).show()
        } else if (winnerPlayer == 2) {
            Toast.makeText(this, "222", Toast.LENGTH_SHORT).show()
        }
    }
}