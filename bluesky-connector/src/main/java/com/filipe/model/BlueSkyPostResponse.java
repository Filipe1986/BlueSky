package com.filipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BlueSkyPostResponse(String uri, String cid, Commit commit, String validationStatus) {}