package com.ricknout.mdctheming.selectioncontrol

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ricknout.mdctheming.R
import kotlinx.android.synthetic.main.activity_selection_control.*

class SelectionControlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_control)
        setupCheckListeners()
        setupRadioGroup()
    }

    private fun setupCheckListeners() {
        radioButton.isChecked = false
        checkbox.isChecked = true
        switchMaterial.isChecked = true
        radioButton.setOnCheckedChangeListener { radioButton, isChecked ->
            Toast.makeText(this, "Checked Radio Button: $isChecked", Toast.LENGTH_SHORT).show()
        }
        checkbox.setOnCheckedChangeListener { checkbox, isChecked ->
            Toast.makeText(this, "Checked Checkbox: $isChecked", Toast.LENGTH_SHORT).show()
        }
        switchMaterial.setOnCheckedChangeListener { switchMaterial, isChecked ->
            Toast.makeText(this, "Checked Switch: $isChecked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupRadioGroup() {
        radioGroup.check(R.id.option1)
        radioGroup.checkedRadioButtonId
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val radioButtonName = when (checkedId) {
                R.id.option1 -> "Radio Button 1"
                R.id.option2 -> "Radio Button 2"
                R.id.option3 -> "Radio Button 3"
                else -> ""
            }
            Toast.makeText(this, "Checked Radio Button in RadioGroup: $radioButtonName", Toast.LENGTH_SHORT).show()
        }
    }
}
