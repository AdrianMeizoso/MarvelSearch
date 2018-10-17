package com.adrian.marvelsearch.main.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.adrian.marvelsearch.R
import com.adrian.marvelsearch.common.injection.GlideApp

class MarvelHeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val heroName = view.findViewById(R.id.hero_name) as TextView
    private val heroImage = view.findViewById(R.id.hero_image) as ImageView

    fun bind(hero: MarvelHero) {
        heroName.text = hero.name

        heroImage.setOnClickListener {
            val bundleHero = bundleOf("hero" to hero.id)
            it.findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundleHero)
        }

        GlideApp.with(itemView)
                .load("${hero.thumbnail.path}/standard_fantastic.${hero.thumbnail.extension}")
                .override(600, 600)
                .into(heroImage)
    }

    fun clear() {

    }

    companion object {
        fun create(parent: ViewGroup): MarvelHeroViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.hero_item, parent, false)
            return MarvelHeroViewHolder(view)
        }
    }
}
