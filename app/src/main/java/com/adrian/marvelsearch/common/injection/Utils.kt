package com.adrian.marvelsearch.common.injection

import android.content.res.Resources
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.adrian.marvelsearch.main.domain.MarvelHeroViewHolder.Companion.HERO_IMAGE_HEIGHT
import com.adrian.marvelsearch.main.domain.MarvelHeroViewHolder.Companion.HERO_IMAGE_WIDTH
import java.security.MessageDigest

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {
    GlideApp.with(context).load(url).override(HERO_IMAGE_WIDTH.px, HERO_IMAGE_HEIGHT.px).into(this)
}


fun String.md5() : String {
    val md = MessageDigest.getInstance("MD5")
    val digested = md.digest(toByteArray())
    return digested.joinToString("") {
        String.format("%02x", it)
    }
}

val Int.dp: Int get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.px: Int get() = (this * Resources.getSystem().displayMetrics.density).toInt()