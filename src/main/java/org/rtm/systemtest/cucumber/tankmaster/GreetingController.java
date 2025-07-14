package org.rtm.systemtest.cucumber.tankmaster;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GreetingController {
    @GetMapping("/greet")
    public ResponseEntity<String> greet(@RequestParam(defaultValue = "World") String name) {
        return ResponseEntity.ok("Hello, " + name + "!");
    }
}