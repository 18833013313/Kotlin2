package bw.com.kotlin2.list

import android.content.Context
import bw.com.kotlin2.api.Api
import bw.com.kotlin2.entity.HotMovieBean

import bw.com.kotlin2.mvp.BasePresenterImpl
import bw.com.kotlin2.utils.RetrofitUtils
import bw.com.kotlin2.utils.UserService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.HashMap

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class ListPresenter : BasePresenterImpl<ListContract.View>(), ListContract.Presenter {
    override fun getHotMovie(map: HashMap<String, String>) {
        RetrofitUtils.instant.createService(UserService::class.java)
            .getHotMovie(Api.HotMovieApi,map)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :DisposableObserver<HotMovieBean>(){
                override fun onComplete() {

                }

                override fun onNext(t: HotMovieBean) {
                    mView!!.onSuccess(t)
                }

                override fun onError(e: Throwable) {
                    mView!!.onFile(e)
                }

            })


    }
}
