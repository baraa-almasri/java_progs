package com.baraamasri.todo

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_task.*

class TaskAdder : AppCompatActivity() {
    private lateinit var dbHelper: DBHelper
    private lateinit var db: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        this.dbHelper = DBHelper(this)

    }

    fun actualAddTask(view: View) {
        // get id from its table
        this.db = this.dbHelper.readableDatabase
        val curr = this.db.rawQuery("SELECT * FROM `last_id`", null)
        curr.moveToLast()
        var taskID = curr.getInt(curr.getColumnIndex("id"))
        curr.close()

        // add task DB
        this.db = this.dbHelper.writableDatabase
        this.db.execSQL("INSERT INTO `tasks` VALUES (?, ?, ?, CURRENT_TIME)",
            arrayOf(taskID++.toString(), name.text.toString(), des.text.toString()))

        this.db.execSQL("INSERT INTO `last_id` VALUES (?)", arrayOf(taskID))

        finish()
    }
}