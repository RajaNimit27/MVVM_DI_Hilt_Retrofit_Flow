package com.app.mvvmhiltretrofitflow.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.mvvmhiltretrofitflow.data.Product
import com.app.mvvmhiltretrofitflow.databinding.ListItemBinding


class ProductListAdapter() : RecyclerView.Adapter<ProductListAdapter.DataViewHolder>() {

    private lateinit var binding: ListItemBinding
    var productList = arrayListOf<Product>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val filterModel = productList[position]
        holder.bind(filterModel)
    }

    override fun getItemCount(): Int = productList.size

    inner class DataViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            try {
                binding.product = product
                binding.executePendingBindings()
            } catch (e: Exception) {
                e.stackTrace
            }
        }
    }

    fun setProducts(data: List<Product>) {
        try {
            productList.clear()
            if (data.isNotEmpty()) {
                productList.addAll(data)
            }
            notifyDataSetChanged()
        } catch (e: Exception) {
            e.stackTrace
        }
    }
}