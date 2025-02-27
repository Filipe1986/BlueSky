package com.filipe.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class BlueSkyAuth {

    @Value("${blueSky.handle}")
    private  String blueSkyHandle;

    @Value("${blueSky.pdshost}")
    private String pdsHost;

    @Value("${blueSky.publicHost}")
    private String publicHost;

    @Value("${blueSky.password}")
    public String getPassword;
}
