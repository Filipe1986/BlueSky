package com.filipe.response;

import java.util.List;

public record Post(
        String uri,
        String cid,
        Author author,
        BlueSkyRecord record,
        int replyCount,
        int repostCount,
        int likeCount,
        int quoteCount,
        String indexedAt,
        Viewer viewer,
        List<String> labels
) {}
