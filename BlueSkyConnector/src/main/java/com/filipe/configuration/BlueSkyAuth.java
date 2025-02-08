package com.filipe.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BlueSkyAuth {

    @Value("${blueSky.handle}")
    private String BLUESKY_HANDLE;

    @Value("${blueSky.pdshost}")
    private String PDSHOST;

    @Value("${blueSky.publicHost}")
    private String publicHost;

    @Value("${blueSky.password}")
    public String getPassword;
}
