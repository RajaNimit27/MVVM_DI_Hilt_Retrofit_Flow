package com.app.mvvmhiltretrofitflow.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.mvvmhiltretrofitflow.data.Post
import com.app.mvvmhiltretrofitflow.databinding.PostListItemBinding


class PostListAdapter() : RecyclerView.Adapter<PostListAdapter.DataViewHolder>() {

    private lateinit var binding: PostListItemBinding
    var postList = arrayListOf<Post>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        binding = PostListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val dataModel = postList[position]
        holder.bind(dataModel)
    }

    override fun getItemCount(): Int = postList.size

    inner class DataViewHolder(private val binding: PostListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post) {
            try {
                binding.post = post
                binding.executePendingBindings()
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }

    fun setPosts(data: List<Post>) {
        try {
            postList.clear()
            if (data.isNotEmpty()) {
                postList.addAll(data)
            }
            notifyDataSetChanged()
        } catch (e: Exception) {
            e.stackTrace
        }
    }
}