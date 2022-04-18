package com.example.racecar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity(), GameTask {

    lateinit var  rootLayout: LinearLayout
    lateinit var startButton: Button
    lateinit var gameView: GameView
    lateinit var score: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startButton)
        rootLayout = findViewById(R.id.mainLayout)

        score = findViewById(R.id.score)
        gameView = GameView(this, this)


        startButton.setOnClickListener(){
            gameView.score = 0
            gameView.setBackgroundResource(R.drawable.road)
            startButton.visibility = View.GONE
            score.visibility = View.GONE
            rootLayout.addView(gameView)

        }
    }

    override fun closeGame(gameScore: Int) {
        score.text = "Score : $gameScore"
        rootLayout.removeView(gameView)
        startButton.visibility = View.VISIBLE
        score.visibility = View.VISIBLE
        gameView.otherCars = ArrayList<HashMap<String, Any>>()

    }
}