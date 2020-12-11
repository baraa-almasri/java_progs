package com.baraamasri.todo

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_task_viewer.*

class TaskViewer : AppCompatActivity() {
    private var taskID: Int = 0
    private lateinit var tasksDB: TasksDBModifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_viewer)

        this.tasksDB = TasksDBModifier(this)

        val data = intent.extras
        taskName.text = data?.getString("name")
        description.text = data?.getString("description")
        creationDate.text = data?.getString("creationDate")
        this.taskID = data?.getInt("taskID")!!

    }

    fun goBack(view: View) {
        finish()
    }

    fun deleteTask(view: View) {
        showDeleteDialog()
    }

    private fun showDeleteDialog() {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("Are you sure?").setCancelable(false)
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, id ->
                deleteFromDB()
                finish()
            }).setNegativeButton("NO", DialogInterface.OnClickListener { dialog, id ->
                dialog.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("Really?!")
        alert.show()
    }

    private fun deleteFromDB() {
        this.tasksDB.removeTaskByID(this.taskID)
    }
}