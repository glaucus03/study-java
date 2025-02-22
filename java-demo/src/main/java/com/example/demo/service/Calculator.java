package com.example.demo.service;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class Calculator {
  public int add(int a, int b) {
    return a + b;
  }

  public int divide(int a, int b) {
    if (b == 0) {
      throw new IllegalArgumentException("Division by zero is not allowed");
    }
    return a / b;
  }

  // デバッグ用のメソッド
  public int complexCalculation(int a, int b, int c) {
    log.debug("Starting complex calculation with: {}, {}, {}", a, b, c);

    // ブレークポイントを設定しやすいように処理を分割
    int step1 = a * b;
    log.debug("Step 1 result: {}", step1);

    int step2 = step1 + c;
    log.debug("Step 2 result: {}", step2);

    int finalResult = step2 / 2;
    log.debug("Final result: {}", finalResult);

    return finalResult;
  }
}
