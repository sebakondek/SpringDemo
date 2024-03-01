package org.demo.springDemo.usecase;

import lombok.RequiredArgsConstructor;
import org.demo.springDemo.entity.Test;
import org.demo.springDemo.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTestUseCaseImp implements CreateTestUseCase {

    private final TestRepository testRepository;

    @Override
    public void execute(Long number) {
        Boolean isEven = number % 2 == 0;

        Test test = Test.builder()
                .number(number)
                .isEven(isEven)
                .text(isEven ? number.toString() : null)
                .build();

        this.testRepository.save(test);
    }
}
