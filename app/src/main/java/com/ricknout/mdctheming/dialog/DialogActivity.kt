package com.ricknout.mdctheming.dialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.ricknout.mdctheming.R
import kotlinx.android.synthetic.main.activity_dialog.*

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        setupAlertDialogButton()
        setupSimpleDialogButton()
        setupConfirmationDialogButtons()
        setupAllDialogButton()
    }

    private fun setupAlertDialogButton() {
        alertDialogButton.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Discard draft?")
                .setMessage("This will permanently delete the current e-mail draft.")
                .setPositiveButton("Discard") { dialog, which ->
                    Toast.makeText(this, "Clicked discard", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, which ->
                    Toast.makeText(this, "Clicked cancel", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }

    private fun setupSimpleDialogButton() {
        simpleDialogButton.setOnClickListener {
            val items = arrayOf("user01@gmail.com", "user02@gmail.com", "Add account")
            MaterialAlertDialogBuilder(this)
                .setTitle("Set backup account")
                .setItems(items) { dialog, which ->
                    Toast.makeText(this, "Clicked ${items[which]}", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }

    private fun setupConfirmationDialogButtons() {
        singleChoiceConfirmationDialogButton.setOnClickListener {
            val items = arrayOf("None", "Callisto", "Ganymede", "Luna")
            val checkedItem = 0
            MaterialAlertDialogBuilder(this)
                .setTitle("Phone ringtone")
                .setSingleChoiceItems(items, checkedItem) { dialog, which ->
                    Toast.makeText(this, "Chose ${items[which]}", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("Ok") { dialog, which ->
                    Toast.makeText(this, "Clicked ok", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, which ->
                    Toast.makeText(this, "Clicked cancel", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
        multiChoiceConfirmationDialogButton.setOnClickListener {
            val items = arrayOf("None", "Forums", "Social", "Updates")
            val checkedItems = booleanArrayOf(true, false, false, false)
            MaterialAlertDialogBuilder(this)
                .setTitle("Label as:")
                .setMultiChoiceItems(items, checkedItems) { dialog, which, checked ->
                    Toast.makeText(this, "Chose ${items[which]}", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("Ok") { dialog, which ->
                    Toast.makeText(this, "Clicked ok", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { dialog, which ->
                    Toast.makeText(this, "Clicked cancel", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }

    private fun setupAllDialogButton() {
        allDialogButton.setOnClickListener {
            val items = arrayOf("Item 1", "Item 2", "Item 3")
            val checkedItem = 0
            val checkedItems = booleanArrayOf(true, false, false)
            MaterialAlertDialogBuilder(this)
                .setTitle("Title")
                .setMessage("Supporting text")
                .setPositiveButton("Confirm") { dialog, which ->
                    Toast.makeText(this, "Clicked confirm", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Dismiss") { dialog, which ->
                    Toast.makeText(this, "Clicked dismiss", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("Neutral") { dialog, which ->
                    Toast.makeText(this, "Clicked neutral", Toast.LENGTH_SHORT).show()
                }
                /*.setItems(items) { dialog, which ->
                    Toast.makeText(this, "Clicked ${items[which]}", Toast.LENGTH_SHORT).show()
                }*/
                /*.setSingleChoiceItems(items, checkedItem) { dialog, which ->
                    Toast.makeText(this, "Chose ${items[which]}", Toast.LENGTH_SHORT).show()
                }*/
                /*.setMultiChoiceItems(items, checkedItems) { dialog, which, checked ->
                    Toast.makeText(this, "Chose ${items[which]}", Toast.LENGTH_SHORT).show()
                }*/
                .setIcon(R.drawable.ic_android_color_control_normal_24dp)
                .show()
        }
    }
}
