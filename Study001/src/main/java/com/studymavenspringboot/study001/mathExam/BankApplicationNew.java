package com.studymavenspringboot.study001.mathExam;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class BankApplicationNew {
    private AccountService accountService = new AccountService();

    /**
     * 사용할 목록 출력
     */
    private void printHeader() {
        System.out.println("========================================================");
        System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료|6.파일읽기|7.파일저장");
        System.out.println("========================================================");
    }

    /**
     * 선택할 번호 출력
     * @param input
     * @return
     * @throws Exception
     */
    private int getChoice(Scanner input) throws Exception {
        System.out.print("선택 > ");
        String a = input.nextLine();
        return Integer.parseInt(a);
    }

    /**
     * 계좌번호 입력칸 출력
     * @param input
     * @throws Exception
     */
    private void addAccount(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("계좌생성");
        System.out.println("--------");

        System.out.print("계좌번호:");
        String bankNumber = input.nextLine();
        System.out.print("계좌주:");
        String name = input.nextLine();
        System.out.print("초기입금액:");
        String current = input.nextLine();
        int money = Integer.parseInt(current);

        this.accountService.addAccount(new Account(name, bankNumber, money));
    }

    /**
     * 입력했던 계좌번호 출력
     */
    private void printAccounts() {
        for ( Account account : this.accountService.getAllAccount() ) {
            System.out.println(account.toString());
        }
    }

    /**
     * 예금
     * @param input
     * @throws Exception
     */
    private void income(Scanner input) throws Exception {
        Account result = getInputConsole(input, "예금");
        if ( result == null ) {
            System.out.println("에러: 계좌가 존재하지 않습니다.");
            return;
        }
        if ( this.accountService.deposit(result.getBankNumber(), result.getCurrent()) ) {
            System.out.println("결과: 예금이 성공되었습니다.");
        }
    }

    /**
     * 출금
     * @param input
     * @throws Exception
     */
    private void outcome(Scanner input) throws Exception {
        Account result = getInputConsole(input, "출금");
        if ( result == null ) {
            System.out.println("에러: 계좌가 존재하지 않습니다.");
            return;
        }
        if ( this.accountService.withdraw(result.getBankNumber(), result.getCurrent()) ) {
            System.out.println("결과: 출금이 성공되었습니다.");
        } else {
            System.out.println("에러: 출금이 안되었습니다.");
        }
    }

    private Account getInputConsole(Scanner input, String title) {
        System.out.println("--------");
        System.out.println(title);
        System.out.println("--------");

        System.out.print("계좌번호:");
        String bankNumber = input.nextLine();
        Account account = this.accountService.findAccountByNumber(bankNumber);
        if ( account == null ) {
            return null;
        }
        System.out.print(title + "액:");
        String current = input.nextLine();
        int money = Integer.parseInt(current);

        return new Account("임시명", bankNumber, money);
    }

    private void loadJson(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("파일읽기");
        System.out.println("--------");

        System.out.print("파일이름:");
        String fileName = input.nextLine();

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(fileName, Charset.defaultCharset());
        Object jobj = parser.parse(reader);

        JSONObject jsonObject = (JSONObject) jobj;
        reader.close();
        System.out.print(jsonObject);

        JSONArray jsonArray = (JSONArray) jsonObject.get("accounts");
        this.accountService.clear();
        for ( Object obj : jsonArray ) {
            JSONObject element = (JSONObject)obj;
            String name = (String) element.get("name");
            String bankAccount = (String) element.get("bankAccount");
            Long current = (Long) element.get("current");
            this.accountService.addAccount(new Account(name, bankAccount, current.intValue()));
        }
    }

    private void saveJson(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("파일저장");
        System.out.println("--------");

        System.out.print("파일이름:");
        String fileName = input.nextLine();

        JSONArray jsonArray = new JSONArray();
        for ( Account account : this.accountService.getAllAccount() ) {
            JSONObject jobj = new JSONObject();
            jobj.put("name", account.getName());
            jobj.put("bankAccount", account.getBankNumber());
            jobj.put("current", account.getCurrent());
            jsonArray.add(jobj);
        }
        JSONObject jroot = new JSONObject();
        jroot.put("accounts", jsonArray);

        FileWriter fileWriter = new FileWriter(fileName, Charset.defaultCharset());
        fileWriter.write(jroot.toString());
        fileWriter.flush();
        fileWriter.close();
    }

    public static void main(String[] args) {
        try {
            BankApplicationNew bapp = new BankApplicationNew();
            Scanner input = new Scanner(System.in);
            boolean run = true;
            while(run) {
                bapp.printHeader();
                int choice = bapp.getChoice(input);
                switch (choice) {
                    case 1:
                        bapp.addAccount(input);
                        break;
                    case 2:
                        bapp.printAccounts();
                        break;
                    case 3:
                        bapp.income(input);
                        break;
                    case 4:
                        bapp.outcome(input);
                        break;
                    case 5:
                        run = false;
                        break;
                    case 6:
                        bapp.loadJson(input);
                        break;
                    case 7:
                        bapp.saveJson(input);
                        break;
                    default:
                        System.out.println("!!! 잘못된 입력입니다. !!!");
                        break;

                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}