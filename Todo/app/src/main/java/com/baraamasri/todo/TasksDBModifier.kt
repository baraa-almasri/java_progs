package com.baraamasri.todo

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class TasksDBModifier(context: Context) {
    private lateinit var db: SQLiteDatabase
    private val dbHelper: DBHelper

    init {
        this.dbHelper = DBHelper(context)
    }

    fun getLastTaskID(): Int {
        val curr = this.openReadableDBandGetCursor()
        curr.moveToLast()

        // not returning directly, in order to close the cursor
        // also also, return 0 when there're no entries created
        val taskID = try {
            curr.getInt(curr.getColumnIndex("last_id.id"))
        } catch (oob: android.database.CursorIndexOutOfBoundsException) {
            0
        }

        curr.close()

        return taskID
    }

    fun addTask(task: Task) {

        // CHECK BLYAT
        // add task DB
        this.openWritableDB()
        val nextID = this.getLastTaskID() + 1
        this.db.execSQL(
            "INSERT INTO `tasks` VALUES (?, ?, ?, CURRENT_TIME, ?)",
            arrayOf(nextID, task.name, task.des, if (task.isDone) 1 else 0)
        )

        // add new id
        this.db.execSQL(
            "INSERT INTO `last_id` VALUES (?)", arrayOf(nextID)
        )
    }

    fun modifyTask(taskID: Int, newTask: Task) {
        removeTaskByID(taskID)
        addTask(newTask)
    }

    fun removeTaskByID(taskID: Int) {
        this.openWritableDB()
        this.db.execSQL("DELETE FROM `tasks` WHERE `id` = ?", arrayOf(taskID))
        this.db.execSQL(
            "DELETE FROM `last_id` WHERE `id` = ?", arrayOf(taskID)
        )
    }

    fun getTasks(): ArrayList<Task> {

        val curr = this.openReadableDBandGetCursor()
        curr.moveToFirst()
        val tasks = ArrayList<Task>()

        while (!curr.isAfterLast) {
            val id = curr.getInt(curr.getColumnIndex("id"))
            val name = curr.getString(curr.getColumnIndex("name"))
            val description = curr.getString(curr.getColumnIndex("description"))
            val creationDate = curr.getString(curr.getColumnIndex("creation_date"))
            val isDone = curr.getInt(curr.getColumnIndex("is_done"))

            tasks.add(Task(id, name, description, creationDate, isDone == 1))

            curr.moveToNext()
        }
        curr.close()

        return tasks
    }

    fun getTaskByID(ID: Int): Task? {

        val tasks = this.getTasks()

        for (task in tasks) {
            if (task.id == ID) {
                return task
            }
        }

        return null
    }

    private fun openReadableDBandGetCursor(): Cursor {
        this.db = this.dbHelper.readableDatabase
        return this.db.rawQuery("SELECT * FROM `tasks`", null)
    }

    private fun openWritableDB() {
        this.db = this.dbHelper.writableDatabase
    }

}