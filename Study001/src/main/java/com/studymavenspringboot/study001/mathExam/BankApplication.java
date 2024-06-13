package com.studymavenspringboot.study001.mathExam;
import java.util.Scanner;
import java.util.Arrays;

public class BankApplication {
    static Scanner sc = new Scanner(System.in);
    static Account[] AccountArray = new Account[100];
    public static void main(String[] args){

        boolean run = true;
        while(run){
            System.out.println("------------------------------");
            System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
            System.out.print("선택 >> ");
            int i = sc.nextInt();
            if( i == 1 ){
                createAccount();
            }else if( i == 2 ){
                accountList();
            }else if( i == 3 ){
                deposit();
            }else if( i == 4){
                withdraw();
            }else if( i == 5 ){
                run = false;
            }

        }
        System.out.println("프로그램 종료");
    }
    static int i = 0;
    private static void createAccount(){
        System.out.println("------------------------------");
        System.out.println("계좌생성");
        System.out.println("------------------------------");
        System.out.print("계좌번호 : ");
        String num = sc.next();
        System.out.print("계좌주 : ");
        String name = sc.next();
        System.out.print("초기입금액 : ");
        int money = sc.nextInt();
        System.out.println("계좌가 생성되었습니다");
/*
        AccountArray[i] = new Account;

        i++;


 */
    }
    private static void accountList(){
        System.out.println("------------------------------");
        System.out.println("계좌목록");
        System.out.println("------------------------------");
        for(int i = 0; i < AccountArray.length;i++){
            System.out.println(Arrays.toString(new Account[]{AccountArray[i]}));
        }
    }
    private static void deposit(){

    }
    private static void withdraw(){

    }
}
