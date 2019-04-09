package bw.com.kotlin2.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import bw.com.kotlin2.R
import bw.com.kotlin2.entity.LoginBean
import bw.com.kotlin2.login.LoginContext
import bw.com.kotlin2.login.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_register.*
import bw.com.kotlin2.R.id.pass_zc
import bw.com.kotlin2.utils.EncryptUtil



class RegisterActivity : AppCompatActivity(),LoginContext.View,View.OnClickListener {
    lateinit var loginPresenter: LoginPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        loginPresenter = LoginPresenter()
        register.setOnClickListener(this)


    }

    /**
     * 点击事件
     */
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.register ->initReg()
        }

    }
    fun initReg(){
        val passt:String = pass_zc.text.toString()
        val sext:String = sex.text.toString()
        val birtht:String = birth.text.toString()
        val phone:String = phone_zc.text.toString()
        val emailt:String = email.text.toString()
        val namet:String = name_zc.text.toString()
        val encrypt = EncryptUtil.encrypt(passt)
        var map = HashMap<String,String>()
        map.put("nickName",namet)
        map.put("phone",phone)
        map.put("pwd",encrypt)
        map.put("pwd2",encrypt)
        map.put("sex",sext)
        map.put("birthday",birtht)
        map.put("email",emailt)
        loginPresenter.attach(this)
        loginPresenter.getRegsiter(map)
    }
    override fun onSuccess(loginBean: LoginBean) {

    }

    override fun onFile(msg: String) {

    }

    override fun onRegSuccess(loginBean: LoginBean) {
//        Toast.makeText(this,loginBean.message,Toast.LENGTH_SHORT).show()

    }

    override fun onRegFile(msg: String) {

    }


}
