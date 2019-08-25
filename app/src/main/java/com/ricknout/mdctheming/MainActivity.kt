package com.ricknout.mdctheming

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ricknout.mdctheming.bottomappbar.BottomAppBarActivity
import com.ricknout.mdctheming.bottomnavigation.BottomNavigationActivity
import com.ricknout.mdctheming.bottomsheet.BottomSheetActivity
import com.ricknout.mdctheming.button.ButtonActivity
import com.ricknout.mdctheming.card.CardActivity
import com.ricknout.mdctheming.chip.ChipActivity
import com.ricknout.mdctheming.dialog.DialogActivity
import com.ricknout.mdctheming.selectioncontrol.SelectionControlActivity
import com.ricknout.mdctheming.theming.ThemingActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        themingPlaygroundButton.setOnClickListener {
            startActivity(Intent(this, ThemingActivity::class.java))
        }
        bottomAppBarPlaygroundButton.setOnClickListener {
            startActivity(Intent(this, BottomAppBarActivity::class.java))
        }
        bottomNavigationPlaygroundButton.setOnClickListener {
            startActivity(Intent(this, BottomNavigationActivity::class.java))
        }
        bottomSheetPlaygroundButton.setOnClickListener {
            startActivity(Intent(this, BottomSheetActivity::class.java))
        }
        buttonPlaygroundButton.setOnClickListener {
            startActivity(Intent(this, ButtonActivity::class.java))
        }
        chipPlaygroundButton.setOnClickListener {
            startActivity(Intent(this, ChipActivity::class.java))
        }
        cardPlaygroundButton.setOnClickListener {
            startActivity(Intent(this, CardActivity::class.java))
        }
        dialogPlaygroundButton.setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }
        selectionControlPlaygroundButton.setOnClickListener {
            startActivity(Intent(this, SelectionControlActivity::class.java))
        }
    }
}
