package com.ricknout.mdctheming.bottomappbar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.shape.MaterialShapeDrawable
import com.ricknout.mdctheming.R
import io.material.catalog.bottomappbar.BottomAppBarCutCornersTopEdge
import kotlinx.android.synthetic.main.activity_bottom_app_bar.*

class BottomAppBarActivity : AppCompatActivity() {

    private val oneDp by lazy { resources.getDimensionPixelSize(R.dimen.one_dp).toFloat() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)
        setupButtons()
        setupBottomAppBarMenuAndNavigation()
        //setupBottomAppBarCutCornersBackground()
    }

    private fun setupButtons() {
        fabAlignmentModeButton.setOnClickListener {
            val alignmentMode = if (bottomAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER)
                BottomAppBar.FAB_ALIGNMENT_MODE_END else BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            bottomAppBar.fabAlignmentMode = alignmentMode
        }
        fabAnimationModeButton.setOnClickListener {
            val animationMode = if (bottomAppBar.fabAnimationMode == BottomAppBar.FAB_ANIMATION_MODE_SCALE) {
                BottomAppBar.FAB_ANIMATION_MODE_SLIDE
            } else {
                BottomAppBar.FAB_ANIMATION_MODE_SCALE
            }
            bottomAppBar.fabAnimationMode = animationMode
        }
        increaseFabCradleMarginButton.setOnClickListener {
            val cradleMargin = (bottomAppBar.fabCradleMargin + oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.fabCradleMargin = cradleMargin
        }
        decreaseFabCradleMarginButton.setOnClickListener {
            val cradleMargin = (bottomAppBar.fabCradleMargin - oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.fabCradleMargin = cradleMargin
        }
        increaseFabCradleCornerRadiusButton.setOnClickListener {
            val cradleCornerRadius = (bottomAppBar.fabCradleRoundedCornerRadius + oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.fabCradleRoundedCornerRadius = cradleCornerRadius
        }
        decreaseFabCradleCornerRadiusButton.setOnClickListener {
            val cradleCornerRadius = (bottomAppBar.fabCradleRoundedCornerRadius - oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.fabCradleRoundedCornerRadius = cradleCornerRadius
        }
        increaseFabCradleVerticalOffsetButton.setOnClickListener {
            val cradleVerticalOffset = (bottomAppBar.cradleVerticalOffset + oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.cradleVerticalOffset = cradleVerticalOffset
        }
        decreaseFabCradleVerticalOffsetButton.setOnClickListener {
            val cradleVerticalOffset = (bottomAppBar.cradleVerticalOffset - oneDp).coerceIn(0f, 16 * oneDp)
            bottomAppBar.cradleVerticalOffset = cradleVerticalOffset
        }
    }

    private fun setupBottomAppBarMenuAndNavigation() {
        bottomAppBar.replaceMenu(R.menu.menu_bottom_app_bar)
        bottomAppBar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.item1 -> {
                    Toast.makeText(this, "Clicked menu item 1", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item2 -> {
                    Toast.makeText(this, "Clicked menu item 2", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item3 -> {
                    Toast.makeText(this, "Clicked menu item 3", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        bottomAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "Clicked navigation item", Toast.LENGTH_SHORT).show()
        }
    }

    // BUG: Shape theming is not supported by default for the BottomAppBar cradle
    // Use this function to enable cut corners for the BottomAppBar FAB cradle
    // Note: It does NOT respond to increasing/decreasing the FAB cradle margin, rounded corner radius or vertical offset
    // Copied from: https://github.com/material-components/material-components-android/blob/master/catalog/java/io/material/catalog/bottomappbar/BottomAppBarCutCornersTopEdge.java
    // See: https://issuetracker.google.com/issues/127454207
    private fun setupBottomAppBarCutCornersBackground() {
        val topEdge = BottomAppBarCutCornersTopEdge(
            bottomAppBar.fabCradleMargin,
            bottomAppBar.fabCradleRoundedCornerRadius,
            bottomAppBar.cradleVerticalOffset
        )
        val background = bottomAppBar.background as MaterialShapeDrawable
        background.shapeAppearanceModel = background.shapeAppearanceModel.toBuilder().setTopEdge(topEdge).build()
        background.invalidateSelf()
    }
}
