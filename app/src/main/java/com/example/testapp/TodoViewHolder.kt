package com.example.testapp

import android.content.Context
import android.graphics.Paint
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.ItemTodoBinding

class TodoViewHolder(
    private val context: Context,
    private val binding: ItemTodoBinding,
) : RecyclerView.ViewHolder(binding.root)
{
    fun bindTaskItem(todo: Todo)
    {
        binding.apply {
            tvTodoTitle.text = todo.title
            cbDone.isChecked = todo.isChecked

            _toggleStrikeThrough(tvTodoTitle, todo.isChecked)

            cbDone.setOnCheckedChangeListener { _, isChecked ->
                _toggleStrikeThrough(tvTodoTitle, isChecked)
                todo.isChecked = !todo.isChecked
            }
        }
    }

    private fun _toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean)
    {
        if(isChecked)
        {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        }
        else
        {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}