package com.baraamasri.todo

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_task.*
import kotlinx.android.synthetic.main.activity_task_viewer.*

class TaskViewer : AppCompatActivity() {
    private lateinit var db: SQLiteDatabase
    private lateinit var dbHelper: DBHelper
    private var taskID: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_viewer)

        this.dbHelper = DBHelper(this)

        val data = intent.extras
        taskName.text = data?.getString("name")
        description.text = data?.getString("description")
        creationDate.text = data?.getString("creationDate")
        this.taskID = data?.getInt("taskID")

    }

    fun goBack(view: View) {
        finish()
    }

    fun deleteTask(view: View) {
        this.db = this.dbHelper.writableDatabase
        this.db.execSQL("DELETE FROM `tasks` WHERE `id` = ?", arrayOf(this.taskID))

        finish()
    }
}