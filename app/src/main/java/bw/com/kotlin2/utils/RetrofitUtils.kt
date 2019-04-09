package bw.com.kotlin2.utils

import bw.com.kotlin2.BuildConfig
import bw.com.kotlin2.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class RetrofitUtils {

    lateinit var retrofit :Retrofit
    /**
     * 单例模式
     */
    companion object {
        val instant:RetrofitUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){
            RetrofitUtils()

        }
    }
  fun init() {
      val okHttpClient = OkHttpClient
          .Builder()
          .addInterceptor(HttpLoggingInterceptor().setLevel(
              if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
          ))
          .connectTimeout(5,TimeUnit.SECONDS)
          .readTimeout(5,TimeUnit.SECONDS)
          .writeTimeout(5,TimeUnit.SECONDS)
          .build()
        retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
  }
    fun <T> createService(tClass:Class<T>):T{
        return retrofit.create(tClass)
    }
}