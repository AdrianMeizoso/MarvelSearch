package com.adrian.marvelsearch.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.adrian.marvelsearch.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this, mainViewModelFactory)
                .get(MainViewModel::class.java)

        helloText.setTextColor(getColor(R.color.colorPrimary))

        mainViewModel.getTextData().observe(this, Observer(::setTextToView))
    }

    private fun setTextToView(text: String?) {
        helloText.text = text
    }
}