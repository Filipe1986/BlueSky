package com.filipe.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record DidDoc(
    @JsonProperty("@context") List<String> context,
    String id,
    List<String> alsoKnownAs,
    List<VerificationMethod> verificationMethod,
    List<Service> service
) { }
