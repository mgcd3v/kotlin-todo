package com.example.testapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel: ViewModel() {
    var todos = MutableLiveData<MutableList<Todo>>()

    init {
        todos.value = mutableListOf()
    }

    fun addTodo(todo: Todo)
    {
        val list = todos.value
        list!!.add(todo)
        todos.postValue(list)
    }

    fun deleteDoneTodos()
    {
        todos.value?.removeAll{
                todo -> todo.isChecked
        }

        todos.value = todos.value
    }

    fun getTodoCount(): Int
    {
        return todos.value!!.size
    }
}