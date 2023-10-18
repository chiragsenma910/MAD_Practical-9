package com.example.mad_prac_9_106_5b6

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.mad_prac_9_106_5b6.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity(), Animation.AnimationListener {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var guni_framebyframeanimation: AnimationDrawable
    private lateinit var twinanimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgLogo.setBackgroundResource(R.drawable.uvpce_image_list)
        guni_framebyframeanimation=binding.imgLogo.background as AnimationDrawable
        guni_framebyframeanimation.isOneShot = true
        twinanimation= AnimationUtils.loadAnimation(this,R.anim.grow)
        twinanimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            guni_framebyframeanimation.start()
            binding.imgLogo.startAnimation(twinanimation)
        }
        else
        {
            guni_framebyframeanimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Intent(this,MainActivity::class.java).also { startActivity(it)}
        overridePendingTransition(R.anim.scale_center_in,R.anim.scale_center_out)
        finish()
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }

}