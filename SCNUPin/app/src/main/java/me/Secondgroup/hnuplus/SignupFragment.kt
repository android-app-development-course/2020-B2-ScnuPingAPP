package me.Secondgroup.hnuplus

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import cn.bmob.v3.BmobUser
import cn.bmob.v3.exception.BmobException
import cn.bmob.v3.listener.SaveListener
import com.taishi.flipprogressdialog.FlipProgressDialog
import kotlinx.android.synthetic.main.signup_layout.*
import me.Secondgroup.hnuplus.Bmob.MyUser
import me.Secondgroup.hnuplus.Utils.Utility
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.toast

/**
 * Created by Secondgroup on 2020/12/10.
 */

class SignupFragment : Fragment() {

    companion object {
        private val TAG ="SignupFragment"
    }

    private var flipProgressDialog:FlipProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.signup_layout,
                container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flipProgressDialog=Utility.myDialog()

        btn_signup_2!!.setOnClickListener {
            val username = et_username_2!!.text.toString()
            val password = et_password_2!!.text.toString()
            val passwordConfirm = et_password_confirm!!.text.toString()
            val email = et_email!!.text.toString()

            if (username == "" || password == "" || email == "" || passwordConfirm == "") {
                Toast.makeText(activity, "不能为空", Toast.LENGTH_SHORT).show()
            } else if (password != passwordConfirm) {
                Toast.makeText(activity, getString(R.string.confirm_pwd_not_pwd), Toast.LENGTH_SHORT).show()
            } else {
                flipProgressDialog!!.show(fragmentManager,"")

                val bu = MyUser()
                bu.username = username
                bu.setPassword(password)
                bu.email = email
                bu.userAvatar= "http://bmob-cdn-16924.b0.upaiyun.com/2020/12/19/f25d585d60ea4365be5e79832af5837c.jpg"
                bu.signUp(object : SaveListener<MyUser?>() {
                    override fun done(s: MyUser?, e: BmobException?) {
                        if (e == null) {
                            Toast.makeText(activity, getString(R.string.signup_success), Toast.LENGTH_SHORT).show()
                            bu.login(object : SaveListener<BmobUser?>() {

                                override fun done(bmobUser: BmobUser?, e: BmobException?) {
                                    if (e == null) {
                                        Toast.makeText(activity, R.string.signin_success, Toast.LENGTH_SHORT).show()
                                        flipProgressDialog!!.dismiss()
                                        val login = "login"
                                        EventBus.getDefault().post(login)
                                        activity.finish()
                                    } else {
                                        toast("登录失败，错误代码："+e.toString())
                                        flipProgressDialog!!.dismiss()
                                    }
                                }
                            })
                        } else {
                            toast("注册失败，请检查你输入的内容,错误代码："+e.toString())
                            flipProgressDialog!!.dismiss()
                        }
                    }
                })
            }
        }
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()

    }

}
