package me.Secondgroup.hnuplus.Bmob

import cn.bmob.v3.BmobObject
class Order : BmobObject() {

    var goodId: String? = null
    var buyerId: String? = null
    var sellerId: String? = null
    var address: String? = null
    var price: String? = null
    var imageUrl: String? = null
    var goodName: String? = null

}