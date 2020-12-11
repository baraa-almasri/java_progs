package com.baraamasri.todo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, "todo.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE `tasks` (id INT UNIQUE, name VARCHAR(300)," +
                " description VARCHAR(9999), creation_date DATE, is_done INT(1))"
        )

        db?.execSQL("CREATE TABLE `last_id` (id INT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}

}
