package com.example.homework10.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework10.data.DogCard
import com.example.homework10.databinding.DogItemBinding

typealias DogCardClick = (item: DogCard) -> Unit

class DogCardsAdapter : RecyclerView.Adapter<DogCardsAdapter.ItemViewHolder>() {

    var cardList: List<DogCard> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    lateinit var dogCardClick : DogCardClick

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            DogItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = cardList.size


    inner class ItemViewHolder(private val binding: DogItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        lateinit var curData : DogCard

            fun bind(){
                binding.root.setOnClickListener(this)
                curData = cardList[adapterPosition]
                binding.titleTxtView.text = curData.title
                binding.dogImgView.setImageResource(curData.img)
                binding.descriptionTxtView.text = curData.description
            }

        override fun onClick(p0: View?) {
            dogCardClick.invoke(cardList[adapterPosition])
        }

    }

}