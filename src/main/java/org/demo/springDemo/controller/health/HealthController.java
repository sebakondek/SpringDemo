package org.demo.springDemo.controller.health;

import lombok.extern.slf4j.Slf4j;
import org.demo.springDemo.controller.ApiController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthController extends ApiController {

    /**
     * Health check for container purposes
     * @return
     */
    @GetMapping("/health")
    public ResponseEntity<Void> checkHealth() {
        log.info("I'm healthy!");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
