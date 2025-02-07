package com.filipe.response;

import java.util.List;

public record Record(
        String $type,
        String createdAt,
        List<String> langs,
        ReplyInfo reply,
        String text
) {}
