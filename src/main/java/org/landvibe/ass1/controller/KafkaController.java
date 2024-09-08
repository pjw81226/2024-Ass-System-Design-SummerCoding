package org.landvibe.ass1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class KafkaController {
    @GetMapping("/api")
    public String api(){
        return "";
    }

}
