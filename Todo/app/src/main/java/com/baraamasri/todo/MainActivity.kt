package com.baraamasri.todo

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: TaskAdapter
    private lateinit var db: SQLiteDatabase
    private lateinit var dbHelper: DBHelper
    private lateinit var tasks: ArrayList<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tasks = ArrayList()
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
        addTaskActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(addTaskActivity)

    }

    private fun loadTasksFromDB() {
        this.db = this.dbHelper.readableDatabase

        val curr = this.db.rawQuery("SELECT * FROM `tasks`", null)
        curr.moveToFirst()

        this.tasks.clear()

        while (!curr.isAfterLast) {
            val id = curr.getInt(curr.getColumnIndex("id"))
            val name = curr.getString(curr.getColumnIndex("name"))
            val description = curr.getString(curr.getColumnIndex("description"))
            val creationDate = curr.getString(curr.getColumnIndex("creation_date"))

            this.tasks.add( Task( id, name, description, creationDate ) )

            curr.moveToNext()
        }

        curr.close()
    }

}