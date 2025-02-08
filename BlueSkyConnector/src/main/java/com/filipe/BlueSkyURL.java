package com.filipe;

public class BlueSkyURL {

    public static class POST {
        public static final String CREATE_SESSION = "xrpc/com.atproto.server.createSession";
        public static final String CREATE_RECORD = "xrpc/com.atproto.repo.createRecord";
    }

    public static class GET {
        public static final String GET_TIMELINE  = "/xrpc/app.bsky.feed.getTimeline";
    }



}
