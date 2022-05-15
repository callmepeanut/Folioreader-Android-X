package com.folioreader.util

import android.app.Activity
import android.graphics.Color
import android.util.Log
import android.widget.FrameLayout
import androidx.core.view.ViewCompat


/**
 * 必须在Activity的onCreate时调用
 */
fun Activity.immersiveStatusBar(isLight: Boolean) {

    window.statusBarColor = Color.TRANSPARENT //Color.parseColor("#55FFFFFF")
    window.navigationBarColor = Color.BLACK

    val contentView = findViewById<FrameLayout>(android.R.id.content)
    val controller =
        ViewCompat.getWindowInsetsController(contentView)
    if (controller == null) {
        Log.e("immersive", "controller == null")
    } else {
        controller.isAppearanceLightStatusBars = isLight
    }
    //let system set the padding of status bar
    contentView.post {
        contentView.fitsSystemWindows = true
    }
}