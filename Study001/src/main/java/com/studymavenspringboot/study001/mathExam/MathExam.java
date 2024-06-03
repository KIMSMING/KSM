package com.studymavenspringboot.study001.mathExam;

public class MathExam {
    public int subTest001(int n1, int n2) throws Exception {
        if (n1 < -50000 || n1 > 50000) {
            throw new Exception("num1값은  -50000보다 작거나, num1값은 5000보다 큽니다");
        }
        if (n2 < -50000 || n2 > 50000) {
            throw new RuntimeException("num2값은  -50000보다 작거나, num2값은 5000보다 큽니다");
        }
        return n1 - n2;
    }

    public int mathTest002( int n1, int n2) throws Exception {
        if ( n1 < 0 || n1 > 100 ){
            throw new Exception("num1 값은 0 ~ 100 사이의 값 이어야 합니다");
        }
        if ( n2 < 0 || n2 > 100 ){
            throw new Exception("num2 값은 0 ~ 100 사이의 값 이어야 합니다.");
        }
        return n1 * n2;
    }
    public int mathTest003( int n1, int n2) throws Exception {
        if ( n1 >= 0 || n1 <= 10000 ){
            throw new Exception("num1 값은 0~10000 사이의 값 이어야 합니다");
        }
        if ( n2 >= 0 || n2 <= 10000 ){
            throw new RuntimeException("num2 값은 0 ~ 10000 사이의 값 이어야 합니다.");
        }
        int result = 0;
        if( n1 == n2 ){
            result = 1;
        }else {
//        if ( n1 != n2 ){
            result =-1;
        }
        return result;
    }
    public double exam120817( int[] numbers ) throws Exception{
        if ( numbers == null ){
            throw new Exception("numbers는 null이 아니어야 합니다.");
        }
        if ( numbers.length < 1 || numbers.length > 100 ){
            throw new Exception("numbers 배열의 크기는 1 ~ 100개 사이어야 합니다.");
        }
        double sum = 0.0d;
        for(int i = 0;  i < numbers.length; i++){
            if ( numbers[i] < 0 || numbers[i] > 1000){
                throw new Exception("numbers[%d] 배열의 값은 0~1000 사이어야 합니다.");

            }
            sum += numbers[i];
        }
        double A = sum / numbers.length;

        return A;
    }
}
