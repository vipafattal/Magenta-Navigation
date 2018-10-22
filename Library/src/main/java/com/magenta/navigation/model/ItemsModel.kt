package com.magenta.navigation.model

import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes

data class ItemsModel(val title:String, @DrawableRes @ColorRes val drawable: Drawable,val itemID:Int)