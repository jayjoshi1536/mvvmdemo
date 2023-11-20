package com.example.mvvm.activity

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp

private lateinit var INSTANCE: Application

@HiltAndroidApp class MainApp : Application() {

    private var mContext: Context? = null

    fun getContext(): Context? {
        return mContext
    }

    fun setContext(mContext: Context?) {
        this.mContext = mContext
    }

    override fun onCreate() {
        super.onCreate()
        mainApp = this
        INSTANCE = this
        isAidl = true
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    companion object {
        var mainApp: MainApp? = null
        var isAidl = false
    }
}

object AppContext : ContextWrapper(INSTANCE)
