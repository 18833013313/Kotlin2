package bw.com.kotlin2.login.model

import bw.com.kotlin2.api.Api
import bw.com.kotlin2.entity.LoginBean
import bw.com.kotlin2.login.LoginCallBack
import bw.com.kotlin2.login.LoginContext
import bw.com.kotlin2.utils.RetrofitUtils
import bw.com.kotlin2.utils.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class LoginModel : LoginContext.Model{


    override fun getLogin(map: HashMap<String, String>, loginCallBack: LoginCallBack) {
         RetrofitUtils.instant.createService(UserService::class.java)
        .getLofin(Api.loginApi, map)
       .subscribeOn(Schedulers.io())
       .observeOn(AndroidSchedulers.mainThread())
       .subscribe(object : DisposableObserver<LoginBean>(){
           override fun onError(e: Throwable) {

           }

           override fun onNext(t: LoginBean) {
         loginCallBack!!.onSuccess(t!!)
           }

           override fun onComplete() {

                  }

       })

    }
    override fun getRegister(map: HashMap<String, String>, loginCallBack: LoginCallBack) {
        RetrofitUtils.instant.createService(UserService::class.java)
            .getRegister(Api.regApi,map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :DisposableObserver<LoginBean>(){
                override fun onComplete() {

                }

                override fun onNext(t: LoginBean) {
                    loginCallBack.onSuccess(t!!)
                }

                override fun onError(e: Throwable) {
                    loginCallBack.onFile("cuo")
                }

            })
    }
}