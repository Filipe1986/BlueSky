package com.filipe.response;

public record Viewer(
        boolean muted,
        boolean blockedBy,
        String following,
        boolean threadMuted,
        boolean embeddingDisabled
) {}
