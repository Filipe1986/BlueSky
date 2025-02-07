package com.filipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VerificationMethod(String id, String type, String controller, String publicKeyMultibase) { }
