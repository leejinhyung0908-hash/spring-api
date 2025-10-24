package shop.leejinhyung.api.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CalculatorVO {
  // 통합 계산기(num1, num2, operation)
  private int num1;
  private int num2;
  private String operation;

}
