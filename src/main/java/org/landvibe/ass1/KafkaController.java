package org.landvibe.ass1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {
    private  final KafkaProducerService kafkaProducerService;
    @GetMapping("/api/msg/{msg}")
    public String api(@PathVariable("msg") String msg){
        kafkaProducerService.sendMessage(msg);
        return "send msg : " + msg;
    }

}
