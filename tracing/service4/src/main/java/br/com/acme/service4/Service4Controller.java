package br.com.acme.service4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/service4")
@RequiredArgsConstructor
@Slf4j
public class Service4Controller {
    private final Random random = new Random();

    @GetMapping
    public ResponseEntity<?> service4(){
        log.info("Received request for /service4");

        // Simular lentidão em 20% das requisições
        if (random.nextDouble() < 0.2) {
            try {
                log.info("Simulating latency...");
                Thread.sleep(5000); // Simula 5 segundos de latência
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Simular erro em 10% das requisições
        if (random.nextDouble() < 0.1) {
            log.error("Simulating error...");
            throw new RuntimeException("Simulated error occurred");
        }
        return ResponseEntity.ok(Map.of("message", "service4 called"));

    }

}
