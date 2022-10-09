package com.example.testapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.ActivityMainBinding
import com.example.testapp.databinding.ItemTodoBinding

class TodoAdapter(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(from, parent, false)
        return TodoViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bindTaskItem(todos[position])
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}