package com.filipe.request;

import com.filipe.BlueSkyURL;
import com.filipe.configuration.BlueSkyAuth;
import com.filipe.model.BlueSkySessionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Component
public class AuthClientRequest {

    private final BlueSkyAuth blueSkyAuth;

    private final String createSessionUrl;

    @Autowired
    public AuthClientRequest(BlueSkyAuth blueSkyAuth) {
        this.blueSkyAuth = blueSkyAuth;
        createSessionUrl = blueSkyAuth.getPDSHOST() + BlueSkyURL.POST.CREATE_SESSION;
    }

    /**
     * Authenticate with BlueSky
     * @return BlueSkySessionResponse
     */
    public ResponseEntity<BlueSkySessionResponse> authenticate() {

        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> requestBody = getRequestBody();
        MultiValueMap<String, String> headers = getHeaders();
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(createSessionUrl, HttpMethod.POST, entity, BlueSkySessionResponse.class);
    }

    private static MultiValueMap<String, String> getHeaders() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }

    private Map<String, Object> getRequestBody() {
        Map<String, Object> requestBody = new java.util.HashMap<>();
        requestBody.put("identifier", blueSkyAuth.getBLUESKY_HANDLE());
        requestBody.put("password", blueSkyAuth.getPassword);
        return requestBody;
    }
}
