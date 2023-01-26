package com.example.rickandmorty.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemCharacterBinding
import com.example.rickandmorty.extenssion.loadImage
import com.example.rickandmorty.model.Characters
import com.example.rickandmorty.model.ResultsItem


@Suppress("ImplicitThis")
class CharacterAdapter(private val characters: Characters, private var onClick:(Int)->Unit):RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCharacterBinding):RecyclerView.ViewHolder(binding.root){
        @SuppressLint("CheckResult")
        fun onBind(resultsItem: ResultsItem) {
            binding.characterName.text = resultsItem.name
            binding.characterImage.loadImage(resultsItem.image)
            binding.click.setOnClickListener {
                onClick(resultsItem.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
     return characters.results!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(characters.results!![position])
    }
}