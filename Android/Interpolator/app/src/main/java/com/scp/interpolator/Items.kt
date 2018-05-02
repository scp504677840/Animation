package com.scp.interpolator

import android.view.animation.*

object Items {

    /**
     * 获取item列表
     *
     * @return item列表
     */
    fun getItems(): ArrayList<Item> {
        val items = ArrayList<Item>()
        items.add(Item("LinearInterpolator", "动画一直在做匀速改变", LinearInterpolator()))
        items.add(Item("AccelerateInterpolator", "在动画开始的地方改变速度较慢，然后开始加速", AccelerateInterpolator()))
        items.add(Item("DecelerateInterpolator", "在动画开始的地方改变速度较快，然后开始减速", DecelerateInterpolator()))
        items.add(Item("AccelerateDecelerateInterpolator", "在动画开始和结束的地方改变速度较慢，在中间的时候加速", AccelerateDecelerateInterpolator()))
        items.add(Item("CycleInterpolator", "动画循环播放特定的次数，变化速度按正弦曲线改变", CycleInterpolator(5f)))
        items.add(Item("BounceInterpolator", "动画结束的地方采用弹球效果", BounceInterpolator()))
        items.add(Item("AnticipateOvershootInterpolator", "在动画开始的方法先向后退一小步，再开始动画，到结束的地方再超出一小步，最后回到动画结束的地方", AnticipateOvershootInterpolator()))
        items.add(Item("OvershootInterpolator", "动画快速到达终点并超出一小步，最后回到动画结束的地方", OvershootInterpolator()))
        items.add(Item("AnticipateInterpolator", "在动画开始的地方先向后退一小步，再快速到达动画结束的地方", AnticipateInterpolator()))
        return items
    }

}