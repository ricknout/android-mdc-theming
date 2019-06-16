package com.ricknout.mdctheming.card

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ricknout.mdctheming.R
import io.material.catalog.draggable.DraggableCoordinatorLayout
import kotlinx.android.synthetic.main.activity_card.*

class CardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)
        setupChecking()
        setupDragging()
    }

    private fun setupChecking() {
        card.setOnLongClickListener {
            card.isChecked = !card.isChecked
            true
        }
    }

    private fun setupDragging() {
        parentContainer.addDraggableChild(card)
        parentContainer.setViewDragListener(object
            : DraggableCoordinatorLayout.ViewDragListener {

            override fun onViewCaptured(view: View, pointerId: Int) {
                card.isDragged = true
            }

            override fun onViewReleased(view: View, xVelocity: Float, yVelocity: Float) {
                card.isDragged = false
            }
        })
    }
}
