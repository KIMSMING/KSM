package com.studymavenspringboot.study001.mathExam;
import java.util.Scanner;
public class BankApplication {
    static Scanner sc = new Scanner(System.in);
    static Account[] accountArray = new Account[100];
    static int t = 0, x = 0;
    public static void main(String[] args){
        boolean run = true;
        while(run){
            System.out.println("--------------------------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료 | 6.파일읽기 | 7.파일저장");
            System.out.println("--------------------------------------------------------------------");

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

    private static void createAccount(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("계좌생성");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("계좌번호 : ");
        String num = sc.next();
        System.out.print("계좌주 : ");
        String name = sc.next();
        System.out.print("초기입금액 : ");
        int money = sc.nextInt();
        System.out.println("계좌가 생성되었습니다");
        Account newAccount = new Account(num, name, money);
        accountArray[t] = newAccount;
        t++;
    }

    private static void accountList(){
        System.out.println("------------------------------");
        System.out.println("계좌목록");
        System.out.println("------------------------------");
        for(int j = 0; j < t;j++){
            Account account = accountArray[j];
            if( account != null){
                System.out.println(account.getNum() + "   " + account.getName() + "   " + account.getMoney());
            }
        }
    }
    private static void deposit(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("예금");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("계좌번호: ");
        String num = sc.next();
        System.out.print("예금액: ");
        int money = sc.nextInt();
        for(int j = 0; j < t; j++){
            Account account = accountArray[j];
            if(account.getNum().equals(num)){
                x = account.getMoney();
                x += money;
                accountArray[j].setMoney(x);
                System.out.println(accountArray[j].getMoney());
            }
        }
    }

    private static void withdraw(){
        System.out.println("--------------------------------------------------------------------");
        System.out.println("출금");
        System.out.println("--------------------------------------------------------------------");
        System.out.print("계좌번호: ");
        String num = sc.next();
        System.out.print("출금액: ");
        int money = sc.nextInt();
        for(int j = 0; j < t; j++){
            Account account = accountArray[j];
            if(account.getNum().equals(num)){
                if(account.getMoney() < money) {
                    System.out.println("결과 : 출금이 실패했습니다");
                    return;
                }else{
                    x = account.getMoney();
                    x -= money;
                    accountArray[j].setMoney(x);
                    System.out.println("결과 : 출금이 성공했습니다");
                    System.out.println(accountArray[j].getMoney());
                }
            }
        }
    }
}
