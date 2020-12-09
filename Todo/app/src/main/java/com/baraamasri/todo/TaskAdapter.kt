package com.baraamasri.todo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_add_task.view.*
import kotlinx.android.synthetic.main.activity_task_viewer.view.*
import kotlinx.android.synthetic.main.task_card.view.*
import kotlinx.android.synthetic.main.task_card.view.name
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
        view.creation_date.text = task.creationDate.substring(0, 5)

        view.setOnClickListener{
            openTask(this.tasksList[position])
        }

        return view
    }


    private fun openTask(task: Task) {
        val viewTaskActivity = Intent(this.appContext, TaskViewer::class.java)
        viewTaskActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        viewTaskActivity.putExtra("name", task.name)
        viewTaskActivity.putExtra("description", task.des)
        viewTaskActivity.putExtra("creationDate", task.creationDate)
        viewTaskActivity.putExtra("taskID", task.id)

        this.appContext.startActivity(viewTaskActivity)

    }

}