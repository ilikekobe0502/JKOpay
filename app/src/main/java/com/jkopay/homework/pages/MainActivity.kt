package com.jkopay.homework.pages

import android.os.Bundle
import com.jkopay.homework.R
import com.jkopay.homework.constants.Page
import com.jkopay.homework.pages.base.OnPageInteractionListener
import com.jkopay.homework.pages.base.PaneViewActivity

class MainActivity : PaneViewActivity(), OnPageInteractionListener.Primary {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        switchPage(R.id.fragment_container, Page.CHAT, Bundle(), true, false)
    }
}

