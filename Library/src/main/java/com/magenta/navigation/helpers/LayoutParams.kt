package com.magenta.navigation.helpers

import android.view.ViewGroup

inline fun layoutParam(width: Int, height: Int, block: ViewGroup.LayoutParams.() -> Unit) =
        ViewGroup.LayoutParams(width, height).apply(block)


