package com.prempal.ringtail.ui.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 * Created by prempal on 3/2/20.
 */
class PullRequestsAdapter : ListAdapter<PRUIModel, PRViewHolder>(PRDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PRViewHolder {
        return PRViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PRViewHolder, position: Int) {
        val pr = getItem(position)
        holder.bind(pr)
    }
}

class PRDiffCallback : DiffUtil.ItemCallback<PRUIModel>() {
    override fun areItemsTheSame(oldItem: PRUIModel, newItem: PRUIModel): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: PRUIModel, newItem: PRUIModel): Boolean {
        return oldItem == newItem
    }
}
