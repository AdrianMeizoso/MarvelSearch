package com.adrian.marvelsearch.main.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.adrian.marvelsearch.R
import com.adrian.marvelsearch.main.MainViewModel
import com.adrian.marvelsearch.main.MainViewModelFactory
import com.adrian.marvelsearch.main.domain.MarvelHero
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

class DetailFragment : DaggerFragment() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = activity?.run {
            ViewModelProviders.of(this, mainViewModelFactory)
                    .get(MainViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val heroId = arguments!!.getInt("hero")
        val hero = mainViewModel.getHeroById(heroId)
        if (hero != null) {
            hero_name.text = hero.name
            hero_description.text = hero.description
        }
    }
}
