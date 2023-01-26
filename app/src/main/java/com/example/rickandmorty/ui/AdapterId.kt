package com.example.rickandmorty.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemIdBinding
import com.example.rickandmorty.extenssion.loadImage
import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.model.ResultsItem


class AdapterId(private val characters: Characters):RecyclerView.Adapter<AdapterId.ViewHolder>() {


    inner class ViewHolder(private val binding: ItemIdBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("CheckResult")
        fun onBind(resultsItem: ResultsItem) {
            binding.gender.text = resultsItem.gender
            binding.specie.text = resultsItem.species
            binding.name.text = resultsItem.name
            binding.image.loadImage(resultsItem.image)
            binding.statys.text = resultsItem.status
            binding.orgin.text = resultsItem.origin.toString()
            binding.type.text = resultsItem.type

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemIdBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return characters.results!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(characters.results!![position])
    }
}
