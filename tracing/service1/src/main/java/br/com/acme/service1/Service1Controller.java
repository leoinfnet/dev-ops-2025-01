package br.com.acme.service1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/service1")
@RequiredArgsConstructor
@Slf4j
public class Service1Controller {
    private final RestTemplate restTemplate;
    @GetMapping
    public ResponseEntity<?> service1(){
        log.info("service1 called");
        Map<String,String> response = restTemplate.getForObject("http://localhost:8081/service2", Map.class);
        log.info("response: {}", response);
        return ResponseEntity.ok(Map.of("message","service 1 called"));
    }
}
