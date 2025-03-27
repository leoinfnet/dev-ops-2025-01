package br.com.acme.service2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/service2")
@RequiredArgsConstructor
@Slf4j
public class Service2Controller {
    private final RestTemplate restTemplate;
    @GetMapping
    public ResponseEntity<?> service2(){
        log.info("service2 called");
        restTemplate.getForEntity("http://localhost:8082/service3", Map.class);
        restTemplate.getForEntity("http://localhost:8083/service4", Map.class);

        return ResponseEntity.ok(Map.of("message","service 2 called"));
    }
}
