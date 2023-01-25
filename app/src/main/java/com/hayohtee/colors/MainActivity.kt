package com.hayohtee.colors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hayohtee.colors.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createColorButton.setOnClickListener {
            displayColor()
        }
    }

    /**
     * Extract the hex value from all the color channels if they are not empty and
     * concatenate them to create a full RGB hex color value then sets the
     * colorDisplayTextView to use the new color as the background color. Otherwise
     * display a Toast to inform the user that all the fields should be filled
     */
    private fun displayColor() {
        if (binding.redEditText.text?.isNotEmpty()!! &&
            binding.greenEditText.text?.isNotEmpty()!! &&
            binding.blueEditText.text?.isNotEmpty()!!
        ) {
            val redHexValue = validateHexValue(binding.redEditText.text.toString())
            val greenHexValue = validateHexValue(binding.greenEditText.text.toString())
            val blueValue = validateHexValue(binding.blueEditText.text.toString())

            val hexColor = "#$redHexValue$greenHexValue$blueValue"
            binding.colorDisplayTextView.setBackgroundColor(Color.parseColor(hexColor))
        } else {
            Toast.makeText(
                this, "Please enter required value for all the color channels",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun validateHexValue(hexString: String): String {
        return if (hexString.length == 1) {
            hexString + hexString
        } else {
            hexString
        }
    }
}