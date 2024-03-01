package org.demo.springDemo.controller;

import lombok.RequiredArgsConstructor;
import org.demo.springDemo.usecase.CreateTestUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController extends ApiController {

    private final CreateTestUseCase createTestUseCase;

    @PostMapping("/test/{number}")
    public ResponseEntity<Void> createTest(@PathVariable Long number) {

        this.createTestUseCase.execute(number);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
