package me.Secondgroup.hnuplus.Gson

import com.google.gson.annotations.SerializedName

/**
 * Created by Secondgroup on 2020/12/10.
 */

class Item {
    var title: String? = null
    var lat: String? = null
    @SerializedName("long")
    var longtitude: String? = null
    var pubDate: String? = null
    var condition: Condition? = null
    @SerializedName("forecast")
    var forecastList: List<Forecast>? = null
}
