package com.scp.alphaanimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.Animation.*
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
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
        //main_start_tv.setOnClickListener { start() }
        //main_start_tv.setOnClickListener { formXML() }
        main_start_tv.setOnClickListener { formSet() }
    }

    /**
     * 从代码中生成动画
     */
    private fun start() {
        //动画的alpha值，其中1.0表示完全不透明，0.0表示完全透明。

        //从透明到不透明
        val alphaAnimation = AlphaAnimation(0.0f, 1.0f)

        //是否在壁纸上运行
        //alphaAnimation.detachWallpaper = true

        //持续时间
        alphaAnimation.duration = 3000

        //保持动画执行后状态
        alphaAnimation.fillAfter = false

        //保持动画执行前状态
        alphaAnimation.fillBefore = true

        //是否开启保持动画状态操作
        //如果fillEnabled为true，则动画将应用fillBefore的值。否则，将忽略fillBefore，并始终应用动画转换，直到动画结束。
        alphaAnimation.isFillEnabled = true

        //alphaAnimation.interpolator =

        //重复次数
        //INFINITE:无限循环
        alphaAnimation.repeatCount = 3

        //重复模式:RESTART REVERSE
        //RESTART:每次重复都从头到尾
        //REVERSE:每次重复都从尾到头
        //alphaAnimation.repeatMode = Animation.RESTART

        //延时多久开始执行动画
        //注意：这个延时时间不只是在动画第一次执行时才有效，它在每一次动画执行时都生效，其中包括重复动画。
        //alphaAnimation.startOffset = 1000

        //表示被animated的内容在运行时在z轴上的位置，默认为normal。
        //ZORDER_NORMAL ZORDER_TOP ZORDER_BOTTOM
        //normal保持内容当前的z轴顺序
        //top运行时在最顶层显示
        //bottom运行时在最底层显示
        //alphaAnimation.zAdjustment = ZORDER_TOP

        alphaAnimation.setAnimationListener(object : AnimationListener {
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

        main_icon_iv.startAnimation(alphaAnimation)

    }

    /**
     * 从alphaXML中生成动画
     * 1.可以直接强转为AlphaAnimation
     * 2.可以设置动画监听
     */
    private fun formXML() {
        val alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha) as AlphaAnimation
        alphaAnimation.setAnimationListener(object : AnimationListener {
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
        main_icon_iv.startAnimation(alphaAnimation)
        Log.e("MainActivity", "formXML")
    }

    /**
     * 从setXML中生成动画
     * 1.强转时一定要注意，最外层是AnimationSet，而不是AlphaAnimation，也就是说具体动画放在动画集合中，强转时需注意。
     * 2.当已知动画类型时，可直接强转为已知动画类型；当未知动画类型时，先判断，再强转。
     * 3.设置动画监听时需注意，动画集合监听只能监听到最外层到动画集合到变化，而监听不到里面子动画到变化；如需监听子动画到变化，请取得动画集合中具体子动画再设置动画监听。
     */
    private fun formSet() {
        val animationSet = AnimationUtils.loadAnimation(this, R.anim.set_alpha) as AnimationSet

        //未知情况，就是你不知道setXml里面的第一个是什么动画，就先判断一下类型
        //val alphaAnimation = animationSet.animations[0]
        //Log.e("MainActivity", "alphaAnimation ? ${alphaAnimation is AlphaAnimation}")

        //已知情况，就是你知道setXML里面的第一个是AlphaAnimation，就直接强转为AlphaAnimation
        val alphaAnimation = animationSet.animations[0] as AlphaAnimation

        alphaAnimation.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                Log.e("MainActivity", "alphaAnimation 动画开始")
            }

            override fun onAnimationEnd(animation: Animation) {
                Log.e("MainActivity", "alphaAnimation 动画结束")
            }

            override fun onAnimationRepeat(animation: Animation) {
                Log.e("MainActivity", "alphaAnimation 动画重复")
            }
        })

        animationSet.setAnimationListener(object : AnimationListener {
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
        Log.e("MainActivity", "formSet")
    }
}
