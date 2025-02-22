package com.example.demo.service;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Calculator Tests")
class CalculatorTest {
  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @Test
  @DisplayName("1 + 1 = 2")
  void addsTwoNumbers() {
    assertThat(calculator.add(1, 1)).isEqualTo(2);
  }

  @ParameterizedTest(name = "{0} + {1} = {2}")
  @CsvSource({ "0,    1,   1", "1,    2,   3", "49,  51, 100", "1,  100, 101" })
  void add_shouldReturnExpectedResult(int first, int second, int expectedResult) {
    assertThat(calculator.add(first, second)).isEqualTo(expectedResult);
  }

  @Test
  @DisplayName("Division by zero should throw exception")
  void divide_shouldThrowOnZero() {
    assertThatThrownBy(() -> calculator.divide(1, 0))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("Division by zero is not allowed");
  }

  @ParameterizedTest(name = "Division by {0}")
  @ValueSource(ints = { 1, 2, 3, 4, 5 })
  void divide_shouldWorkWithNonZeroDenominator(int denominator) {
    // Given
    int numerator = 10;

    // When
    int result = calculator.divide(numerator, denominator);

    // Then
    assertThat(result).isEqualTo(numerator / denominator);
  }

  @Nested
  @DisplayName("Special cases")
  class SpecialCases {
    @Test
    @DisplayName("Adding negative numbers")
    void add_withNegativeNumbers() {
      assertThat(calculator.add(-1, -1)).isEqualTo(-2);
    }

    @Test
    @DisplayName("Adding zero")
    void add_withZero() {
      assertThat(calculator.add(0, 5)).isEqualTo(5);
    }
  }

  @Test
  @DisplayName("Complex calculation test")
  void complexCalculation_shouldWorkCorrectly() {
    int result = calculator.complexCalculation(10, 2, 5);
    assertThat(result).isEqualTo(12); // (10 * 2 + 5) / 2 = 12
  }
}
