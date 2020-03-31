package com.jkopay.homework.repository

import android.app.Application
import com.google.gson.Gson
import com.jkopay.homework.repository.provider.preferences.SharedPreferencesProvider
import com.jkopay.homework.repository.remote.RemoteAPI

class Repository(
        private var application: Application,
        private val sharedPreferencesProvider: SharedPreferencesProvider
) {

    val TAG = Repository::class.simpleName

    val mGson: Gson = Gson()

    init {
        RemoteAPI.init(application)
    }

    /*
        Remote API
     */


    /*
        Local
     */
}