package com.filipe.request;

import com.filipe.BlueSkyURL;
import com.filipe.configuration.BlueSkyAuth;
import com.filipe.model.BlueSkyPostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Component
public class CreateRecordClientRequest {

    private final BlueSkyAuth blueSkyAuth;
    private final String createRecordUrl;
    RestTemplate restTemplate;

    @Autowired
    public CreateRecordClientRequest(BlueSkyAuth blueSkyAuth) {
        this.blueSkyAuth = blueSkyAuth;
        createRecordUrl = blueSkyAuth.getPdsHost() + BlueSkyURL.POST.CREATE_RECORD;
        restTemplate = new RestTemplate();
    }

    public ResponseEntity<BlueSkyPostResponse> createRecord(String jwt, String text) {

        HttpHeaders headers = createHeaders(jwt);
        HttpEntity<Map<String, Object>> entity = createRequestEntity(headers, text);


        return restTemplate.exchange(createRecordUrl, HttpMethod.POST, entity, BlueSkyPostResponse.class);
    }

    private HttpHeaders createHeaders(String accessJwt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessJwt);
        return headers;
    }

    private HttpEntity<Map<String, Object>> createRequestEntity(HttpHeaders headers, String text) {
        Map<String, Object> blueSkyRecordMap = new HashMap<>();
        blueSkyRecordMap.put("text", text);
        blueSkyRecordMap.put("createdAt", Instant.now().toString());

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("repo", blueSkyAuth.getBlueSkyHandle());
        requestBody.put("collection", "app.bsky.feed.post");
        requestBody.put("record", blueSkyRecordMap);

        return new HttpEntity<>(requestBody, headers);
    }
}
