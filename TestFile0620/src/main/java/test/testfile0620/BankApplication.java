package test.testfile0620;

import java.util.Scanner;

public class BankApplication {
    private AccountService accountService = new AccountService();

    public void printChoice() {
        System.out.println("=============================================");
        System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
        System.out.println("=============================================");
        }
    public static int getChoice(Scanner sc) throws Exception {
        System.out.print("선택 >> ");
        String a = sc.nextLine();
        if( Integer.parseInt(a) < 1 || Integer.parseInt(a) > 5 || a.equals("")){
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
        System.out.print("계좌주 : ");
        String name = sc.nextLine();
        System.out.print("초기금액 : ");
        String money = sc.nextLine();
        int don = Integer.parseInt(money);
        if ( num == null ){
            throw new Exception("계좌번호를 입력해야 합니다");
        }
        if ( name ==  null ){
            throw new Exception("이름을 입력해야합니다");
        }
        if ( don < 0 || money == null ){
            throw new Exception("초기금액은 음수일 수 없습니다.");
        }
        this.accountService.addAccount(new Account(name, num, don));
    }

    private void printAccounts(){
        for ( Account account : this.accountService.getAllAccount() ) {
            System.out.println(account.toString());
        }
    }

    private void deposite(Scanner sc) throws Exception {
        Account result = getScannerConsole(sc, "예금");
        if ( result == null){
            return;
        }
        if ( this.accountService.deposit(result.getNum(), result.getName(), result.getMoney()) ) {
            System.out.println("결과: 예금이 성공되었습니다.");
        }
    }

    private void withdraw(Scanner sc) throws Exception {
        Account result = getScannerConsole(sc, "출금");
        if ( result == null ){
            return;
        }
        if ( this.accountService.withdraw(result.getNum(), result.getName(), result.getMoney()) ) {
            System.out.println("결과: 출금이 성공되었습니다.");
        }
    }

    private Account getScannerConsole(Scanner sc, String title) throws Exception {
        System.out.println("--------");
        System.out.println(title);
        System.out.println("--------");

        System.out.print("계좌번호 : ");
        String num = sc.nextLine();
        System.out.print("계좌주 : ");
        String name = sc.nextLine();
        Account account = this.accountService.findAccountByNumberAndName(num, name);
        if (account == null) {
            return null;
        }
        System.out.print(title + "액 : ");
        String current = sc.nextLine();
        int money = Integer.parseInt(current);

        return new Account(name, num, money);
    }


    public static void main(String[] args) {
        try {
            BankApplication BApp = new BankApplication();
            Scanner sc = new Scanner(System.in);
            boolean run = true;
            while(run) {
                BApp.printChoice();
                int choice = getChoice(sc);
                switch (choice) {
                    case 1:
                        BApp.creatAccount(sc);
                        break;
                    case 2:
                        BApp.printAccounts();
                        break;
                    case 3:
                        BApp.deposite(sc);
                        break;
                    case 4:
                        BApp.withdraw(sc);
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
