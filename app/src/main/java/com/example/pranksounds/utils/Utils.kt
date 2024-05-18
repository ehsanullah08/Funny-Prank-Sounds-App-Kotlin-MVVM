package com.example.pranksounds.utils

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.ImageButton
import com.example.pranksounds.ui.activities.MainActivity


object Utils {

    fun restartApp(activity: Activity) {
        val intent = Intent(activity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.startActivity(intent)
        activity.finish()
        Runtime.getRuntime().exit(0)
    }
}
