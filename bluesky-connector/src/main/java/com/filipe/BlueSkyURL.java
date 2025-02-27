package com.filipe;

public class BlueSkyURL {

    private BlueSkyURL() {
        throw new IllegalStateException("Utility class");
    }

    public static class POST {
        private POST() {
            throw new IllegalStateException("Utility class");
        }
        public static final String CREATE_SESSION = "xrpc/com.atproto.server.createSession";
        public static final String CREATE_RECORD = "xrpc/com.atproto.repo.createRecord";
    }

    public static class GET {
        private GET() {
            throw new IllegalStateException("Utility class");
        }
        public static final String GET_TIMELINE  = "/xrpc/app.bsky.feed.getTimeline";
    }



}
