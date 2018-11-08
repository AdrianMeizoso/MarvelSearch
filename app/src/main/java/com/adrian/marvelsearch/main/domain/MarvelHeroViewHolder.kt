package com.adrian.marvelsearch.main.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.adrian.marvelsearch.R
import com.adrian.marvelsearch.databinding.HeroItemBinding

class MarvelHeroViewHolder(private val binding: HeroItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(hero: MarvelHero) {
        binding.hero = hero
        binding.thumbnail = hero.thumbnail
        binding.viewHolder = this
        binding.executePendingBindings()
    }

    fun onClickHero(view:View, hero:MarvelHero) {
        val bundleHero = bundleOf("hero" to hero.id)
        view.findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundleHero)
    }

    fun clear() {

    }

    companion object {
        const val HERO_IMAGE_WIDTH:Int = 320
        const val HERO_IMAGE_HEIGHT:Int = 212

        fun create(parent: ViewGroup): MarvelHeroViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val itemBinding = HeroItemBinding.inflate(layoutInflater, parent, false)
            return MarvelHeroViewHolder(itemBinding)
        }
    }
}