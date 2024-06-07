package com.studymavenspringboot.study001.mathExam;
import java.util.Scanner;
public class QuestExam {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int s = scanner.nextInt();
        if ( h > 48000 || h <= 0 ){
            throw new Exception("h가 48000이하여야 합니다.");
        }
        if ( b > 32 || b <= 0 ){
            throw new Exception("b가 32이하여야 합니다.");
        }
        if ( c > 5 || c <= 0 ){
            throw new Exception("c가 5이하여야 합니다.");
        }
        if ( s > 6000 || s <= 0 ){
            throw new Exception("h가 6000이하여야 합니다.");
        }

        double x = (double) (h * (long)b * c * s) / (8 * 1024 * 1024);
        String result = String.format("%.1f", x);
        System.out.println(result + " MB");
    }
}
