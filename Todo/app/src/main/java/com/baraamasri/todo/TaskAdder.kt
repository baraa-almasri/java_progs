package com.baraamasri.todo

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_task.*
import java.text.SimpleDateFormat
import java.util.*

class TaskAdder : AppCompatActivity() {
    private lateinit var dbHelper: DBHelper
    private lateinit var db: SQLiteDatabase
    private lateinit var tasksDB: TasksDBModifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        this.dbHelper = DBHelper(this)
        this.tasksDB = TasksDBModifier(this)
    }

    fun actualAddTask(view: View) {
        val timeFormatter = SimpleDateFormat("HH:mm")
        val currentTime = Date()
        this.tasksDB.addTask(
                Task(
                        this.tasksDB.getLastTaskID(), name.text.toString(), des.text.toString(),
                        timeFormatter.format(currentTime), false
                )
        )
        /*
        // get id from its table
        this.db = this.dbHelper.readableDatabase
        val curr = this.db.rawQuery("SELECT * FROM `last_id`", null)
        curr.moveToLast()

        var taskID = try {
            curr.getInt(curr.getColumnIndex("id"))
        } catch (oob: android.database.CursorIndexOutOfBoundsException) {
            0
        }

        curr.close()

        // add task DB
        this.db = this.dbHelper.writableDatabase
        this.db.execSQL(
            "INSERT INTO `tasks` VALUES (?, ?, ?, CURRENT_TIME, 0)",
            arrayOf(taskID++.toString(), name.text.toString(), des.text.toString())
        )

        this.db.execSQL("INSERT INTO `last_id` VALUES (?)", arrayOf(taskID))
*/
        finish()
    }
}