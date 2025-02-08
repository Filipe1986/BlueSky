package com.filipe.request;

import com.filipe.BlueSkyURL;
import com.filipe.configuration.BlueSkyAuth;
import com.filipe.response.FeedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Objects;


@Component
public class GetTimelineClientRequest {

    private final String url;
    RestTemplate restTemplate;

    @Autowired
    public GetTimelineClientRequest(BlueSkyAuth blueSkyAuth) {
        url = blueSkyAuth.getPDSHOST() + BlueSkyURL.GET.GET_TIMELINE;
        restTemplate = new RestTemplate();
    }

    /**
     * Authenticate with BlueSky
     * @return BlueSkySessionResponse
     */
    public FeedResponse getTimeline(String jwt) {

        MultiValueMap<String, String> headers = headers(jwt);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(headers);

        URI uri = UriComponentsBuilder.fromUriString(url)
                .queryParam("limit", 2)
                .build()
                .toUri();

        ResponseEntity<FeedResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity, FeedResponse.class);

        System.out.println("timeline feed size: " + Objects.requireNonNull(response.getBody()).feed().size());
        System.out.println("timeline: " + response.getBody());
        return response.getBody();
    }


    private HttpHeaders headers(String accessJwt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessJwt);
        return headers;
    }
}
