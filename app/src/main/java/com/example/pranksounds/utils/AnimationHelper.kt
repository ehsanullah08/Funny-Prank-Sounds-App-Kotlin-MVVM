package com.example.pranksounds.utils

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import com.example.pranksounds.ui.activities.MainActivity


object AnimationHelper {

    // Scale the image to 1.5 times its size in both x and y direction
    private lateinit var scaleX: ObjectAnimator
    private lateinit var scaleY: ObjectAnimator
    private lateinit var shake: ObjectAnimator

    private lateinit var vibrator: Vibrator


    fun startAnimation(context: Context, view: View, startVibration: Boolean) {
        scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.5f)
        scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.5f)
        shake = ObjectAnimator.ofFloat(
            view,
            "translationX",
            0f,
            10f,
            -10f,
            10f,
            -10f,
            0f
        )

        scaleX.duration = 100
        scaleY.duration = 100
        shake.duration = 100 // Control the speed of shaking

        scaleX.repeatCount = ObjectAnimator.INFINITE
        scaleY.repeatCount = ObjectAnimator.INFINITE

        scaleX.repeatMode = ObjectAnimator.REVERSE
        scaleY.repeatMode = ObjectAnimator.REVERSE

        shake.repeatCount = ObjectAnimator.INFINITE
        shake.repeatMode = ObjectAnimator.REVERSE

        scaleX.start()
        scaleY.start()
        shake.start()

        if (startVibration)
            startVibration(context)
    }

    fun stopAnimation() {
        scaleX.cancel()
        scaleY.cancel()
        shake.cancel()

        stopVibration()
    }

    fun startVibration(context: Context) {

        vibrator = ContextCompat.getSystemService(context, Vibrator::class.java) as Vibrator

        if (ContextCompat.checkSelfPermission(
                context,
                "android.permission.VIBRATE"
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val pattern = longArrayOf(
                    0,
                    500,
                    0,
                    500
                ) // (start immediately, vibrate, pause, vibrate, etc.)
                val repeatIndex = 1 // Repeat from the second item in the pattern

                // Create a VibrationEffect with the pattern
                val effect = VibrationEffect.createWaveform(pattern, repeatIndex)
                vibrator.vibrate(effect)
            } else {
                vibrator.vibrate(500) // For older Android versions where it's not deprecated
            }
        }
    }

    fun stopVibration() {
        if (::vibrator.isInitialized)
            vibrator.cancel()
    }
}
