package com.akiniyalocts.codelab_room.view

import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.akiniyalocts.codelab_room.R
import com.akiniyalocts.codelab_room.databinding.WordItemBinding
import com.akiniyalocts.codelab_room.model.Word
import java.util.*

/**
 * Created by anthonykiniyalocts on 1/8/18.
 */
class WordAdapter : RecyclerView.Adapter<WordAdapter.WordViewHolder>(){

    private var words : List<Word> = Collections.emptyList()

    fun update(fresh: List<Word>){

        val diff = WordDiff(fresh, words)

        val result = DiffUtil.calculateDiff(diff)

        this.words = fresh

        result.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: WordViewHolder?, position: Int) {
        holder?.bind(words[position])
    }

    override fun getItemCount(): Int = words.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WordViewHolder = WordViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.word_item, parent, false))

    inner class WordViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        private val binding : WordItemBinding = DataBindingUtil.bind(itemView)

        fun bind(word:Word){
            binding.word = word
        }
    }
}