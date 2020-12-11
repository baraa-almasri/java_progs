package com.baraamasri.todo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.task_card.view.*

class TaskAdapter(
    private var tasksList: ArrayList<Task>,
    private var appContext: Context
) : BaseAdapter() {

    private lateinit var tasksDB: TasksDBModifier

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

        view.hlo1.setBackgroundResource(
            when (task.isDone) {
                false -> R.drawable.task_ticket_shape
                true -> R.drawable.done_task_ticket_shape
            })

        view.setOnClickListener {
            openTask(this.tasksList[position])
        }

        this.tasksDB = TasksDBModifier(this.appContext)

        view.setOnLongClickListener {
            task.isDone = !task.isDone
            this.tasksDB.modifyTask(task.id, task)

            view.hlo1.setBackgroundResource(
                when (task.isDone) {
                    false -> R.drawable.task_ticket_shape
                    true -> R.drawable.done_task_ticket_shape
                })

            return@setOnLongClickListener true
        }

        return view
    }


    private fun openTask(task: Task) {
        val viewTaskActivity = Intent(this.appContext, TaskViewer::class.java)
        viewTaskActivity.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        viewTaskActivity.putExtra("name", task.name)
        viewTaskActivity.putExtra("description", task.des)
        viewTaskActivity.putExtra("creationDate", task.creationDate)
        viewTaskActivity.putExtra("taskID", task.id)

        this.appContext.startActivity(viewTaskActivity)

    }

}