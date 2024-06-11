package com.studymavenspringboot.study001.mathExam;
import java.util.Scanner;

public class Record {
    public static void main(String[] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //데이터의 개수
        int m = sc.nextInt(); //출력 인원

        String[] name = new String[n];
        int[] score = new int[n];
        int tmps = 0;
        String tmpn = "";

        if( n < 3 || n > 100){
            throw new Exception("n의 값은 3~100 사이입니다");
        }
        if( m < 1 || m > n){
            throw new Exception("m의 값은 1과 n 사이의 숫자입니다");
        }

        sc.nextLine();

        for(int i = 0; i < n; i++){
            name[i] = sc.nextLine(); // 학생 이름과 점수
            score[i] = sc.nextInt();
            sc.nextLine();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (score[j] < score[j + 1]) {
                    // 점수 swap
                    tmps = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = tmps;

                    // 이름 swap
                    tmpn = name[j];
                    name[j] = name[j + 1];
                    name[j + 1] = tmpn;
                }
            }
        }

        for( int i = 0; i < m; i++){
            System.out.println(name[i]);
        }

    }

}
