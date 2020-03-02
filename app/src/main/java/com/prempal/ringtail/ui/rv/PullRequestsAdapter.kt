package com.prempal.ringtail.ui.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.prempal.ringtail.data.PullRequest

/**
 * Created by prempal on 3/2/20.
 */
class PullRequestsAdapter : ListAdapter<PullRequest, PRViewHolder>(PRDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PRViewHolder {
        return PRViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PRViewHolder, position: Int) {
        val pr = getItem(position)
        holder.bind(pr)
    }
}

class PRDiffCallback : DiffUtil.ItemCallback<PullRequest>() {
    override fun areItemsTheSame(oldItem: PullRequest, newItem: PullRequest): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PullRequest, newItem: PullRequest): Boolean {
        return oldItem == newItem
    }
}
