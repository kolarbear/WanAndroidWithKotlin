package com.wang.wanandroidwithkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
=======
>>>>>>> 2b225d626e010c990d2b30a27f7e5caef76aa488
import com.wang.wanandroidwithkotlin.R
import com.wang.wanandroidwithkotlin.databinding.ItemListBinding
import com.wang.wanandroidwithkotlin.vm.Article


/**
 * Created by Koala on 2020/7/11.
 *
 * Description:
 */
class HomeAdapter(private val context: Context)
    : ListAdapter<Article, RecyclerView.ViewHolder>(object :DiffUtil.ItemCallback<Article>(){
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.name == newItem.name
    }
}) {


    override fun submitList(list: List<Article>?) {
        super.submitList(list?:ArrayList())
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = DataBindingUtil.inflate<ItemListBinding>(
            LayoutInflater.from(context),
            R.layout.item_list,
            parent,
            false
        )

        return BindingVH(binding.root)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = DataBindingUtil.getBinding<ItemListBinding>(holder.itemView)
        binding?.let { it.article = getItem(position) }
    }

    class BindingVH(item: View): RecyclerView.ViewHolder(item)



}