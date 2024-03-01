package org.demo.springDemo.usecase;

import org.demo.springDemo.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CreateTestUseCaseTest {

    private TestRepository testRepository;
    private CreateTestUseCase createTestUseCase;

    @BeforeEach
    public void setUp() {
        this.testRepository = mock(TestRepository.class);

        this.createTestUseCase = new CreateTestUseCaseImp(testRepository);
    }

    @Test
    void whenTestWithOdd_mustSaveFalseEntity() {
        // Given
        Long number = 5L;

        // When
        this.createTestUseCase.execute(number);

        // Then
        org.demo.springDemo.entity.Test expectedEntity = org.demo.springDemo.entity.Test.builder()
                .number(number)
                .isEven(Boolean.FALSE)
                .build();

        verify(this.testRepository).save(expectedEntity);
    }

    @Test
    void whenTestWithEven_mustSaveTrueEntity() {
        // Given
        Long number = 4L;

        // When
        this.createTestUseCase.execute(number);

        // Then
        org.demo.springDemo.entity.Test expectedEntity = org.demo.springDemo.entity.Test.builder()
                .number(number)
                .isEven(Boolean.TRUE)
                .text(number.toString())
                .build();

        verify(this.testRepository).save(expectedEntity);
    }
}
