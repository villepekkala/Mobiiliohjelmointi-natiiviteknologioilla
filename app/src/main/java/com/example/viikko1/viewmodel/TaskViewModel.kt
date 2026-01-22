package com.example.viikko1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.viikko1.domain.Task
import com.example.viikko1.domain.mockTasks

class TaskViewModel : ViewModel() {
    var tasks by mutableStateOf(listOf<Task>())
        private set


    private var originalTasks: List<Task> = emptyList()

    init {
        tasks = mockTasks
        originalTasks = mockTasks
    }


    fun addTask(task: Task) {
        tasks = tasks + task
        originalTasks = originalTasks + task
    }


    fun toggleDone(id: Int) {
        tasks = tasks.map { if (it.id == id) it.copy(done = !it.done) else it }
        originalTasks = originalTasks.map { if (it.id == id) it.copy(done = !it.done) else it }

    }


    fun removeTask(id: Int) {
        tasks = tasks.filterNot { it.id == id }
        originalTasks = originalTasks.filterNot { it.id == id }
    }


    fun filterByDone(done: Boolean) {
        tasks = originalTasks.filter { it.done == done }
    }


    fun sortByDueDate() {
        tasks = tasks.sortedBy { it.dueDate }
    }


    fun resetTasks() {
        tasks = originalTasks
    }
}
