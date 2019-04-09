package bw.com.kotlin2.login.presenter

import bw.com.kotlin2.entity.LoginBean
import bw.com.kotlin2.login.LoginCallBack
import bw.com.kotlin2.login.LoginContext
import bw.com.kotlin2.login.model.LoginModel


class LoginPresenter : LoginContext.IPresenter() {


    lateinit var loginModel: LoginModel;
    lateinit var iloginView :LoginContext.View
    /**
     * 绑定view
     */
    fun attach(iloginView : LoginContext.View){
        this.iloginView = iloginView
        loginModel = LoginModel()
    }
    override fun getLogin(map: HashMap<String, String>) {
        loginModel.getLogin(map,object : LoginCallBack{
            override fun onFile(msg: String) {
            iloginView ?. onFile(msg)
            }

            override fun onSuccess(objects: LoginBean) {
                iloginView ?. onSuccess(objects)
            }

        })
    }
    override fun getRegsiter(map: HashMap<String, String>) {
            loginModel.getRegister(map,object : LoginCallBack{
                override fun onSuccess(objects: LoginBean) {
                    iloginView ?. onRegSuccess(objects)
                }

                override fun onFile(msg: String) {
                    iloginView ?. onRegFile(msg)
                }

            })
    }
    fun detach(){
        if (iloginView!=null){
            iloginView == null
        }
    }
}