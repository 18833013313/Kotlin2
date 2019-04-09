package bw.com.kotlin2.list

import android.content.Context
import bw.com.kotlin2.entity.HotMovieBean

import bw.com.kotlin2.mvp.BasePresenter
import bw.com.kotlin2.mvp.BaseView
import java.util.*

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

class ListContract {
    interface View : BaseView{
        fun onSuccess(objects: HotMovieBean)
        fun onFile(msg: Throwable)
    }

    internal interface Presenter : BasePresenter<View>{
        fun getHotMovie(map: HashMap<String,String>)
    }
}
