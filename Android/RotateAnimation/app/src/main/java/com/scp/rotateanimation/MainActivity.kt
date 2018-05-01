package com.scp.rotateanimation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
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
        //main_icon_iv.setOnClickListener { formXML() }
        main_icon_iv.setOnClickListener { formSet() }
    }

    /**
     * 从代码中生成动画
     */
    private fun start() {
        //Degrees：将弧度转换为角度

        //开始旋转角度90，结束旋转角度180，旋转中心（0，0）
        //val rotateAnimation = RotateAnimation(90f, 180f)

        //开始旋转角度0，结束旋转角度360，旋转中心（视图宽度的一半，视图高度的一半），既旋转中心为视图的中心。
        //val rotateAnimation = RotateAnimation(0f, 360f, main_icon_iv.width.div(2).toFloat(), main_icon_iv.height.div(2).toFloat())

        //ABSOLUTE：绝对
        //RELATIVE_TO_SELF：相对于自己
        //RELATIVE_TO_PARENT：相对于父视图
        /*val rotateAnimation = RotateAnimation(0f, 360f,
                Animation.ABSOLUTE, main_icon_iv.width.div(2).toFloat(),
                Animation.ABSOLUTE, main_icon_iv.height.div(2).toFloat())*/

        //相对于自己，旋转中心为pivotValue * 自身宽度或高度
        /*val rotateAnimation = RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)*/

        // 假设：父视图宽1200，高2400，自身宽度为400，高度为400，自身居中显示，
        // 这时自身左上角坐标为：
        // 1.父视图宽度的一半：1200 ／ 2 = 600
        // 2.父视图高度的一半：2400 ／ 2 = 1200
        // 3.自身宽度的一半：400 ／ 2 = 200
        // 4.自身高度的一半：400 ／ 2 = 200
        // 5.父视图宽度的一半减去自身宽度的一半得到X轴上的坐标：600 - 200 = 400
        // 6.父视图高度的一半减去自身高度的一半得到Y轴上的坐标：1200 - 200 = 1000
        // 7.于是自身左上角的坐标为（400，1000）
        // 相对于父视图，旋转中心为，pivotValue * 父视图宽度或高度，
        // 然后从自身左上角（400，1000）开始算起，
        // 也就是（400，1000）+（pivotValue * 父视图宽度，pivotValue * 父视图高度）
        // （400 + 0.5 * 1200，1000 + 0.5 * 2400）= （1000，2200）
        // 验证：pivotValue将设为0f，
        // 此时（400，1000）+（pivotValue * 父视图宽度，pivotValue * 父视图高度）为
        // （400，1000）+（0 * 1200，0 * 2400）= （400，1000）
        // 从实际运行中，我们可以看到，图像很明显就是在以（400，1000）为旋转中心旋转着，（400，1000）也就是我们自身视图的左上角坐标。
        val rotateAnimation = RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0f)

        //rotateAnimation.detachWallpaper=

        //动画持续时间
        rotateAnimation.duration = 3000

        //动画结束后，视图是否停留在动画的最后一帧
        rotateAnimation.fillAfter = true

        //动画结束后，视图是否停留在动画的第一帧，该属性配合fillEnabled使用，若fillEnabled为false，则该属性无效。
        //rotateAnimation.fillBefore = true

        //该属性的启用或停用决定着fillBefore有效还是无效
        //rotateAnimation.isFillEnabled = true

        //rotateAnimation.interpolator=

        //动画重复次数
        rotateAnimation.repeatCount = Animation.INFINITE

        //动画重复模式
        //rotateAnimation.repeatMode = Animation.REVERSE

        //动画延时多久开始
        //rotateAnimation.startOffset = 3000

        //rotateAnimation.zAdjustment=

        //设置动画监听
        rotateAnimation.setAnimationListener(object : Animation.AnimationListener {
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

        main_icon_iv.startAnimation(rotateAnimation)
    }

    /**
     * 从rotateXML中生成动画
     */
    private fun formXML() {
        val rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)

        //设置动画监听
        rotateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                Log.e("MainActivity", "formXML 动画开始")
            }

            override fun onAnimationEnd(animation: Animation) {
                Log.e("MainActivity", "formXML 动画结束")
            }

            override fun onAnimationRepeat(animation: Animation) {
                Log.e("MainActivity", "formXML 动画重复")
            }
        })

        main_icon_iv.startAnimation(rotateAnimation)
    }

    /**
     * 从setXML中生成动画
     */
    private fun formSet() {
        val animationSet = AnimationUtils.loadAnimation(this, R.anim.set_rotate) as AnimationSet

        val rotateAnimation = animationSet.animations[0] as RotateAnimation

        rotateAnimation.setAnimationListener(object : Animation.AnimationListener {
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
                Log.e("MainActivity", "formSet 动画开始")
            }

            override fun onAnimationEnd(animation: Animation) {
                Log.e("MainActivity", "formSet 动画结束")
            }

            override fun onAnimationRepeat(animation: Animation) {
                Log.e("MainActivity", "formSet 动画重复")
            }
        })

        main_icon_iv.startAnimation(animationSet)
    }
}
