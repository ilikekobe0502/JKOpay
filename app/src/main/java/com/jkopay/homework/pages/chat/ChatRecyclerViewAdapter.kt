package com.jkopay.homework.pages.chat

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jkopay.homework.R
import com.jkopay.homework.repository.data.MessageContent
import kotlinx.android.synthetic.main.item_left_chat_content.view.*

class ChatRecyclerViewAdapter : RecyclerView.Adapter<ChatRecyclerViewAdapter.ViewHolder>() {
    val data: ArrayList<MessageContent> = ArrayList()
    var listener: View.OnClickListener? = null

    enum class Type {
        OTHER,
        MYSELF
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var view: View? = null
        view = when (p1) {
            Type.OTHER.ordinal ->
                LayoutInflater.from(p0.context).inflate(R.layout.item_left_chat_content, p0, false)
            Type.MYSELF.ordinal ->
                LayoutInflater.from(p0.context).inflate(R.layout.item_right_chat_content, p0, false)
            else ->
                LayoutInflater.from(p0.context).inflate(R.layout.item_left_chat_content, p0, false)
        }


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (data[position].id == 0) {
            Type.OTHER.ordinal
        } else {
            Type.MYSELF.ordinal
        }
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        val item = data[p1]
        p0.itemView.apply {
            val context = p0.itemView.context
            textView_name.text = item.name
            textView_message.text = item.message
            textView_time.text = item.time
            if (item.id == 0) {
                imageView_person.setBackgroundColor(Color.YELLOW)
            } else {
                imageView_person.setBackgroundColor(Color.BLUE)
            }
            imageView_person.setOnClickListener {
                it.tag = p1
                listener?.onClick(it)
            }
        }
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {}
}