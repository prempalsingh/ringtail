package com.prempal.ringtail.ui.rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.prempal.ringtail.R
import com.prempal.ringtail.data.PullRequestsResponse

/**
 * Created by prempal on 3/2/20.
 */
class PRViewHolder private constructor(v: View) : RecyclerView.ViewHolder(v) {

    private val authorImage = itemView.findViewById<ImageView>(R.id.pr_author_image)
    private val authorName = itemView.findViewById<ImageView>(R.id.pr_author)
    private val prTitle = itemView.findViewById<ImageView>(R.id.pr_title)
    private val prCreatedAt = itemView.findViewById<ImageView>(R.id.pr_created_at)
    private val prCloseddAt = itemView.findViewById<ImageView>(R.id.pr_closed_at)

    companion object {
        fun from(parent: ViewGroup): PRViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return PRViewHolder(
                layoutInflater.inflate(R.layout.item_pr, parent, false)
            )
        }
    }

    fun bind(pr: PullRequestsResponse) {

    }
}
