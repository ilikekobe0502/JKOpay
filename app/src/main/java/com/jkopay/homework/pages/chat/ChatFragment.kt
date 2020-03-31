package com.jkopay.homework.pages.chat

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.jkopay.homework.AppInjector
import com.jkopay.homework.R
import com.jkopay.homework.pages.base.InteractionView
import com.jkopay.homework.pages.base.OnPageInteractionListener
import com.jkopay.homework.repository.data.MessageContent
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment : InteractionView<OnPageInteractionListener.Primary>(), View.OnClickListener {

    private lateinit var mViewModel: ChatViewModel

    private val adapter = ChatRecyclerViewAdapter()

    companion object {
        fun newInstance(): ChatFragment = ChatFragment()
        private val TAG = ChatFragment::class.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = AppInjector.obtainViewModel(this)
        mViewModel.messagesResult.observe(this, Observer {
            success(it!!)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDetach() {
        mViewModel.destroy()
        super.onDetach()
    }

    override fun onStart() {
        super.onStart()
        recyclerView_chat?.let {
            it.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            it.adapter = adapter
            adapter.listener = this
        }

        mViewModel.getMessage()
    }

    override fun onClick(v: View?) {
        val position = v?.tag as Int
        adapter.data.removeAt(position)
        adapter.notifyItemRemoved(position)
        adapter.notifyItemRangeChanged(position, adapter.data.size - 1)
        Toast.makeText(context, "Delete one message", Toast.LENGTH_SHORT).show()
    }

    private fun success(it: MessageContent) {
        adapter.data.add(it)
        val position = adapter.data.size - 1
        adapter.notifyItemChanged(position)
        recyclerView_chat.smoothScrollToPosition(position)
    }
}