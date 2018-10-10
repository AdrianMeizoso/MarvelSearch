package com.adrian.marvelsearch.main.domain

import android.view.ViewGroup
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil

class HeroesAdapter : PagedListAdapter<MarvelHero, MarvelHeroViewHolder>(marvelHeroDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelHeroViewHolder {
        return MarvelHeroViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MarvelHeroViewHolder, position: Int) {
        val hero = getItem(position)
        if (hero != null) {
            holder.bind(hero)
        } else {
            holder.clear()
        }
    }

    companion object {
        val marvelHeroDiffCallback = object : DiffUtil.ItemCallback<MarvelHero>() {
            override fun areItemsTheSame(oldItem: MarvelHero, newItem: MarvelHero): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MarvelHero, newItem: MarvelHero): Boolean {
                return oldItem == newItem
            }
        }
    }
}