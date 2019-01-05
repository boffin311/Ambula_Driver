package com.example.himanshu.ambuladriver

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG="MAIN"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btn_one.setOnDragListener { v, event ->
           Log.d(TAG,""+event.action)
           when(event.action){
               DragEvent.ACTION_DRAG_STARTED-> {Log.d(TAG,"OnDragStarted:Started")
             true}
               DragEvent.ACTION_DRAG_ENTERED->{Log.d(TAG,"OnDragENtered:Entered")
               true}
               else->false
           }
       }
    }
}
