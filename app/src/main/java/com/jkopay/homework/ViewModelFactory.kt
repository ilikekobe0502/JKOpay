package com.jkopay.homework

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.jkopay.homework.pages.chat.ChatViewModel
import com.jkopay.homework.repository.Repository
import com.jkopay.homework.repository.provider.preferences.SharedPreferencesProvider
import com.jkopay.homework.repository.provider.resource.ResourceProvider


class ViewModelFactory(private val application: Application,
                       private val repository: Repository,
                       private val preferences: SharedPreferencesProvider,
                       private val resource: ResourceProvider
) : ViewModelProvider.NewInstanceFactory() {

    //ViewModel需要的model再打進去

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return with(modelClass) {
            when {
                isAssignableFrom(ChatViewModel::class.java) -> ChatViewModel(application)
                else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            } as T
        }
    }
}