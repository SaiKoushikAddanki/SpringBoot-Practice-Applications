package com.koushik.latest.springlatestupdates.controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.web.bind.annotation.RestController;

@RestController
@OpenAPIDefinition(
        info = @Info(title = "Latest updates of spring standards",
                     description = "Open api documantation features explanation", version = "1.0"),
        servers = {
                @Server(url = "http://localhost:8080",
                        description = "Local url"),
                @Server(url = "https://google.com",
                        description = "UAT")
        })
public class MetaDataApiController {
}
