package com.filipe.response;

public record Reply(
        PostView root,
        PostView parent
) {}
