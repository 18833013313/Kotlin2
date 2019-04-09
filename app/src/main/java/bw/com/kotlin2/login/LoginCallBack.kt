package bw.com.kotlin2.login

import bw.com.kotlin2.entity.LoginBean

interface LoginCallBack {
    fun onSuccess(objects: LoginBean)
    fun onFile(msg: String);
}