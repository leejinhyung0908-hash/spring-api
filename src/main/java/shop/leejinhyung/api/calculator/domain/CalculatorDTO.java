package shop.leejinhyung.api.calculator.domain;

public class CalculatorDTO {
    // 통합 계산기(num1, num2, operation)
    private int num1;
    private int num2;
    private String operation;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num12) {
        this.num1 = num12;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num22) {
        this.num2 = num22;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
