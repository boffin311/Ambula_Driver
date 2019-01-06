package com.example.himanshu.ambuladriver

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.WindowManager
import com.example.himanshu.ambuladriver.model.DetailList
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class ScrollingActivity : AppCompatActivity() {
var arrayList= arrayListOf<DetailList>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor=resources.getColor(R.color.mtrl_btn_transparent_bg_color)
        arrayList.add(DetailList("Email","himanshu31198@gmail.com"))
        arrayList.add(DetailList("Address","G-22 MCD colony Dhaka near kings Way Camp"))
        arrayList.add(DetailList("Phone No.","9868228063"))
        arrayList.add(DetailList("Vehicle No.","DLSG3327"))
        arrayList.add(DetailList("Agency","Apollo pvt.ltd"))
        Picasso.get().load("https://www.gettyimages.in/gi-resources/images/500px/983794168.jpg").into(image_driver)
        rvInfo.layoutManager=LinearLayoutManager(this)
        rvInfo.adapter=DetailAdapter(arrayList)
//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }
    }
}
