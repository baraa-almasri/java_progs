package com.baraamasri.todo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_task.*
import java.text.SimpleDateFormat
import java.util.*

class TaskAdder : AppCompatActivity() {
    private lateinit var tasksDB: TasksDBModifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        this.tasksDB = TasksDBModifier(this)
    }

    fun actualAddTask(view: View) {
        val timeFormatter = SimpleDateFormat("MMM/d/Y  HH:mm")
        val currentTime = Date()
        this.tasksDB.addTask(
            Task(
                this.tasksDB.getLastTaskID(), name.text.toString(), des.text.toString(),
                timeFormatter.format(currentTime), false
            )
        )

        finish()
    }
}