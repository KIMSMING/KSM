package com.studymavenspringboot.study001.mathExam;

public class MathExam {
    public int subTest001(int n1, int n2) throws Exception{
        if( n1 < -50000 || n1 > 50000){
            throw new Exception("num1 값은 -50001보다 작거나 num1 값은 50000보다 큽니다");
        }
        if( n2 < -50000 || n2 > 50000){
            throw new RuntimeException("num2 값은 -50001보다 작거나 num2 값은 50000보다 큽니다");
        }
        return n1 - n2;
    }
}
