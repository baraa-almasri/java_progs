package com.baraamasri.todo

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: TaskAdapter
    private lateinit var db: SQLiteDatabase
    private lateinit var dbHelper: DBHelper
    private lateinit var tasks: ArrayList<Task>
    private lateinit var tasksDB: TasksDBModifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tasks = ArrayList()
        this.tasksDB = TasksDBModifier(this)
        this.dbHelper = DBHelper(this)
        this.loadTasksFromDB()

        adapter = TaskAdapter(tasks, applicationContext)
        vlo.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        this.loadTasksFromDB()
        adapter.notifyDataSetChanged()
    }

    fun addTask(view: View) {

        val addTaskActivity = Intent(applicationContext, TaskAdder::class.java)
        addTaskActivity.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(addTaskActivity)

    }

    private fun loadTasksFromDB() {
        //this.tasks.clear()
        this.tasks = this.tasksDB.getTasks()
    }

}