package me.Secondgroup.hnuplus


import android.app.Fragment
import android.content.Intent
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_more.*


/**
 * Created by Secondgroup on 2020/11/9.
 */


class MoreFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_more, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        ll_to_note.setOnClickListener {
            val intent = Intent(activity,NoteActivity::class.java)
            startActivity(intent)
        }


        }

    }






