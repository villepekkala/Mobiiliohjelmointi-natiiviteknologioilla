package com.example.viikko1.domain

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val dueDate: String, // Esim. "2024-05-10"
    val done: Boolean = false
)


val mockTasks = listOf(
    Task(1, "Kauppa", "Osta huomisen ruuat", "2024-15-05"),
    Task(2, "Koulu", "Tee kotitehtävät", "2024-10-05"),
    Task(3, "Treeni", "Käy salilla", "2024-12-05"),
    Task(4, "Valmennukset", "Suunnitele treenit", "2024-11-05"),
    Task(5, "Siivous", "Imuroi", "2024-20-05")
)

