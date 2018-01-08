package com.akiniyalocts.codelab_room.view

import android.support.v7.util.DiffUtil
import com.akiniyalocts.codelab_room.model.Word

/**
 * Created by anthonykiniyalocts on 1/8/18.
 */
class WordDiff(val fresh : List<Word>, val old : List<Word>) : DiffUtil.Callback(){
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].word == fresh[newItemPosition].word
    }

    override fun getOldListSize() = old.size

    override fun getNewListSize() = fresh.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].word == fresh[newItemPosition].word
    }
}