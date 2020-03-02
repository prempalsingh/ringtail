package com.prempal.ringtail.ui.rv

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.prempal.ringtail.data.PullRequestsResponse

/**
 * Created by prempal on 3/2/20.
 */
class PullRequestsAdapter : ListAdapter<PullRequestsResponse, PRViewHolder>(PRDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PRViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: PRViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class PRDiffCallback : DiffUtil.ItemCallback<PullRequestsResponse>() {
    override fun areItemsTheSame(oldItem: PullRequestsResponse, newItem: PullRequestsResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PullRequestsResponse, newItem: PullRequestsResponse): Boolean {
        return oldItem == newItem
    }
}
