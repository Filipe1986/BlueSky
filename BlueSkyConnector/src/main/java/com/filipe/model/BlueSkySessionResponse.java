package com.filipe.model;


public record BlueSkySessionResponse(String did,
                                     DidDoc didDoc,
                                     String handle,
                                     String email,
                                     boolean emailConfirmed,
                                     boolean emailAuthFactor,
                                     String accessJwt,
                                     String refreshJwt,
                                     boolean active) {}
