package com.baraamasri.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.baraamasri.todo.TasksBlyat.tasks
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // var tasks = ArrayList<Task>()
    private var adapter: TaskAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = TaskAdapter(tasks, applicationContext)
        vlo.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        adapter!!.notifyDataSetChanged()
    }


    fun addTask(view: View) {

        val addTaskActivity = Intent(applicationContext, AddTask::class.java)
        addTaskActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(addTaskActivity)

    }

}