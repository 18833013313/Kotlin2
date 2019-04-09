package bw.com.kotlin2.api

class Api {
    companion object {
        val BASE_URL="http://172.17.8.100"
        val regApi="/movieApi/user/v1/registerUser"
        val loginApi="/movieApi/user/v1/login"
        //热门电影
        val HotMovieApi="/movieApi/movie/v1/findHotMovieList"
    }
}