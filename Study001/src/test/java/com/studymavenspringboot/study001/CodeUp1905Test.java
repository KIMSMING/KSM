package com.studymavenspringboot.study001;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CodeUp1905Test {
//    @Test
//    public void testAddRecursive(){
//        assertThat(this.addDecRecursive(-1)).isEqualTo(0);
//        assertThat(this.addDecRecursive(0)).isEqualTo(0);
//        assertThat(this.addDecRecursive(1)).isEqualTo(1);
//        assertThat(this.addDecRecursive(5)).isEqualTo(15);
//        assertThat(this.addDecRecursive(10)).isEqualTo(55);
//
//        assertThat(this.addIncRecursive(1, -1)).isEqualTo(0);
//        assertThat(this.addIncRecursive(1, 0)).isEqualTo(0);
//        assertThat(this.addIncRecursive(1, 1)).isEqualTo(1);
//        assertThat(this.addIncRecursive(1, 5)).isEqualTo(15);
//        assertThat(this.addIncRecursive(1, 10)).isEqualTo(55);
//
//    }
//    private int addDecRecursive(int n){
//        if ( n <= 0 ){
//            return 0;
//        }
//        return n + addDecRecursive( n - 1 );
//    }
//    private int addIncRecursive(int s, int n){
//        if ( n <= 0 ){
//            return 0;
//        }else if ( s > n){
//            return 0;
//        }else if ( s == n ){
//            return 1;
//        }
//        return s + addIncRecursive(s + 1, n) ;
//    }
    @Test
    public void testPibonachi(){
        assertThat(this.Pibonachi(7)).isEqualTo(13);
        assertThat(this.Pibonachi(201)).isEqualTo(0);
        assertThat(this.Pibonachi(0)).isEqualTo(0);
        assertThat(this.Pibonachi(3)).isEqualTo(2);
        assertThat(this.Pibonachi(8)).isEqualTo(21);
        assertThat(this.Pibonachi(10)).isEqualTo(55);
//        assertThat(this.Pibonachi(200)).isEqualTo(5227);

    }
    private int Pibonachi(int N){
        if ( N <= 0 ){
            return 0;
        }else if( N > 200 ){
            return 0;
        }else if ( N <= 1 ){
            return N;
        }
        return Pibonachi(N - 1) + Pibonachi(N - 2);
    }

    @Test
    public void testPasCar(){

    }
    private int PasCar(int r, int c){
        return 0;
    }
    @Test
    public void testUPacSu(){
        assertThat(this.PacSu(1, 10)).isEqualTo(9);

    }
    private int PacSu(int a, int b){
        if ( a % 2 == 1){
            a = 3 * a + 1;
        }else if ( a % 2 == 0){
            a = a / 2;
        }
        if ( a == 1 ){
            return a;
        }
        int cnt1 = 0;
        cnt1++;

        if ( b % 2 == 1){
            b = 3 * b + 1;
        }else if ( b % 2 == 0){
            b = b / 2;
        }
        if ( b == 1 ){
            return b;
        }
        int cnt2 = 0;
        cnt2++;

        if ( cnt1 == cnt2){
            if ( a < b ) {
                return PacSu(a, cnt1);
            }
            else return PacSu(b, cnt2);
        }else if ( cnt1 < cnt1) {
            return PacSu(a, cnt1);
        }else{
            return PacSu(b, cnt2);
        }
    }
}
