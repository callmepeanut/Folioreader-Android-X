package com.folioreader.util

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.util.Log
import android.view.MotionEvent
import android.view.View

object SimulateTouchUtil {
    const val longClickTime = 420L
    private var isInSimulate = false

    fun simulateLongClickInTouch(view: View, x: Float, y: Float) {
        Log.i("SimulateTouchUtil","simulateLongClickInTouch isInSimulate:$isInSimulate")
        if (!isInSimulate) {
            Handler(Looper.getMainLooper()).post {
                simulateViewClick(view, x, y, longClickTime)
            }
        }
    }

    fun simulateViewClick(view: View, x: Float, y: Float, delayTime: Long) {
        val downTime = SystemClock.uptimeMillis()
        val eventDown = MotionEvent.obtain(downTime, downTime, MotionEvent.ACTION_DOWN, x, y, 0)
        view.onTouchEvent(eventDown)
        isInSimulate = true
        Handler(Looper.getMainLooper()).postDelayed({
            val upTime = SystemClock.uptimeMillis()
            val eventUp = MotionEvent.obtain(upTime, upTime, MotionEvent.ACTION_UP, x, y, 0)
            view.onTouchEvent(eventUp)
            eventUp.recycle()
            isInSimulate = false
        }, delayTime)
        eventDown.recycle()
    }
}