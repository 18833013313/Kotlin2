package bw.com.kotlin2.login

import bw.com.kotlin2.entity.LoginBean

interface LoginContext {
    abstract class IPresenter{
        abstract fun getLogin(map: HashMap<String,String>);
        abstract fun getRegsiter(map: HashMap<String,String>);
    }
    interface Model{
        fun getLogin(map: HashMap<String, String>,loginCallBack: LoginCallBack);
        fun getRegister(map: HashMap<String, String>,loginCallBack: LoginCallBack);
    }
    interface View{
        fun onSuccess(loginBean: LoginBean)
        fun onFile(msg: String)
        fun onRegSuccess(loginBean: LoginBean);
        fun onRegFile(msg: String);
    }
}