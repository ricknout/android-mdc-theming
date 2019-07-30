package com.ricknout.mdctheming.bottomnavigation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEach
import androidx.core.view.forEachIndexed
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.ricknout.mdctheming.R
import kotlinx.android.synthetic.main.activity_bottom_navigation.*
import kotlin.math.pow

class BottomNavigationActivity : AppCompatActivity() {

    private var badgingEnabled = false

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
        badgingEnabledButton.setOnClickListener {
            if (!badgingEnabled) {
                bottomNavigation.menu.forEachIndexed { index, item ->
                    val badgeDrawable = bottomNavigation.getOrCreateBadge(item.itemId)
                    if (index > 0) {
                        val number = 10f.pow(index * 2).toInt()
                        badgeDrawable.number = number
                    }
                    // Alternatively init once and use badgeDrawable#setVisible(true, false)
                }
                badgingEnabled = true
            } else {
                bottomNavigation.menu.forEach { item ->
                    bottomNavigation.removeBadge(item.itemId)
                    // Alternatively init once and use badgeDrawable#setVisible(false, false)
                }
                badgingEnabled = false
            }
        }
        badgeGravityButton.setOnClickListener {
            val badgeGravity = when (bottomNavigation.getBadge(R.id.item1)?.badgeGravity) {
                BadgeDrawable.TOP_END -> BadgeDrawable.TOP_START
                BadgeDrawable.TOP_START -> BadgeDrawable.BOTTOM_START
                BadgeDrawable.BOTTOM_START -> BadgeDrawable.BOTTOM_END
                else -> BadgeDrawable.TOP_END
            }
            bottomNavigation.menu.forEachIndexed { _, item ->
                val badgeDrawable = bottomNavigation.getBadge(item.itemId)
                badgeDrawable?.badgeGravity = badgeGravity
            }
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
