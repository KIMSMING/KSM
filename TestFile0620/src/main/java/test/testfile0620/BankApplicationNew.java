package test.testfile0620;

import java.util.Scanner;

public class BankApplicationNew {
    private AccountService accountService = new AccountService();

    private void printChoice() {
        System.out.println("=============================================");
        System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
        System.out.println("=============================================");
        }
    private static int getChoice(Scanner sc) throws Exception {
        System.out.print("선택 >> ");
        String a = sc.nextLine();
        if(Integer.parseInt(a) < 1 || Integer.parseInt(a) > 5){
            throw new Exception("a의 값은 1에서 5 사이의 숫자여야 합니다");
        }else{
            return Integer.parseInt(a);
        }
    }

    private void creatAccount(Scanner sc) throws Exception {
        System.out.println("--------");
        System.out.println("계좌생성");
        System.out.println("--------");
        System.out.print("계좌번호:");
        String num = sc.nextLine();
        System.out.print("계좌주:");
        String name = sc.nextLine();
        System.out.print("초기금액:");
        String money = sc.nextLine();
        int don = Integer.parseInt(money);
        this.accountService.addAccount(new Account(name, num, don));
    }

    private void printAccounts() {
        for ( Account account : this.accountService.getAllAccount() ) {
            System.out.println(account.toString());
        }
    }

    private void deposite(Scanner sc) throws Exception {
        Account result = getScannerConsole(sc, "예금");
        if ( result == null ) {
            throw new Exception("에러: 계좌가 존재하지 않습니다.");
        }
        if ( this.accountService.deposit(result.getNum(), result.getMoney()) ) {
            System.out.println("결과: 예금이 성공되었습니다.");
        }
    }

    private void withdraw(Scanner sc) throws Exception {
        Account result = getScannerConsole(sc, "출금");
        if ( result == null ) {
            throw new Exception("에러: 계좌가 존재하지 않습니다.");
        }
        if ( this.accountService.withdraw(result.getNum(), result.getMoney()) ) {
            System.out.println("결과: 출금이 성공되었습니다.");
        } else {
            throw new Exception("출금하려는 금액보다 잔액이 적습니다.");
        }
    }

    private Account getScannerConsole(Scanner sc, String title) {
        System.out.println("--------");
        System.out.println(title);
        System.out.println("--------");

        System.out.print("계좌번호:");
        String num = sc.nextLine();
        Account account = this.accountService.findAccountByNumber(num);
        if ( account == null ) {
            return null;
        }
        System.out.print(title + "액:");
        String current = sc.nextLine();
        int money = Integer.parseInt(current);

        return new Account("임시명", num, money);
    }


    public static void main(String[] args) {
        try {
            BankApplicationNew bapp = new BankApplicationNew();
            Scanner sc = new Scanner(System.in);
            boolean run = true;
            while(run) {
                bapp.printChoice();
                int choice = bapp.getChoice(sc);
                switch (choice) {
                    case 1:
                        bapp.creatAccount(sc);
                        break;
                    case 2:
                        bapp.printAccounts();
                        break;
                    case 3:
                        bapp.deposite(sc);
                        break;
                    case 4:
                        bapp.withdraw(sc);
                        break;
                    case 5:
                        run = false;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력하세요");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
