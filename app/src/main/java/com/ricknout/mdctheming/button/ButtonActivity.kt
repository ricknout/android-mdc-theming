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
            toggleGroupHorizontal.isSingleSelection = !toggleGroupHorizontal.isSingleSelection
            toggleGroupVertical.isSingleSelection = !toggleGroupVertical.isSingleSelection
        }
        toggleSelectionRequiredButton.setOnClickListener {
            toggleGroupHorizontal.isSelectionRequired = !toggleGroupHorizontal.isSelectionRequired
            toggleGroupVertical.isSelectionRequired = !toggleGroupVertical.isSelectionRequired
        }
    }

    private fun setupToggleGroup() {
        toggleGroupHorizontal.addOnButtonCheckedListener { group, checkedId, isChecked ->
            val buttonName = when (checkedId) {
                R.id.toggleButton1Horizontal -> "Button 1 (Horizontal)"
                R.id.toggleButton2Horizontal -> "Button 2 (Horizontal)"
                R.id.toggleButton3Horizontal -> "Button 3 (Horizontal)"
                else -> ""
            }
            val text = if (isChecked) "Checked $buttonName" else "Unchecked $buttonName"
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
        toggleGroupVertical.addOnButtonCheckedListener { group, checkedId, isChecked ->
            val buttonName = when (checkedId) {
                R.id.toggleButton1Vertical -> "Button 1 (Vertical)"
                R.id.toggleButton2Vertical -> "Button 2 (Vertical)"
                R.id.toggleButton3Vertical -> "Button 3 (Vertical)"
                else -> ""
            }
            val text = if (isChecked) "Checked $buttonName" else "Unchecked $buttonName"
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }
}
