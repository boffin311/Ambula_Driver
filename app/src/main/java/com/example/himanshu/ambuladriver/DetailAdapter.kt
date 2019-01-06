package com.example.himanshu.ambuladriver

import android.content.Context
import android.opengl.Visibility
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.himanshu.ambuladriver.model.DetailList
import kotlinx.android.synthetic.main.rv_model_info.view.*


class DetailAdapter(var arrayList:ArrayList<DetailList>) : RecyclerView.Adapter<DetailAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyHolder {
    var layoutInflater=parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view=layoutInflater.inflate(R.layout.rv_model_info,parent,false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int = arrayList.size



    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.tvTitle.text=arrayList[position].title
        holder.tvSubTitleInfo.text=arrayList[position].subTitle
        if (position==arrayList.size-1)
        {holder.tvUnderLine.visibility=View.GONE}
    }

    class MyHolder(itemView:View):RecyclerView.ViewHolder(itemView){
      val tvTitle:TextView=itemView.tvTitle
        val tvSubTitleInfo:TextView=itemView.tvSubtitleInfo
        val tvUnderLine:TextView=itemView.tvUnderLine
    }
}