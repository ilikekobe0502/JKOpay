package com.jkopay.homework.repository.provider.preferences

import android.content.SharedPreferences

interface AppSharedPreferences {
    fun sharedPreferences(): SharedPreferences
}