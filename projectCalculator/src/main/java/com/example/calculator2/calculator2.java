package com.example.calculator2;

import java.util.LinkedList;
import java.util.Queue;

public class calculator2 {
    // 필드
    private Queue<Integer> results;
    private static final int maxResult = 3; // 최대 저장 개수

    // 생성자
    public calculator2() {
        results = new LinkedList<>();
    }

    public int calculate(int num1, int num2, char symbol) {
        int result = 0;
        String error1 ="0으로 나눌 수 없습니다.";
        String error2 = "잘못된 연산기호입니다.";

        switch (symbol) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return error1;
                }
                break;
            default:
                System.out.println("잘못된 연산기호입니다.");
                return error2;
        }

        results.add(result);

        if (results.size() > maxResult) {
            results.poll();
        }

        return result;
    }

    // Getter
    public Queue<Integer> getResults() {
        return new LinkedList<>(results);
    }

    // Setter
    public void setResults(Queue<Integer> newResults) {
        if (newResults.size() > maxResult) {
            while (newResults.size() > maxResult) {
                newResults.poll();
            }
        }
        this.results = new LinkedList<>(newResults);
    }
}
