package com.ricknout.mdctheming.bottomnavigation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.ricknout.mdctheming.R
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        setupButtons()
        setupBottomNavigationMenu()
        setupBottomNavigationLabelVisibilityAndHorizontalTranslation()
    }

    private fun setupButtons() {
        labelVisibilityModeButton.setOnClickListener {
            val labelVisibilityMode = when (bottomNavigation.labelVisibilityMode) {
                LabelVisibilityMode.LABEL_VISIBILITY_AUTO -> LabelVisibilityMode.LABEL_VISIBILITY_SELECTED
                LabelVisibilityMode.LABEL_VISIBILITY_SELECTED -> LabelVisibilityMode.LABEL_VISIBILITY_LABELED
                LabelVisibilityMode.LABEL_VISIBILITY_LABELED -> LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED
                else -> LabelVisibilityMode.LABEL_VISIBILITY_AUTO
            }
            bottomNavigation.labelVisibilityMode = labelVisibilityMode
        }
        horizontalTranslationEnabledButton.setOnClickListener {
            val horizontalTranslationEnabled = !bottomNavigation.isItemHorizontalTranslationEnabled
            bottomNavigation.isItemHorizontalTranslationEnabled = horizontalTranslationEnabled
        }
    }

    private fun setupBottomNavigationMenu() {
        bottomNavigation.inflateMenu(R.menu.menu_bottom_navigation_2)
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item1 -> {
                    Toast.makeText(this, "Selected navigation item 1", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item2 -> {
                    Toast.makeText(this, "Selected navigation item 2", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item3 -> {
                    Toast.makeText(this, "Selected navigation item 3", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        bottomNavigation.setOnNavigationItemReselectedListener { item ->
            when(item.itemId) {
                R.id.item1 -> {
                    Toast.makeText(this, "Reselected navigation item 1", Toast.LENGTH_SHORT).show()
                }
                R.id.item2 -> {
                    Toast.makeText(this, "Reselected navigation item 2", Toast.LENGTH_SHORT).show()
                }
                R.id.item3 -> {
                    Toast.makeText(this, "Reselected navigation item 3", Toast.LENGTH_SHORT).show()
                }
            }
        }
        // Use this to programmatically select navigation items
        //bottomNavigation.selectedItemId = R.id.item1
    }

    private fun setupBottomNavigationLabelVisibilityAndHorizontalTranslation() {
        bottomNavigation.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_SELECTED
        //bottomNavigation.isItemHorizontalTranslationEnabled = true
    }
}
