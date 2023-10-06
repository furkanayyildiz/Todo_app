package com.example.todoapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapplication.data.model.Task
import com.example.todoapplication.databinding.CardViewBinding
import com.example.todoapplication.ui.fragment.HomeFragmentDirections
import com.example.todoapplication.ui.viewModel.HomeViewModel
import com.example.todoapplication.utils.viewNavigate
import com.google.android.material.snackbar.Snackbar

class TaskAdapter(var mContext: Context, var taskList: List<Task>, var viewModel: HomeViewModel)
    : RecyclerView.Adapter<TaskAdapter.CardViewHolder>() {

        inner class CardViewHolder(var view: CardViewBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardViewBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val task = taskList.get(position)
        val view = holder.view

        view.textViewTaskName.text = task.task_name
        view.textViewTaskDescription.text = task.task_description

        view.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"Do you want to delete ${task.task_name} ", Snackbar.LENGTH_SHORT)
                .setAction("Yes"){
                    delete(task.task_id)
                }.show()
        }
        view.cardViewTask.setOnClickListener {
            val navigateToDetail = HomeFragmentDirections.navigationHomeToDetail(task = task)
            Navigation.viewNavigate(it, navigateToDetail)
        }
    }

    fun delete(task_id:Int){
        viewModel.deleteTask(task_id)
    }
}