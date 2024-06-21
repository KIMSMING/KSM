package com.studymavenspringboot.study001.mathExam;

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if( a < 1 || b < a || b > 5000){
            throw new Exception("( 1 <= a <= b <= 5000)이어야 합니다");
        }
        int z = 0;
        int t = 0;
        int sum = 0;
        int L = 0;
        for( int i = a; i <= b; i++ ){
            for( int j = a+1; j <= i-1; j++ ){
                if( i/10 < 1){
                    z = i*2;
                    if( j/10 < 1){
                        t = j*2;
                    }else{
                        t = j + j/10 + j%10;
                    }
                }else{
                    if( j/10 < 1){
                        t = j*2;
                    }else{
                        z = i + i/10 + i%10;
                        t = j + j/10 + j%10;
                    }
                }
                if( z == t ){
                    int s = i;
                }
                else{
                    L = i;
                }
            }
            sum += L;
        }
        System.out.println(sum);
    }
}
