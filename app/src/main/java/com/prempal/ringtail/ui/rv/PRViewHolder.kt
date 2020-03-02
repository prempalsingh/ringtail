package com.prempal.ringtail.ui.rv

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prempal.ringtail.R

/**
 * Created by prempal on 3/2/20.
 */
class PRViewHolder private constructor(v: View) : RecyclerView.ViewHolder(v) {

    private val authorImage = itemView.findViewById<ImageView>(R.id.pr_author_image)
    private val authorName = itemView.findViewById<TextView>(R.id.pr_author)
    private val prTitle = itemView.findViewById<TextView>(R.id.pr_title)
    private val prCreatedAt = itemView.findViewById<TextView>(R.id.pr_created_at)
    private val prClosedAt = itemView.findViewById<TextView>(R.id.pr_closed_at)

    companion object {
        fun from(parent: ViewGroup): PRViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return PRViewHolder(
                layoutInflater.inflate(R.layout.item_pr, parent, false)
            )
        }
    }

    fun bind(pr: PRUIModel) {
        Glide.with(itemView.context)
            .load(pr.authorImageUrl)
            .placeholder(ColorDrawable(Color.LTGRAY))
            .into(authorImage)

        authorName.text = pr.authorName
        prTitle.text = pr.prTitle
        prClosedAt.text = pr.prClosedAt
        prCreatedAt.text = pr.prCreatedAt
    }
}
