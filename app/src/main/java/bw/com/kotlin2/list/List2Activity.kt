package bw.com.kotlin2.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import bw.com.kotlin2.R
import bw.com.kotlin2.adapter.HotMovieAdapter
import bw.com.kotlin2.entity.HotMovieBean
import bw.com.kotlin2.mvp.MVPBaseActivity
import kotlinx.android.synthetic.main.activity_list2.*

class List2Activity : MVPBaseActivity<ListContract.View, ListPresenter>(), ListContract.View {

   // lateinit var listPresenter: ListPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list2)
   //     listPresenter = ListPresenter()
   //     listPresenter.attachView(this)

      var map = HashMap<String,String>()
       map.put("page","1")
       map.put("count","10")
       mPresenter!!.getHotMovie(map)
    }
    override fun onSuccess(objects: HotMovieBean) {
            Toast.makeText(this,objects.message,Toast.LENGTH_SHORT).show()
            rvy.layoutManager = LinearLayoutManager(this)
            rvy.adapter = HotMovieAdapter(this,objects.result)
    }

    override fun onFile(msg: Throwable) {

    }
}
