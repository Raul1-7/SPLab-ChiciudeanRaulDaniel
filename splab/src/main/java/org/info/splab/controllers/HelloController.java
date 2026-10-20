package org.info.splab.controllers;

import lombok.RequiredArgsConstructor;
import org.info.splab.difexamples.ClientComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class HelloController {
    private final ClientComponent clientComponent;

    @GetMapping("/")
    public String hello() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/client")
    public String client() {
        return "Hello from ClientComponent = " + clientComponent.toString();
    }
}
