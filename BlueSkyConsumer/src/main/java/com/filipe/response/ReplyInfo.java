package com.filipe.response;

public record ReplyInfo(
        ReplyDetail parent,
        ReplyDetail root
) {}
