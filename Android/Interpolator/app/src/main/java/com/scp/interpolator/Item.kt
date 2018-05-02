package com.scp.interpolator

import android.view.animation.Interpolator

data class Item constructor(var className: String,
                            var desc: String,
                            var interpolator: Interpolator)