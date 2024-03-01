package org.demo.springDemo.usecase;

import org.demo.springDemo.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@IntegrationTest
public class CreateTestUseCaseIT {

    @Autowired
    private TestRestTemplate rest;

    @Autowired
    private TestRepository testRepository;

    @Test
    void test() {
        rest.postForObject("/api/test/{number}", null, ResponseEntity.class, Map.of("number", 2));

        List<org.demo.springDemo.entity.Test> testList = this.testRepository.findAll();

        assertEquals(1, testList.size());
    }

    @Test
    void test2() {
        rest.postForObject("/api/test/{number}", null, ResponseEntity.class, Map.of("number", 3));

        List<org.demo.springDemo.entity.Test> testList = this.testRepository.findAll();

        assertEquals(1, testList.size());
    }
}
