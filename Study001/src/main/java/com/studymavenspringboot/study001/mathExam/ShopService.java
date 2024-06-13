package com.studymavenspringboot.study001.mathExam;

public class ShopService {
    private static ShopService singleton = new ShopService();

    private ShopService(){}

    public static ShopService getInstance(){
        return singleton;
    }
}
