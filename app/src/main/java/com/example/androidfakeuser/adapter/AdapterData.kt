package com.example.androiduserexcercise.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.androidfakeuser.R
import com.example.androidfakeuser.databinding.DataAvatarBinding
import com.example.androiduserexcercise.model.DataModel
import com.example.androiduserexcercise.model.ResponseData

class AdapterData (private val context: Context) : RecyclerView.Adapter<AdapterData.ViewHolder>(){

    private var datas = listOf<DataModel>()

    fun setData(data: List<DataModel>){
        datas =data
        notifyDataSetChanged()
    }

    inner class ViewHolder (private val binding: DataAvatarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun binData(letak: DataModel) {
            binding.tvFirstname.text = letak.first_Name
            binding.tvLastname.text = letak.last_Name
            binding.tvEmail.text = letak.email
            binding.tvId.text = letak.id.toString()
            Glide.with(binding.root).load(letak.avatar).apply(RequestOptions().placeholder(R.drawable.ic_baseline_access_loading)).into(binding.ivAvatar)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                DataAvatarBinding.inflate(
                    LayoutInflater.from(context),
                    parent,
                    false
                )
            )
        }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(datas [position])    }

    override fun getItemCount(): Int = datas.size

}


