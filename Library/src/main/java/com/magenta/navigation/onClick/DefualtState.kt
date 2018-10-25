package com.magenta.navigation.onClick

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.magenta.navigation.helpers.get

internal fun ViewGroup.loadDefaultActionState(clickedNav: MaterialCardView, defaultCardElevation: Float, accentDefaultColor: Int, defaultNavColor: Int) {
    for (index in 0 until childCount) {
        val parentClickedView = getChildAt(index) as LinearLayout
        val cardNav = parentClickedView[0] as MaterialCardView

        if (cardNav != clickedNav)
            parentClickedView.defaultState(defaultCardElevation, accentDefaultColor, defaultNavColor)
    }
}

private fun ViewGroup.defaultState(defaultCardElevation: Float, accentDefaultColor: Int, defaultNavColor: Int) {
    val cardView = this[0] as MaterialCardView
    val textView = this[1] as TextView
    val imgView = cardView[0][0] as ImageView
    cardView.cardElevation = defaultCardElevation
    textView.setTextColor(accentDefaultColor)
    imgView.setColorFilter(accentDefaultColor)
    cardView.setCardBackgroundColor(defaultNavColor)
}