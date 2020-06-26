package com.example.databindingsample.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingsample.R
import com.example.databindingsample.util.UserModel

class UserAdapter : RecyclerView.Adapter<UserAdapter.MyViewHolder>(), BindableAdapter<MutableList<UserModel>> {
    private var users = mutableListOf<UserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_user, parent, false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class MyViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(obj: Any?) {
            binding.setVariable(2, obj)
            binding.executePendingBindings()
        }
    }

    override fun setData(data: MutableList<UserModel>) {
        users.addAll(data)
    }
}