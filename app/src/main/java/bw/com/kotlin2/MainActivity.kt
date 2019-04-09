package bw.com.kotlin2

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import bw.com.kotlin2.View.RegisterActivity

import bw.com.kotlin2.entity.LoginBean
import bw.com.kotlin2.list.List2Activity
import bw.com.kotlin2.login.LoginContext
import bw.com.kotlin2.login.presenter.LoginPresenter

import bw.com.kotlin2.utils.EncryptUtil
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),LoginContext.View ,View.OnClickListener{


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.login ->initData()
            R.id.kszc ->register()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    lateinit var loginpresent : LoginPresenter
    //lateinit var map : HashMap<String,String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        loginpresent=LoginPresenter()
        kszc.setOnClickListener(this)
        login.setOnClickListener(this)
    }
    fun register(){
        var intent = Intent()
        intent.setClass(this,RegisterActivity::class.java)
        // 获取class是使用::反射(那么问题来了,反射是个什么鬼?👻👻👻👻小白的悲哀啊,赶紧研究研究去)
        startActivity(intent)
    }
        fun initData(){
            val wphone:String = phone.text.toString()
            val wPass:String = pass.text.toString()
          //  Toast.makeText(this,wphone , Toast.LENGTH_SHORT).show()
            val encrypt:String = EncryptUtil.encrypt(wPass)
            var map = HashMap<String,String>()
            map.put("phone",wphone)
            map.put("pwd",encrypt)
            loginpresent.attach(this)
            loginpresent.getLogin(map)
        }
    override fun onSuccess(loginBean: LoginBean) {
        if (loginBean.message.equals("登陆成功")){
            var intent = Intent()
            intent.setClass(this,List2Activity::class.java)
            // 获取class是使用::反射(那么问题来了,反射是个什么鬼?👻👻👻👻小白的悲哀啊,赶紧研究研究去)
            startActivity(intent)
        }
    //    Toast.makeText(this,loginBean.message,Toast.LENGTH_SHORT).show();
    }

    override fun onFile(msg: String) {

    }
    override fun onRegFile(msg: String) {

    }

    override fun onRegSuccess(loginBean: LoginBean) {

    }
}
