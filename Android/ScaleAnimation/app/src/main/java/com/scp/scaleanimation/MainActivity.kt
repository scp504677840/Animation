package com.scp.scaleanimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        initView()
    }

    private fun initView() {
        //main_icon_iv.setOnClickListener { start() }
        //main_icon_iv.setOnClickListener { fromXML() }
        main_icon_iv.setOnClickListener { fromSet() }
    }

    /**
     * 从代码中生成动画
     */
    private fun start() {
        // fromX在动画开始时应用的水平缩放系数
        // toX在动画结尾处应用的水平缩放系数
        // fromY在动画开始时应用的垂直缩放系数
        // toY在动画结尾处应用的垂直缩放系数
        //val scaleAnimation = ScaleAnimation(1f, 0.5f, 1f, 0.5f)

        // 缩放中心，绝对坐标
        /*val scaleAnimation = ScaleAnimation(1f, 0.5f, 1f, 0.5f,
                main_icon_iv.width.div(2).toFloat(),
                main_icon_iv.width.div(2).toFloat())*/

        //ABSOLUTE：绝对
        //RELATIVE_TO_SELF：相对于自己
        //RELATIVE_TO_PARENT：相对于父视图
        /*val scaleAnimation = ScaleAnimation(1f, 0.5f, 1f, 0.5f,
                Animation.ABSOLUTE, 200f, Animation.ABSOLUTE, 200f)*/

        //参阅：https://github.com/scp504677840/Animation/blob/master/Android/RotateAnimation/app/src/main/java/com/scp/rotateanimation/MainActivity.kt
        /*val scaleAnimation = ScaleAnimation(1f, 0.5f, 1f, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)*/

        //参阅：https://github.com/scp504677840/Animation/blob/master/Android/RotateAnimation/app/src/main/java/com/scp/rotateanimation/MainActivity.kt
        val scaleAnimation = ScaleAnimation(1f, 0.5f, 1f, 0.5f,
                Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f)

        //scaleAnimation.detachWallpaper=

        //动画持续时间
        scaleAnimation.duration = 3000

        //动画结束后，视图是否停留在最后一帧
        scaleAnimation.fillAfter = true

        //动画结束后，视图是否停留在动画的第一帧，该属性配合fillEnabled使用，若fillEnabled为false，则该属性无效。
        //scaleAnimation.fillBefore = false

        //该属性的启用或停用决定着fillBefore有效还是无效
        //scaleAnimation.isFillEnabled = true

        //scaleAnimation.interpolator=

        //动画重复次数
        //scaleAnimation.repeatCount = 3

        //动画重复模式
        //scaleAnimation.repeatMode = Animation.REVERSE

        //动画延时多久开始
        //scaleAnimation.startOffset = 1000

        //scaleAnimation.zAdjustment=

        //设置动画监听事件
        scaleAnimation.setAnimationListener(object : Animation.AnimationListener {
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

        //开始动画
        main_icon_iv.startAnimation(scaleAnimation)
    }

    /**
     * 从XML中生成动画
     */
    private fun fromXML() {
        val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale) as ScaleAnimation
        main_icon_iv.startAnimation(scaleAnimation)
    }

    /**
     * 从setXML中生成动画
     */
    private fun fromSet() {
        val animationSet = AnimationUtils.loadAnimation(this, R.anim.set_scale) as AnimationSet

        val scaleAnimation = animationSet.animations[0] as ScaleAnimation
        //设置动画监听事件
        scaleAnimation.setAnimationListener(object : Animation.AnimationListener {
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

        //设置动画监听事件
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
