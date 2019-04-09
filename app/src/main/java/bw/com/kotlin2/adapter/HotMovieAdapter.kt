package bw.com.kotlin2.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import bw.com.kotlin2.R
import bw.com.kotlin2.entity.HotMovieBean
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_hotmovie.view.*

class HotMovieAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>(), Parcelable {



    lateinit var context: Context
    lateinit var list: List<HotMovieBean.Result>

    constructor(parcel: Parcel) : this() {

    }


    constructor(context: Context, list: List<HotMovieBean.Result>) : this() {
        this.context = context
        this.list = list
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {

        val inflate = View.inflate(context, R.layout.item_hotmovie, null)
        var vh = ViewHolder(inflate)
        return vh
    }
    override fun getItemCount(): Int {
        return  list.size
    }
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, p1: Int) {

        viewHolder.itemView.text1.text = list[p1].name

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView:TextView = itemView.findViewById(R.id.text1)
     //   var image:ImageView = itemView.findViewById(R.id.image)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HotMovieAdapter> {
        override fun createFromParcel(parcel: Parcel): HotMovieAdapter {
            return HotMovieAdapter(parcel)
        }

        override fun newArray(size: Int): Array<HotMovieAdapter?> {
            return arrayOfNulls(size)
        }
    }


}
