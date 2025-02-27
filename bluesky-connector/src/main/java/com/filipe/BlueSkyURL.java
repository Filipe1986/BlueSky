package com.filipe;

public class BlueSkyURL {

    public static final String UTILITY_CLASS = "Utility class";

    private BlueSkyURL() {
        throw new IllegalStateException(UTILITY_CLASS);
    }

    public static class POST {
        private POST() {
            throw new IllegalStateException(UTILITY_CLASS);
        }
        public static final String CREATE_SESSION = "xrpc/com.atproto.server.createSession";
        public static final String CREATE_RECORD = "xrpc/com.atproto.repo.createRecord";
    }

    public static class GET {
        private GET() {
            throw new IllegalStateException(UTILITY_CLASS);
        }
        public static final String GET_TIMELINE  = "/xrpc/app.bsky.feed.getTimeline";
    }



}
