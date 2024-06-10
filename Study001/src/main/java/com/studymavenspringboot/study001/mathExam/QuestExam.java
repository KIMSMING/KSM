package com.studymavenspringboot.study001.mathExam;
import java.util.Scanner;
public class QuestExam {
    public static void main(String[] args) throws Exception {

    }
    public static void code1045() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if( a <= 0){
            throw new Exception("a의 값은 0보다 커야합니다");
        }
        if( b > 2147483647 || b == 0){
            throw new Exception("b의 값이 0이 아니고 2147483647보다 작거나같아야합니다.");
        }
        double num = (a * 1.0) / b;
        String result = String.format("%.2f", num);
        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println(result);
    }

    public static void code1046() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        if( a <= -2147483648 || a >= +2147483647){
            throw new Exception("a의 값이 -2147483648 +2147483648 사이여야 합니다");
        }
        if( b <= -2147483648 || b >= 2147483647){
            throw new Exception("b의 값이 -2147483648 +2147483648 사이여야 합니다");
        }
        if( c <= -2147483648 || c >= 2147483647){
            throw new Exception("c의 값이 -2147483648 +2147483648 사이여야 합니다");
        }
        int sum = a+ b+ c;
        double av = (double) sum / 3;
        String result = String.format("%.1f", av);
        System.out.println(sum);
        System.out.println(result);
    }

    public static void code1058() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int result = 0;
        if((a == 0) && (b == 0)){
            result = 1;
        }
        else{
            result = 0;
        }

        System.out.print(result);
    }

    public static void code1085() throws Exception{
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

    public static void code1090() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int r = scanner.nextInt();
        int n = scanner.nextInt();

        if ( a < 0 || a > 10 || n < 0 || n > 10 || r < 0 || r > 10){
            throw new Exception("a, n, r의 값은 모두 0에서 10 사이여야 합니다");
        }
        double x = Math.pow(n, r);
        double result = a * x;
        System.out.println((int)result);
    }

    public static void code1166() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        double a = Math.pow(2,32);
        if ( year < 1 || year > a - 1){
            throw new Exception("year 값은 1보다 크거나같고 2^32-1보다 작거나 같아야합니다.");
        }
        if ( year % 400 == 0){
            System.out.print("Leap");
        }else if ( year % 4 == 0 && year % 100 != 0 ) {
            System.out.print("Leap");
        }else{
            System.out.print("Normal");
        }
    }

    public static void code1165() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt();
        int Gall = scanner.nextInt();
        int T = 0;
        int G = 0;
        if ( time < 90 ){
            T = 89 - time;
        }
        G = T / 5;
        int result = G + Gall + 1;
        System.out.print(result);
    }

    public static void code1231() throws Exception{
        Scanner scanner = new Scanner(System.in);
        while(true){
            int n = scanner.nextInt();
            System.out.println(n);
            if( n == 0 ){

                break;
            }
        }
    }

    public static void code1079() throws Exception{
        Scanner scanner = new Scanner(System.in);
        while(true){
            char n = scanner.next().charAt(0);
            System.out.println(n);
            if( n == 'q' ){
                break;
            }
        }
    }
}
