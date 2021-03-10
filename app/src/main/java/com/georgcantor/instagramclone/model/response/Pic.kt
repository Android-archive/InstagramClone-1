package com.georgcantor.instagramclone.model.response

data class Pic(
    var totalHits: Int = 0,
    var hits: List<Hit>,
    private var total: Int = 0
)