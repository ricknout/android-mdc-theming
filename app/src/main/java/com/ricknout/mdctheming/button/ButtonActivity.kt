package com.ricknout.mdctheming.button

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ricknout.mdctheming.R
import kotlinx.android.synthetic.main.activity_button.*

class ButtonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button)
        setupButtons()
        setupToggleGroup()
    }

    private fun setupButtons() {
        toggleSingleSelectionButton.setOnClickListener {
            toggleGroup.isSingleSelection = !toggleGroup.isSingleSelection
        }
    }

    private fun setupToggleGroup() {
        toggleGroup.addOnButtonCheckedListener { group, checkedId, isChecked ->
            val buttonName = when (checkedId) {
                R.id.toggleButton1 -> "Button 1"
                R.id.toggleButton2 -> "Button 2"
                R.id.toggleButton3 -> "Button 3"
                else -> ""
            }
            val text = if (isChecked) "Checked $buttonName" else "Unchecked $buttonName"
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}
