package com.example.testapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoViewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _init()

        _setEvents()
    }

    private fun _init()
    {
        binding = ActivityMainBinding.inflate(layoutInflater)
        todoViewModel = ViewModelProvider(this).get(TodoViewModel::class.java)

        setContentView(binding.root)

        _setTodosCount()

        _setRecyclerView()
    }

    private fun _setRecyclerView()
    {
        todoViewModel.todos.observe(this){
            binding.rvTodoItems.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TodoAdapter(it)
            }
        }
    }

    private fun _setEvents()
    {
        binding.btnAddTodo.setOnClickListener {
            _addTodo()
        }

        binding.btnDeleteTodos.setOnClickListener {
            _deleteDoneTodos()
        }
    }

    private fun _setTodosCount()
    {
        binding.tvTodoCount.text = todoViewModel.getTodoCount().toString() + " todo/s"
    }

    private fun _addTodo()
    {
        val todoTitle = binding.etItemTitle.text.toString()
        val todo = Todo(todoTitle)
        todoViewModel.addTodo(todo)

        binding.etItemTitle.text.clear()

        _setTodosCount()
    }

    private fun _deleteDoneTodos()
    {
        todoViewModel.deleteDoneTodos()

        _setTodosCount()
    }
}