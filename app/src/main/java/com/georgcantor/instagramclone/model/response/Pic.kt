package com.georgcantor.instagramclone.model.response

class Pic(
    var totalHits: Int = 0,
    var hits: List<Picture>,
    private var total: Int = 0
)