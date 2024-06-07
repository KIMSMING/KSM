package com.studymavenspringboot.study001.mathExam;

public class MathExam {
    public int exam120803(int num1, int num2) throws Exception {
        if (num1 < -50000 || num1 > 50000) {
            throw new Exception("num1값은  -50000보다 작거나, num1값은 5000보다 큽니다");
        }
        if (num2 < -50000 || num2 > 50000) {
            throw new RuntimeException("num2값은  -50000보다 작거나, num2값은 5000보다 큽니다");
        }
        return num1 - num2;
    }

    public int exam120804(int num1, int num2) throws Exception {
        if ( num1 < 0 || num1 > 100 ){
            throw new Exception("num1 값은 0 ~ 100 사이의 값 이어야 합니다");
        }
        if ( num2 < 0 || num2 > 100 ){
            throw new Exception("num2 값은 0 ~ 100 사이의 값 이어야 합니다.");
        }
        return num1 * num2;
    }
    public int mathTest120807(int n1, int n2) throws Exception {
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
    public int exam120820( int age ) throws Exception{
        if ( age <= 0 || age > 120 ){
            throw new Exception("age는 0보다 크고 120보다 작거나 같아야합니다");
        }
        int year = 2022;
        int ans = year - age + 1;

        return ans;
    }
    public int exam120829(int angle) throws Exception{
        if ( angle > 0 && angle < 90 ){
            return 1;
        }
        else if ( angle == 90 ){
            return 2;
        }
        else if ( angle > 90 && angle < 180 ){
            return 3;
        }
        else if ( angle == 180 ){
            return 4;
        }
        else{
            throw new Exception("angle는 1 ~ 180 이어야합니다");
        }
    }
    public int exam120831(int n) throws Exception{
        if ( n <= 1|| n > 1000){
            throw new Exception("n은 1보다 크고 1000보다 작거나 같아야합니다");
        }
        int sum = 0;
        for(int i = 2; i<=n; i+=2){
            sum += i;
        }
        return sum;
    }
    public int exam120583(int[] array, int n) throws Exception{
        int count = 0;
        if ( n < 0 || n > 1000 ){
            throw new Exception("n은 0보다 크거나 같고 1000보다 작거나 같아야합니다");
        }
        if ( array.length < 1 || array.length > 100){
            throw new Exception("array배열의 길이는 1~100사이여야합니다");
        }
        for (int i = 0; i < array.length; i++){
            if (array[i] < 0 || array[i] > 1000 ){
                throw new Exception("array배열의 값은 1~1000사이여야합니다");
            }
            if (array[i] == n){
                count++;
            }
        }
        return count;
    }
    public int[] exam120813(int num) throws Exception{
        int length = (num + 1) / 2;
        int[] k = new int[length];
        if ( num < 1 || num > 100 ){
            throw new Exception("n은 1보다 크거나 같고 100보다 작거나 같아야합니다");
        }
        int ord = 1;
        for (int i = 0; i < length; i ++) {
            k[i] = ord;
            ord += 2;
        }
        return k;
    }
    public int[] exam120819(int money) throws Exception{
        if(money <= 0 || money > 1000000){
            throw new Exception("money은 0보다 크고 1000000보다 작거나 같아야합니다");
        }
        int count = money / 5500;
        int change = money % 5500;
        int[] k = new int[2];
        k[0] = count;
        k[1] = change;
        return k;
    }
    public int exam120585(int[] array, int height) throws Exception{
        int count = 0;
        if (array == null || array.length < 1 || array.length > 100){
            throw new Exception("array는 null이 아니며, array의 길이는 1보다 크거나 같고 100보다 작거나 같아야 합니다");
        }
        if (height < 1 || height > 200){
            throw new Exception("height는 1보다 크거나 같고 200보다 크거나 같아야 합니다");
        }
        for (int i = 0; i < array.length; i++){
            if(array[i]<1 || array[i] > 200){
                throw new Exception("array배열의 원소는 1보다 크거나 같고 200보다 작거나 같아야합니다");
            }
            if(array[i] > height){
                count++;
            }
        }
        return count;
    }

    public int exam120837(int hp) throws Exception{
        if ( hp < 0 || hp > 1000 ){
            throw new Exception("hp는 자연수이며 1000보다 작거나 같아야합니다");
        }
        int a = 0, b = 0, c = 0;
        a = hp / 5 ;
        b = hp % 5 / 3 ;
        c = hp % 5 % 3 ;
        int hap = a + b + c;
        return hap;
    }

    public int exam120818(int price) throws Exception{
        if (price < 10 || price > 1000000) {
            throw new Exception(String.format("[%d]는 10~1,000,000 을 벗어남", price));
        }
        if (!(price % 10 == 0)) {
            throw new Exception("price는 10원 단위여야 합니다.");
        }

        if (price >= 500000) {
            price *= 0.8;
        } else if (price >= 300000) {
            price *= 0.9;
        } else if (price >= 100000) {
            price *= 0.95;
        }

        return (int) price;
    }

    //개미 군단
    public int mathTest120835(int hp) throws Exception {
        if (hp < 1 || hp > 1000) {
            throw new Exception("hp는 1~1000의 값만 가능합니다");
        }

        int jang, byung, il;  //앞에서부터 장군개미, 병정개미, 일개미의 수

        jang = hp / 5;
        byung = 0;
        il = 0;

        if (hp % 5 >= 3) {
            byung = (hp % 5) / 3;
            il = (hp % 5) % 3;
        }
        else{
            il = hp % 5;
        }

        int ans = jang + byung + il;

        return ans;
    }
    public int exam120906(int n) throws Exception{
        if(n < 0 || n > 1000000){
            throw new Exception("n의 값이 0~100만 사이여야 합니다");
        }
        int result = 0;
        int[] sum = new int[7];
        sum[0] = n / 1000000;
        sum[1] = n % 1000000 / 100000;
        sum[2] = n % 100000 / 10000;
        sum[3] = n % 10000 / 1000;
        sum[4] = n % 1000 / 100;
        sum[5] = n % 100 / 10;
        sum[6] = n % 10;

        for(int j = 0; j < 7; j++){
            result += sum[j];
        }

        return result;
    }
    public String exam120839(String rsp) throws Exception{
        if ( rsp == null){
            throw new Exception("rsp 값이 null이 아니어야 합니다");
        }
        if ( rsp.length() <= 0 || rsp.length() > 100 ){
            throw new Exception(String.format("rsp[%s] 문자열의 길이는 1에서 100글자 사이여야 합니다", rsp));
        }
        String result = "";
        for ( int i = 0; i < rsp.length(); i++){
            char ch = rsp.charAt(i);
            if ( ch == '2' ){
                result += "0";
            }else if ( ch == '0' ){
                result += "5";
            }else if ( ch == '5' ){
                result += "2";
            }else{
                throw new Exception(String.format("rsp[%c] 문자는 '2', '0', '5' 중에 하나 이어야 합니다", ch));
            }
        }
        return result;
    }
    /*
    public int exam120891(String order) throws Exception{
        if ( order == null ){
            throw new Exception("order값이 null이 아니어야 합니다");
        }
        int intOrder = Integer.parseInt(order);
        if ( intOrder < 1 || intOrder >= 1000000 ){
            throw new Exception(String.format("order[%s] 값이 1에서 100만 사이여야 합니다", order));
        }
        int count = 0;
        for ( int i = 0; i < order.length(); i++ ){
            char ch = order.charAt(i);
            if ( ch == '3' || ch == '6' || ch == '9'){
                count++;
            }
        }
        return count;
    }
     */

    public int[] exam120899(int[] array) throws Exception{
        int M = 0;
        int i;
        int t = 0;
        if ( array.length < 1 || array.length > 100 ){
            throw new Exception("array 배열의 길이는 1부터 100 사이여야 합니다");
        }
        for ( i = 0; i < array.length; i++){
            if ( array[i] < 0 || array[i] > 1000){
                throw new Exception("array 배열의 원소값이 0에서 1000 사이여야 합니다");
            }
            for(int j = i + 1; j< array.length; j++) {
                if (array[i] == array[j]) {
                    throw new Exception("array배열의 값이 중복이면 안됩니다");
                }
            }
            if ( M < array[i]) {
                M = array[i];
                t = i;
            }
        }
        int[] arr = {M,t};

        return arr;
    }
    public int exam120810(int num1, int num2) throws Exception{
        if (num1 <= 0 || num1 > 100){
            throw new Exception("num1이 1과 100 사이의 숫자여야 합니다");
        }
        if (num2 <= 0 || num2 > 100){
            throw new Exception("num2이 1과 100 사이의 숫자여야 합니다");
        }
        int result = 0;

        result = num1 % num2;

        return result;
    }
    public int exam120806(int num1, int num2) throws Exception{
        if (num1 <= 0 || num1 > 100){
            throw new Exception("num1이 1과 100 사이의 숫자여야 합니다");
        }
        if (num2 <= 0 || num2 > 100){
            throw new Exception("num2이 1과 100 사이의 숫자여야 합니다");
        }
        double result = 0.0d;

        result = (double)num1 / num2;

        int R = (int)(result * 1000);

        return R;
    }
    /*
    public int exam120811(int[] array) throws Exception{
        if ( array.length % 2 == 0 || array.length <= 0 || array.length >= 100){
            throw new Exception("array 배열의 길이는 0에서 100 사이이며 길이는 홀수입니다");
        }
        for ( int i = 0; i < array.length; i++){
            if(array[i] <= -1000 || array[i] >= 1000){
                throw new Exception("array 배열의 원소값은 -1000에서 1000 사이입니다.");
            }
            if(i < array.length - 1) {
                if (array[i] < array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        int leng = (array.length + 1 ) / 2;

        return array[leng - 1];
    }

     */
}
