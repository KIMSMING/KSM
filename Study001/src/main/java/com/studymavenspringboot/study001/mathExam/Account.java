package com.studymavenspringboot.study001.mathExam;

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

}
