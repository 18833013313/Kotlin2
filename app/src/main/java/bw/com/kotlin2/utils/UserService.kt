package bw.com.kotlin2.utils


import bw.com.kotlin2.entity.HotMovieBean
import bw.com.kotlin2.entity.LoginBean
import io.reactivex.Observable
import retrofit2.http.*
import java.util.*

interface UserService {
    @POST
    @FormUrlEncoded
    fun getLofin(@Url api:String,@FieldMap map: HashMap<String,String>):Observable<LoginBean>
    @POST
    @FormUrlEncoded
    fun getRegister(@Url api:String,@FieldMap map: HashMap<String,String>):Observable<LoginBean>
    @GET
    fun getHotMovie(@Url api:String,@QueryMap map: HashMap<String, String>):Observable<HotMovieBean>
}