package com.akiniyalocts.codelab_room.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.inputmethod.EditorInfo
import com.akiniyalocts.codelab_room.R
import com.akiniyalocts.codelab_room.RoomApplication
import com.akiniyalocts.codelab_room.WordViewModel
import com.akiniyalocts.codelab_room.databinding.MainActivityBinding
import com.akiniyalocts.codelab_room.model.Word
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.threeten.bp.Instant

class MainActivity : AppCompatActivity() {

    lateinit var binding : MainActivityBinding

    lateinit var viewmodel : WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = ViewModelProviders.of(this).get(WordViewModel::class.java)

        setSupportActionBar(toolbar)


        binding.wordList.layoutManager = LinearLayoutManager(this)
        val adapter = WordAdapter()

        binding.wordList.adapter = adapter

        binding.input.setOnEditorActionListener { v, actionId, event ->

            if(actionId == EditorInfo.IME_ACTION_SEND){

                val text = v.text.toString()

                if(text.isNotEmpty()){
                    viewmodel.insert(Word(text, Instant.now()))
                }

                v.text = null

                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }


        RoomApplication.db?.wordDao()?.getAllWords()?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { words -> adapter.update(words) }


    }
}
