package com.baraamasri.todo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.baraamasri.todo.TasksBlyat.tasks
import kotlinx.android.synthetic.main.activity_add_task.*
import java.util.*

class AddTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

    }

    fun actualAddTask(view: View) {
        tasks.add(Task(name.text.toString(), des.text.toString(), Date()))
        finish()

    }
}