package com.example.simplecounter

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        window.statusBarColor = getColor(R.color.appGreen)
        window.decorView.systemUiVisibility = 0

        val counterText = findViewById<TextView>(R.id.textView)
        val addButton = findViewById<Button>(R.id.button)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)

        // Initial click listener adding 1
        addButton.setOnClickListener {
            counter++
            counterText.text = counter.toString()

            // Show upgrade button if counter reaches 100
            if (counter >= 100 && upgradeButton.visibility == View.INVISIBLE){
                upgradeButton.visibility = View.VISIBLE

                upgradeButton.setOnClickListener {
                    // Change button text
                    addButton.text = "Add 2"

                    // Update original button to add 2 permanently
                    addButton.setOnClickListener {
                        counter += 2
                        counterText.text = counter.toString()
                    }

                    // Hide upgrade button again
                    upgradeButton.visibility = View.INVISIBLE
                }
            }

           // Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}