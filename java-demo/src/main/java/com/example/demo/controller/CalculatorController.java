package com.example.demo.controller;

import com.example.demo.service.Calculator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
public class CalculatorController {
  private final Calculator calculator;

  @GetMapping("/add")
  public int add(@RequestParam int a, @RequestParam int b) {
    log.debug("Received add request: {} + {}", a, b);
    return calculator.add(a, b);
  }

  @GetMapping("/complex")
  public int complexCalculation(@RequestParam int a, @RequestParam int b, @RequestParam int c) {
    log.debug("Received complex calculation request: {}, {}, {}", a, b, c);
    return calculator.complexCalculation(a, b, c);
  }
}
