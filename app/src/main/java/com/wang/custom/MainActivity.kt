package com.wang.custom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wang280727.customview.RCImageView

class MainActivity : AppCompatActivity() {
    var rCImageView: RCImageView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}