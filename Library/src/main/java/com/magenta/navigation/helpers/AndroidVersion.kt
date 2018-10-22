package com.codebox.lib.android.os

import android.os.Build
import android.support.annotation.RequiresApi

/**
 * Created by Abed on 2/3/2018.
 */


inline fun api(newerSDK: Int, newerSDKBlock: () -> Unit) {
    if (Build.VERSION.SDK_INT >= newerSDK)
        newerSDKBlock()
}