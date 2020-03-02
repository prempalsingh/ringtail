package com.prempal.ringtail.utils

import com.prempal.ringtail.data.PullRequest
import com.prempal.ringtail.ui.rv.PRUIModel

/**
 * Created by prempal on 3/2/20.
 */
fun mapResponseToUIModel(list: List<PullRequest>): List<PRUIModel> {
    return list.map {
        PRUIModel(
            it.user.avatarUrl,
            it.user.login,
            it.title,
            convertTime(it.createdAt),
            convertTime(it.closedAt)
        )
    }
}
