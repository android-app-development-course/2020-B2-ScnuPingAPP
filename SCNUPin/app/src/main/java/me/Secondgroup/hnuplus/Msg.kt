package me.Secondgroup.hnuplus

/**
 * Created by Administrator on 2020/12.
 */

class Msg(val content: String, val type: Int) {
    companion object {
        val TYPE_RECEIVED = 0
        val TYPE_SENT = 1
    }
}
