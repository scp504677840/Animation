package com.scp.interpolator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.animation.Animation
import android.view.animation.Interpolator
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /**
     * 平移动画
     */
    private lateinit var translateAnimation: TranslateAnimation

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
        //初始化动画
        initAnimation()
        //初始化RecyclerView
        initRecyclerView()
    }

    /**
     * 初始化动画
     */
    private fun initAnimation() {
        translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.5f,
                Animation.RELATIVE_TO_PARENT, 0f,
                Animation.RELATIVE_TO_PARENT, 0.5f)

        //动画持续时间
        translateAnimation.duration = 3000

        //动画结束后，视图是否停留在动画的最后一帧
        translateAnimation.fillAfter = true
    }

    /**
     * 初始化RecyclerView
     */
    private fun initRecyclerView() {
        main_rv.setHasFixedSize(true)
        main_rv.itemAnimator = DefaultItemAnimator()
        main_rv.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        main_rv.layoutManager = LinearLayoutManager(this)
        val adapter = Adapter(this)
        adapter.onItemClickListener = object : Adapter.OnItemClickListener {
            override fun onClick(interpolator: Interpolator) {
                main_icon_iv.clearAnimation()
                translateAnimation.interpolator = interpolator
                main_icon_iv.startAnimation(translateAnimation)
            }
        }
        main_rv.adapter = adapter
        adapter.items = Items.getItems()
    }
}
