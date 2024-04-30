package com.example.pranksounds.ui.adapters

import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.pranksounds.R

@BindingAdapter("imageFromUrl")
fun ImageView.imageFromUrl(url: String) {
    Glide.with(this.context).load(url).into(this)
}

@BindingAdapter("imageFromDrawable")
fun ImageView.imageFromDrawable(drawableId: Int) {
    Glide.with(this.context).load(drawableId).into(this)
}

@BindingAdapter("backgroundTintColor")
fun setBackgroundTint(frameLayout: FrameLayout, colorResId: Int) {
    val context = frameLayout.context

    // Convert the color integer value to hexadecimal string
    val hexColor = Integer.toHexString(colorResId).uppercase()

    frameLayout.backgroundTintList =
        ColorStateList.valueOf(Color.parseColor("#50${hexColor.substring(2)}"))
}