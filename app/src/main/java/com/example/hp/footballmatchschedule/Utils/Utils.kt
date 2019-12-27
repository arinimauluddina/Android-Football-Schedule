package com.example.hp.footballmatchschedule.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hp.footballmatchschedule.BuildConfig
import com.example.hp.footballmatchschedule.R

fun logI(tag: String, msg: String?){
    if (BuildConfig.DEBUG) Log.i(tag, "result:" + msg)
}

fun logW(tag: String, msg: String?){
    if (BuildConfig.DEBUG) Log.w(tag, msg)
}

fun logE(tag: String, msg: String?){
    if (BuildConfig.DEBUG) Log.i(tag, msg)
}

fun logD(tag: String, msg: String?){
    if (BuildConfig.DEBUG) Log.d(tag, msg)
}

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.invisible(){
    visibility= View.INVISIBLE
}

fun ImageView.loadImage(url: Any?){
    val option = RequestOptions()
        .placeholder(R.drawable.ic_launcher_background)

    Glide.with(this.context)
        .setDefaultRequestOptions(option)
        .load(url)
        .into(this)
}