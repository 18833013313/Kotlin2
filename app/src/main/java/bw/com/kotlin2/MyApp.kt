package bw.com.kotlin2

import android.app.Application
import bw.com.kotlin2.utils.RetrofitUtils

class MyApp: Application (){
    override fun onCreate() {
        super.onCreate()
        RetrofitUtils.instant.init()
    }
}