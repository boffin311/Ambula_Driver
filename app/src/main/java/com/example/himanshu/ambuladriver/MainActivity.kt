package com.example.himanshu.ambuladriver

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnTouchListener {
    var width: Int = 0
    var window_x_cord: Int = 0
    //    var dpiValue: Float = 0f
    var initialX = 0f
    var finalX = 0f

    val TAG = "MAIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutParams = image_swiper.layoutParams as FrameLayout.LayoutParams
        bottom_nav_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_profile -> {
                    var intent = Intent(this@MainActivity, ScrollingActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> true
            }
        }
        window.statusBarColor=resources.getColor(R.color.colorOffStateStatus)
        window_x_cord = window.windowManager.defaultDisplay.width
        image_swiper.setOnTouchListener(this)
        width = layoutParams.width

        //int x=getContext().getResources().getDisplayMatrix().densityDpi/DisplayMatrix.Default_Value
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {


        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                initialX = event.rawX
                //  Log.d(TAG, "Down  $initialX")

            }
            MotionEvent.ACTION_UP -> {
                finalX = event.rawX
                Log.d(TAG, "$initialX    $finalX")

                if (initialX < finalX) {
                    if (finalX > window_x_cord / 2) {
                        Log.d(TAG, "$width")
                        image_swiper.setImageResource(R.drawable.ic_ambulance_on)
                        frameDriverState.setBackgroundResource(R.color.colorOnState)
                        window.statusBarColor=resources.getColor(R.color.colorONStateStatus)
                        tvDriverState.setText(R.string.on_duty)
                        var objectAnimator =
                            ObjectAnimator.ofFloat(image_swiper, "TranslationX", window_x_cord - width * 1f)
                        with(objectAnimator)
                        {
                            duration = 100
                            start()
                        }

                    }
                } else if (initialX > finalX) {
                    if (initialX > window_x_cord / 2) {
                        image_swiper.setImageResource(R.drawable.ic_ambulance_off)
                        frameDriverState.setBackgroundResource(R.color.colorOffState)
                        tvDriverState.setText(R.string.off_duty)
                        window.statusBarColor=resources.getColor(R.color.colorOffStateStatus)
                        var objectAnimator = ObjectAnimator.ofFloat(image_swiper, "TranslationX", 0f)
                        with(objectAnimator)
                        {
                            duration = 100
                            start()
                        }

                    }

                }

            }
            else -> {
            }
        }
        return true
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        var menuInflater = menuInflater
//        menuInflater.inflate(R.menu.menu_bottom_nav_view, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//
//        when (item?.itemId) {
//            R.id.menu_profile -> {
//
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

//    fun convertDpToPx(context: Context, dp: Float): Float {
//        return dp * (context.resources.displayMetrics.densityDpi / (DisplayMetrics.DENSITY_DEFAULT))
//    }
}
