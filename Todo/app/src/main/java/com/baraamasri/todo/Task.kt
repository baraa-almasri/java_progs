package com.baraamasri.todo

class Task(var id: Int, var name: String, var des: String, var creationDate: String, var isDone: Boolean) {

    constructor(otherTask: Task):
            this(otherTask.id, otherTask.name, otherTask.des, otherTask.creationDate, otherTask.isDone) {}
}