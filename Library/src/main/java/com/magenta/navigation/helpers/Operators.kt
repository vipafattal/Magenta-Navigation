package com.magenta.navigation.helpers

import android.view.ViewGroup

internal infix operator fun ViewGroup.get(index: Int) = getChildAt(index)
