package com.wang.wanandroidwithkotlin.bindingadapter

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Button
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wang.wanandroidwithkotlin.plugin.suffix
import com.wang.wanandroidwithkotlin.vm.Article

/**
 * Created by Koala on 2020/7/11.
 *
 * Description: 自定义 BindingAdapter
 */
@BindingAdapter(value = ["adapter" , "fuck"], requireAll = false)
 fun fuck(recyclerView: RecyclerView, adapter: ListAdapter<Article, RecyclerView.ViewHolder>, data: MutableLiveData<List<Article>>){
    recyclerView.adapter = adapter

    adapter.submitList(data.value)
}

@BindingAdapter(value = ["show"],requireAll = false)
 fun visibleOrGone(view: View, visible: Boolean)
 {
        view.visibility = if (visible) View.VISIBLE else View.GONE
 }
@BindingAdapter(value = ["textSuffix"],requireAll = false)
fun addTextSuffix(button: Button,text:String){
    button.text = text.suffix()
}
@BindingConversion
fun convertStringToDrawable(color: String): Drawable
{
    if (color=="红色")
    {
        return ColorDrawable(Color.parseColor("#FF4081"))
    }
    if (color=="蓝色")
    {
        return ColorDrawable(Color.parseColor("#3F51B5"))
    }
    return ColorDrawable(Color.parseColor("#344567"))
}
@BindingConversion
fun covertStringToColor(color: String):Int{
    if (color=="红色")
    {
        return Color.parseColor("#FF4081")
    }
    if (color=="蓝色")
    {
        return Color.parseColor("#3F51B5")
    }
    return Color.parseColor("#344567")
}