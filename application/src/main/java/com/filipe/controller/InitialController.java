package com.filipe.controller;

import com.filipe.configuration.BlueSkyAuth;
import com.filipe.model.BlueSkyPostResponse;
import com.filipe.model.BlueSkySessionResponse;
import com.filipe.request.AuthClientRequest;
import com.filipe.request.CreateRecordClientRequest;
import com.filipe.request.GetTimelineClientRequest;
import com.filipe.response.FeedResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;


@Slf4j
@RestController
public class InitialController {

    private final BlueSkyAuth blueSkyAuth;

    private final AuthClientRequest blueSkyAuthClientRequest;

    private final CreateRecordClientRequest createRecordClientRequest;

    private final GetTimelineClientRequest getTimelineClientRequest;

    public InitialController(BlueSkyAuth blueSkyAuth, AuthClientRequest blueSkyAuthClientRequest, CreateRecordClientRequest createRecordClientRequest, GetTimelineClientRequest getTimelineClientRequest) {
        this.blueSkyAuth = blueSkyAuth;
        this.blueSkyAuthClientRequest = blueSkyAuthClientRequest;
        this.createRecordClientRequest = createRecordClientRequest;
        this.getTimelineClientRequest = getTimelineClientRequest;
    }

    @Operation(summary = "Hello endpoint", description = "Dummy return message")
    @GetMapping("/hello")
    public String getInitialMessage() {
        log.info(blueSkyAuth.getBlueSkyHandle());
        return "Hello, World!";
    }

    @Operation(summary = "Post text endpoint", description = "Post message to BlueSky")
    @PostMapping("/createPost")
    public ResponseEntity<?> getInitialMessage(@RequestBody String text) {

        ResponseEntity<BlueSkySessionResponse> response = blueSkyAuthClientRequest.authenticate();

        if(response.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error authenticating");
        }

        ResponseEntity<BlueSkyPostResponse> createRecordResponse = createRecordClientRequest.createRecord(Objects.requireNonNull(response.getBody()).accessJwt(), text);

        if (createRecordResponse.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating record");
        }
        return ResponseEntity.ok(createRecordResponse.getBody());
    }


    @Operation(summary = "GEt timeline", description = "Get timeline from BlueSky")
    @GetMapping("/timeline")
    public ResponseEntity<?> getTimeline() {

        ResponseEntity<BlueSkySessionResponse> response = blueSkyAuthClientRequest.authenticate();

        if (response.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error authenticating");
        }
        FeedResponse resp = getTimelineClientRequest.getTimeline(Objects.requireNonNull(response.getBody()).accessJwt());
        return ResponseEntity.ok(resp);
    }



}
