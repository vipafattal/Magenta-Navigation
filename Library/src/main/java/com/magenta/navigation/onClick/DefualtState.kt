package com.magenta.navigation.onClick

import android.support.design.card.MaterialCardView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

import com.magenta.navigation.helpers.get

internal fun ViewGroup.loadDefaultActionState(clickedNav: MaterialCardView,accentDefaultColor:Int,defaultNavColor:Int) {
    for (index in 0 until childCount) {
        val parentClickedView = getChildAt(index) as LinearLayout
        val cardNav = parentClickedView[0] as MaterialCardView

        if (cardNav != clickedNav)
            parentClickedView.defaultState(accentDefaultColor,defaultNavColor)
    }
}

private fun ViewGroup.defaultState(accentDefaultColor:Int,defaultNavColor:Int) {
    val cardView = this[0] as MaterialCardView
    val textView = this[1] as TextView
    val imgView = (cardView[0] as RelativeLayout)[0] as ImageView

    textView.setTextColor(accentDefaultColor)
    imgView.setColorFilter(accentDefaultColor)
    cardView.setCardBackgroundColor(defaultNavColor)
}