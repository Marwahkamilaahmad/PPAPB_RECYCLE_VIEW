package com.example.tugasrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasrecyclerview.databinding.ItemFruitBinding

typealias OnClickFruit = (Fruit) -> Unit

class FruitAdapter(private val listFruit : List<Fruit>, private val onClickFruit: OnClickFruit): RecyclerView.Adapter<FruitAdapter.ItemFruitViewHolder>(){

    inner class ItemFruitViewHolder( private val binding : ItemFruitBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(data : Fruit){
            with(binding){
                hargaTxt.text = data.harga
                namaTxt.text = data.name
                lokasiTxt.text = data.lokasi
                imgIcon.setImageResource(data.gambarId)

                itemView.setOnClickListener{
                    onClickFruit(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFruitViewHolder {

        val binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.context), parent,
            false)
        return ItemFruitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {

        holder.bind(listFruit[position])
    }


    override fun getItemCount(): Int {
        return listFruit.size
    }


}