package me.Secondgroup.hnuplus.Utils

import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by Secondgroup on 2020/12/10.
 */

object HttpUtil {
    fun sendOkHttpRequest(address: String, callback: okhttp3.Callback) {
        val client = OkHttpClient()
        val request = Request.Builder()
                .url(address)
                .build()
        client.newCall(request).enqueue(callback)
    }
}
