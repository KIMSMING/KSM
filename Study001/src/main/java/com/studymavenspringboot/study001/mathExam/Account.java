package com.studymavenspringboot.study001.mathExam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private String name;
    private String bankNumber;
    private int current;

    public Account(String name, String bankNumber, int current) {
        this.name = name;
        this.bankNumber = bankNumber;
        this.current = current;
    }

    @Override
    public String toString() {
        return String.format("Account{name='%s', bankNumber='%s', current=%d}"
                , this.name, this.bankNumber, this.current);
    }
}
// import lombok.Getter;
// import lombok.Setter;
//
// public class Account {
//     @Setter
//     @Getter
//     private String num;
//     @Setter
//     @Getter
//     private String name;
//     @Setter
//     @Getter
//     private int money;
//
//     public Account(String num, String name, int money) {
//         this.num = num;
//         this.name = name;
//         this.money = money;
//     }
//
//
//     private static final int MIN_BALANCE = 0;
//     private static final int MAX_BALANCE = 1000000;
//     private int balance;
//
//     public int getBalance() {
//         return balance;
//     }
//
//     public void setBalance(int balance) {
//         if(balance >= MIN_BALANCE && balance <= MAX_BALANCE){
//             this.balance = balance;
//         }
//     }

