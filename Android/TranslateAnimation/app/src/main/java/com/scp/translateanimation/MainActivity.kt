package com.scp.translateanimation

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //初始化View
        initView()
    }

    /**
     * 初始化View
     */
    private fun initView() {
        //main_icon_iv.setOnClickListener { start() }
        //main_icon_iv.setOnClickListener { fromXML() }
        main_icon_iv.setOnClickListener { fromSetXML() }
    }

    private fun start() {
        //在动画开始时应用的X坐标变化
        //在动画结尾应用的X坐标变化
        //在动画开始时应用的Y坐标变化
        //在动画结尾应用的Y坐标变化
        //val translateAnimation = TranslateAnimation(0f, 300f, 0f, 300f)

        //ABSOLUTE：绝对
        //RELATIVE_TO_SELF：相对于自己
        //RELATIVE_TO_PARENT：相对于父视图
        /*val translateAnimation = TranslateAnimation(Animation.ABSOLUTE, 0f,
                Animation.ABSOLUTE, 500f,
                Animation.ABSOLUTE, 0f,
                Animation.ABSOLUTE, 500f)*/

        //参阅：https://github.com/scp504677840/Animation/blob/master/Android/RotateAnimation/app/src/main/java/com/scp/rotateanimation/MainActivity.kt
        /*val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 1f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 1f)*/

        //参阅：https://github.com/scp504677840/Animation/blob/master/Android/RotateAnimation/app/src/main/java/com/scp/rotateanimation/MainActivity.kt
        val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.5f)

        //translateAnimation.detachWallpaper=

        //动画持续时间
        translateAnimation.duration = 3000

        //动画结束后，视图是否停留在动画的最后一帧
        translateAnimation.fillAfter = true

        //动画结束后，视图是否停留在动画的第一帧，该属性配合fillEnabled使用，若fillEnabled为false，则该属性无效。
        translateAnimation.fillBefore = true

        //该属性的启用或停用决定着fillBefore有效还是无效
        translateAnimation.isFillEnabled = true

        //translateAnimation.interpolator=

        //动画重复次数
        translateAnimation.repeatCount = 3

        //动画重复模式
        translateAnimation.repeatMode = Animation.REVERSE

        //动画延时多久开始
        translateAnimation.startOffset = 1000

        //translateAnimation.zAdjustment=

        //设置动画监听
        translateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                Log.e("MainActivity", "动画开始")
            }

            override fun onAnimationEnd(animation: Animation) {
                Log.e("MainActivity", "动画结束")
            }

            override fun onAnimationRepeat(animation: Animation) {
                Log.e("MainActivity", "动画重复")
            }
        })

        //开始执行动画
        main_icon_iv.startAnimation(translateAnimation)
    }

    private fun fromXML() {
        val translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate) as TranslateAnimation

        //设置动画监听
        translateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                Log.e("MainActivity", "动画开始")
            }

            override fun onAnimationEnd(animation: Animation) {
                Log.e("MainActivity", "动画结束")
            }

            override fun onAnimationRepeat(animation: Animation) {
                Log.e("MainActivity", "动画重复")
            }
        })

        main_icon_iv.startAnimation(translateAnimation)
    }

    private fun fromSetXML() {

        val animationSet = AnimationUtils.loadAnimation(this, R.anim.set_translate) as AnimationSet

        val translateAnimation = animationSet.animations[0] as TranslateAnimation

        //设置动画监听
        translateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                Log.e("MainActivity", "动画开始")
            }

            override fun onAnimationEnd(animation: Animation) {
                Log.e("MainActivity", "动画结束")
            }

            override fun onAnimationRepeat(animation: Animation) {
                Log.e("MainActivity", "动画重复")
            }
        })

        //设置动画监听
        animationSet.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                Log.e("MainActivity", "animationSet 动画开始")
            }

            override fun onAnimationEnd(animation: Animation) {
                Log.e("MainActivity", "animationSet 动画结束")
            }

            override fun onAnimationRepeat(animation: Animation) {
                Log.e("MainActivity", "animationSet 动画重复")
            }
        })

        main_icon_iv.startAnimation(animationSet)

    }
}
