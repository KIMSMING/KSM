package com.studymavenspringboot.study001.mathExam;

import lombok.Getter;
import lombok.Setter;

public class Account {
    private String num;
    private String name;
    private int money;

    public Account(String num, String name, int money) {
        this.num = num;
        this.name = name;
        this.money = money;
    }


    public String getNum(){
            return num;
        }
        public void setNum(String num){
            this.num = num;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
        public int getMoney(){
            return money;
        }
        public void setMoney(int money){
            this.money = money;
        }
     /*
    static final int MIN_BALANCE = 0;
    static final int MAX_BALANCE = 1000000;
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if(balance >= MIN_BALANCE && balance <= MAX_BALANCE){
            this.balance = balance;
        }
    }
    */
}
