package com.filipe.response;

import java.util.List;

public record Author(
        String did,
        String handle,
        String displayName,
        String avatar,
        Viewer viewer,
        List<Label> labels,
        String createdAt
) {}
