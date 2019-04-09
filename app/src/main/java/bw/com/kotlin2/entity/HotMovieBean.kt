package bw.com.kotlin2.entity

data class HotMovieBean(
    val message: String,
    val result: List<Result>,
    val status: String
) {

    data class Result(
        val followMovie: String,
        val id: Int,
        val imageUrl: String,
        val name: String,
        val rank: Int,
        val summary: String
    )
}