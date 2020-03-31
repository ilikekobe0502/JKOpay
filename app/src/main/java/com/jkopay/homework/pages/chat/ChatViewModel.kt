package com.jkopay.homework.pages.chat

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.jkopay.homework.repository.data.MessageContent
import com.jkopay.homework.repository.data.Messages
import com.jkopay.homework.repository.viewModel.BaseViewModel
import kotlinx.coroutines.*

class ChatViewModel(application: Application) : BaseViewModel(application) {

    private var fakingData = Gson().fromJson("{\"messages\":[{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"hi\",\"time\":\"11:30 AM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"hi, how are you\",\"time\":\"11:31 AM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"are you hungry\",\"time\":\"11:32 AM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"I am hungry now\",\"time\":\"11:32 AM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"could we go to eat?\",\"time\":\"11:32 AM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"sure\",\"time\":\"11:33 AM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"what do you want to eat?\",\"time\":\"11:34 AM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"could you go out with me after we eat\",\"time\":\"11:34 AM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"I want to buy some new dress for my interview\",\"time\":\"11:35 AM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"Sure\",\"time\":\"11:35 AM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"But I'm really strving now\",\"time\":\"11:35 AM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"could we eat something right now?\",\"time\":\"11:36 AM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"Ok, let's go\",\"time\":\"11:36 AM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"Do you know what we can eat?\",\"time\":\"11:40 AM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"Maybe we can eat some BBQ\",\"time\":\"11:40 AM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"Sure, I want eat that\",\"time\":\"11:40 AM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"How about my dress\",\"time\":\"12:10 PM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"Do you like it?\",\"time\":\"12:10 PM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"Um, actually I like black one\",\"time\":\"12:10 PM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"really? but I like this one\",\"time\":\"12:10 PM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"it's make me looks more thin\",\"time\":\"12:11 PM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"Well, it's up to you\",\"time\":\"12:12 PM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"ok I want buy this one\",\"time\":\"12:13 PM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"do you know how much money\",\"time\":\"12:13 PM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"how much?\",\"time\":\"12:14 PM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"it's about 300\$\",\"time\":\"12:14 PM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"wow, so expensive\",\"time\":\"12:14 PM\"},{\"id\":\"1\",\"name\":\"Tom\",\"message\":\"I think you better go to others store\",\"time\":\"12:14 PM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"yeah, that's good idea\",\"time\":\"12:14 PM\"},{\"id\":\"0\",\"name\":\"Cindy\",\"message\":\"let's go\",\"time\":\"12:15 PM\"}]}", Messages::class.java)
    private var job: Job? = null

    var messagesResult: MutableLiveData<MessageContent> = MutableLiveData()

    fun getMessage() {
        job = GlobalScope.launch(Dispatchers.IO) {
            for (i in fakingData.messages!!) {
                messagesResult.postValue(i)
                delay(1500)
            }
        }
    }

    override fun destroy() {
        job?.cancel()
    }
}