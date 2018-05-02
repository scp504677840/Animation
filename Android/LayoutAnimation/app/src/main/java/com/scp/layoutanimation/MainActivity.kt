package com.scp.layoutanimation

import android.os.Bundle
import android.os.Handler
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.AlphaAnimation
import android.view.animation.LayoutAnimationController
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
        // 创建透明度动画
        val alphaAnimation = AlphaAnimation(0f, 1f)
        alphaAnimation.duration = 3000

        // 创建Layout动画，针对ViewGroup里面的子View执行的动画。
        val layoutAnimation = LayoutAnimationController(alphaAnimation)

        // ViewGroup里面每个子View执行动画前延迟多久
        // 拿上面的alphaAnimation.duration = 3000来说，这里的0.5系数乘以动画执行时长=延迟时间 = 3000 * 0.5 = 1500
        // 也就是说第一个View延时1500ms开始执行动画，第二个是延时1500 + 1500 = 3000ms，第三个是1500 + 1500 + 1500 = 4500ms 。。。以此类推
        layoutAnimation.delay  = 0.5f

        //ORDER_NORMAL：正常播放入场动画。
        //ORDER_REVERSE：逆向播放入场动画。
        //ORDER_RANDOM：随机播放入场动画。
        layoutAnimation.order = LayoutAnimationController.ORDER_NORMAL

        handler.postDelayed(Runnable {
            main_rv.setHasFixedSize(true)
            main_rv.layoutManager = LinearLayoutManager(this)
            //设置layoutAnimation；注意：main_rv.itemAnimation同样可以表达item动画。
            main_rv.layoutAnimation = layoutAnimation
            main_rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
            val adapter = Adapter(this)
            main_rv.adapter = adapter
            val names = ArrayList<String>()
            for (x in 0..99){
                names.add("jack$x")
            }
            adapter.names = names
        },5000)
    }

    private val handler = Handler()
}
