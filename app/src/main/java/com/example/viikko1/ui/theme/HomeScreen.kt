package com.example.viikko1.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viikko1.domain.Task
import com.example.viikko1.viewmodel.TaskViewModel


@Composable
fun HomeScreen(
    taskViewModel: TaskViewModel = viewModel()
) {
    val tasks = taskViewModel.tasks
    var newTaskTitle by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Tehtävälista",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Button(
                modifier = Modifier.weight(1f),
                onClick = { taskViewModel.filterByDone(true) }
            ) {
                Text("Vain valmiit")
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = { taskViewModel.sortByDueDate() }
            ) {
                Text("Järjestä")
            }

            Button(
                modifier = Modifier.weight(1f),
                onClick = { taskViewModel.resetTasks() }
            ) {
                Text("Palauta")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            TextField(
                modifier = Modifier.weight(1f),
                value = newTaskTitle,
                onValueChange = { newTaskTitle = it },
                label = { Text("Uusi tehtävä") }
            )

            Button(onClick = {
                if (newTaskTitle.isNotBlank()) {
                    taskViewModel.addTask(
                        Task(
                            id = (tasks.maxOfOrNull { it.id } ?: 0) + 1,
                            title = newTaskTitle,
                            description = "Lisätty käyttäjältä",
                            dueDate = "2024-30-05"
                        )
                    )
                    newTaskTitle = ""
                }
            }) {
                Text("Lisää")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(taskViewModel.tasks) { task ->
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = task.done,
                            onCheckedChange = { taskViewModel.toggleDone(task.id) }
                        )
                        Text(
                            text = task.title,
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Text(task.description)
                    Text("Määräpäivä: ${task.dueDate}")

                    Spacer(modifier = Modifier.height(6.dp))

                    Button(onClick = { taskViewModel.removeTask(task.id) }) {
                        Text("Poista")
                    }

                    Divider(modifier = Modifier.padding(top = 8.dp))
                }
            }
        } }}
