package com.ricknout.mdctheming.chip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.ChipDrawable
import com.ricknout.mdctheming.R
import kotlinx.android.synthetic.main.activity_chip.*
import android.text.Spanned
import android.text.style.ImageSpan
import android.widget.Toast

class ChipActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chip)
        setupClickListeners()
        setupButtons()
        setupChipGroup()
        setupChipDrawable()
    }

    private fun setupClickListeners() {
        actionChip.setOnClickListener {
            Toast.makeText(this, "Clicked Action Chip", Toast.LENGTH_SHORT).show()
        }
        inputChip.setOnCloseIconClickListener {
            Toast.makeText(this, "Clicked Input Chip close icon", Toast.LENGTH_SHORT).show()
        }
        choiceChip.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Checked Choice Chip: $isChecked", Toast.LENGTH_SHORT).show()
        }
        filterChip.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Checked Filter Chip: $isChecked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupButtons() {
        toggleSingleSelectionButton.setOnClickListener {
            chipGroup.isSingleSelection = !chipGroup.isSingleSelection
        }
        toggleSelectionRequiredButton.setOnClickListener {
            chipGroup.isSelectionRequired = !chipGroup.isSelectionRequired
        }
    }

    private fun setupChipGroup() {
        chipGroup.check(R.id.choice1)
        val checkedChipId = chipGroup.checkedChipId // Returns View.NO_ID if singleSelection = false
        val checkedChipIds = chipGroup.checkedChipIds
        chipGroup.setOnCheckedChangeListener { _, checkedId ->
            val chipName = when (checkedId) {
                R.id.choice1 -> "Chip 1"
                R.id.choice2 -> "Chip 2"
                R.id.choice3 -> "Chip 3"
                R.id.choice4 -> "Chip 4"
                R.id.choice5 -> "Chip 5"
                R.id.choice6 -> "Chip 6"
                else -> ""
            }
            Toast.makeText(this, "Checked Chip in ChipGroup: $chipName", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupChipDrawable() {
        val chip = ChipDrawable.createFromResource(this, R.xml.chip)
        chip.setBounds(0, 0, chip.intrinsicWidth, chip.intrinsicHeight)
        val span = ImageSpan(chip)
        val text = editText.text!!
        text.setSpan(span, 0, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}
