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

    public static void code1255() throws Exception{
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        if( a > b ){
            throw new Exception("a의 값이 b의 값보다 작거나 같습니다");
        }

        for( double n = a; n <= b; n += 0.01 ){
            String result = String.format("%.2f", n);
            System.out.print( result + " ");
        }
    }

    public static void code1253() throws Exception{
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int tmp = 0;

        if( a < b ){
            tmp = a;
            a = b;
            b = tmp;
        }

        for( int n = b; n <= a; n++ ){
            System.out.print( n + " ");
        }
    }

    public static void code1283() throws Exception{
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] array = new int[b];
        double result = a;

        if ( a < 100 || a > 10000 ){
            throw new Exception( "a의 값은 100과 10000 사이입니다" );
        }

        if ( b < 1 || b > 10){
            throw new Exception( "b의 값은 1과 10 사이 입니다." );
        }

        for(int i = 0 ; i < array.length; i++){
            array[i] = sc.nextInt();
            if ( array[i] < -100 || array[i] > 100 ){
                throw new Exception("array[i]의 값은 -100과 100 사이의 숫자입니다");
            }
            result = result * (array[i] + 100) / 100;
        }
        double n = result - a;
        String result1 = String.format("%.0f", n);
            if ( n < 0 ){
                System.out.println(result1);
                System.out.println("bad");
            }else if ( n == 0 ){
                System.out.println(result1);
                System.out.println("same");
            }else if ( n > 0 ){
                System.out.println(result1);
                System.out.println("good");
            }

    }

    public static void code1284() throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0, b = 0;
        if( n < 1 || n > 10000000){
            throw new Exception("n의 값이 1 과 1천만 사이의 숫자입니다");
        }
        for(int i = 2; i <= n; i++){
            for(int j = 2; j < n; j++){
                if( i * j == n){
                    a = i;
                    b = j;
                    break;
                }
            }if( a != 0 && b != 0){
                break;
            }
        }
        if( a == 0 && b == 0){
            System.out.print("wrong number");
        }else {
            System.out.print(a + " " + b);
        }
    }

    public static void code1226() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int[] array1 = new int[7];
        int[] array2 = new int[6];
        int cnt = 0;

        for (int i = 0; i < array1.length; i++) {
            array1[i] = scanner.nextInt();
        }
        for (int i = 0; i < array2.length; i++) {
            array2[i] = scanner.nextInt();
        }

        for (int i = 0; i < array1.length - 1; i ++) {
            for(int j = 0; j < array2.length; j++) {
                if ( array1[i] == array2[j] ) {
                    cnt++;
                    break;
                }
            }
        }
        int a = 0;
        for(int j = 0; j < array2.length; j++) {
            if ( array1[6] == array2[j] ) {
                a = 1;
                break;
            }
        }
        int result = 0;
        if(cnt == 5 && a == 1) {
            result = 2;
        }else{
            switch( cnt ) {
                case 0:
                case 1:
                case 2:
                    result = 0;
                    break;
                case 3:
                    result = 5;
                    break;
                case 4:
                    result = 4;
                    break;
                case 5:
                    result = 3;
                    break;
                case 6:
                    result = 1;
                    break;
            }
        }
        System.out.print(result);

    }

    public static void code1368() throws Exception{
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int k = sc.nextInt();
        String d = sc.next();
        if ( d.equals("L") ){
            for(int i = 0; i < h; i++){
                for(int j = 0; j <= h; j++){
                    System.out.print(" ");
                }
                for(int j = 0; j < k; j++){
                    System.out.print("*");
                }
                System.out.println();

            }
        }else if ( d.equals("R") ){
            for(int i = 0; i < h; i++){
                for(int j = h-1; j >= i; j--){
                    System.out.print(" ");
                }
                for(int j = 0; j < k; j++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }

    }

    public static void code1094() throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] k = new int[n];
        if( n < 1 || n > 10000 ){
            throw new Exception("a는 1에서 10000 사이입니다.");
        }
        for(int i = 0; i < k.length; i++ ){
            k[i] = sc.nextInt();
            if( k[i] < 1 || k[i] > 23 ){
                throw new Exception("k[i]의 값은 1~23 입니다");
            }
        }
        for(int i = n - 1; i >= 0; i--){
            System.out.print(k[i] + " ");
        }
    }

    public static void code1430() throws Exception{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        if(N < 1 || N > 10000000){
            throw new Exception("N의 값은 1~1천만 사이입니다");
        }
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
            if(array[i] < 1 || array[i] > 10000000){
                throw new Exception("array[i]의 값은 1~1천만 사이 입니다");
            }
        }

        int M = sc.nextInt();
        int[] result = new int[M];
        if(M < 1 || M > 100000){
            throw new Exception("M의 값은 1부터 1십만 사이입니다");
        }
        for(int i = 0; i < M; i++){
            result[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            boolean found = false;
            for (int j = 0; j < M; j++) {
                if (array[i] == result[j]) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
    }

}
