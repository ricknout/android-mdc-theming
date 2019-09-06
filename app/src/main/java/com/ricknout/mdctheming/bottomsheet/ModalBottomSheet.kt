package com.ricknout.mdctheming.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ricknout.mdctheming.R

class ModalBottomSheet : BottomSheetDialogFragment() {

    private var dismissWithAnimation = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.modal_bottom_sheet, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dismissWithAnimation = arguments?.getBoolean(ARG_DISMISS_WITH_ANIMATION) ?: false
        (requireDialog() as BottomSheetDialog).dismissWithAnimation = dismissWithAnimation
    }

    companion object {
        const val TAG = "ModalBottomSheet"
        private const val ARG_DISMISS_WITH_ANIMATION = "dismiss_with_animation"
        fun newInstance(dismissWithAnimation: Boolean): ModalBottomSheet {
            val modalBottomSheet = ModalBottomSheet()
            modalBottomSheet.arguments = bundleOf(ARG_DISMISS_WITH_ANIMATION to dismissWithAnimation)
            return modalBottomSheet
        }
    }
}