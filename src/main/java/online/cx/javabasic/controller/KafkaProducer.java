package online.cx.javabasic.controller;

import online.cx.javabasic.JavaBasicApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducer {

    private final Logger logger = LoggerFactory.getLogger(JavaBasicApplication.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    @GetMapping("/test/{message}")
    public void sendMessage(@PathVariable("message") String message) {
        kafkaTemplate.send("topic", message);
    }

    @KafkaListener(topics = {"topic"})
    public void listen(String data) {
        logger.info("input value: {}" , data);
    }
}
