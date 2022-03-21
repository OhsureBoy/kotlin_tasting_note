package com.study.tastingnote.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.study.tastingnote.R

@BindingAdapter("visibleIf")
fun View.visibleIf(value: Boolean){
    visibility = when(value){
        true -> View.VISIBLE
        else -> View.INVISIBLE
    }
}

@BindingAdapter("trackImage")
fun loadTrackImage(view: ImageView, imageUrl: String){
    Glide.with(view.context)
        .load(imageUrl)
        .placeholder(R.drawable.img_placeholder)
        .into(view)
}