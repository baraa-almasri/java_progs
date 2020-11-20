package com.baraamasri.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.task_card.view.*
import kotlin.collections.ArrayList

class TaskAdapter( var tasksList: ArrayList<Task>,
                    private var appContext: Context): BaseAdapter()
{

    override fun getCount(): Int {
        return this.tasksList.size
    }

    override fun getItem(position: Int): Any {
        return this.tasksList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val task = this.tasksList[position]
        val view = LayoutInflater.from(this.appContext).inflate(R.layout.task_card, null)
        view.name.text = task.name
        view.des.text = task.des
        view.dueDate.text = task.dueDate.toString()

        return view
    }

}