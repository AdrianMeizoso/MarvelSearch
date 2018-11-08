package com.adrian.marvelsearch.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.adrian.marvelsearch.R
import com.adrian.marvelsearch.main.MainViewModel
import com.adrian.marvelsearch.main.MainViewModelFactory
import com.adrian.marvelsearch.main.domain.HeroesAdapter
import com.adrian.marvelsearch.main.domain.MarvelHero
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : DaggerFragment() {

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
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initHeroesRecycler()
    }

    private fun initHeroesRecycler() {
        val linearLayoutManager = GridLayoutManager(context, 2)
        val heroesAdapter = HeroesAdapter()
        heroes_recycler.layoutManager = linearLayoutManager
        heroes_recycler.adapter = heroesAdapter
        mainViewModel.heroesList.observe(this, Observer<PagedList<MarvelHero>> {
            heroesAdapter.submitList(it)
            it.toList().forEach { hero ->
                mainViewModel.heroesListHash[hero.id] = hero
            }
        })
    }
}