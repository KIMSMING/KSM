package jsonexample.jsonexample;

import java.util.Scanner;

public class BankApplication {
    private AccountService accountService = new AccountService();
    private AccountRepository accountRepository;

    public BankApplication(AccountRepository repository) {
        this.accountRepository =  repository;
    }

    private void printHeader() {
        System.out.println("=====================================");
        System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
        System.out.println("=====================================");
    }

    private int getChoice(Scanner input) throws Exception {
        System.out.print("선택 > ");
        String a = input.nextLine();
        return Integer.parseInt(a);
    }

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
        this.saveFile();
    }

    private void printAccounts() {
        for (Account account : this.accountService.getAllAccount()) {
            System.out.println(account.toString());
        }
    }

    private void income(Scanner input) throws Exception {
        Account result = getInputConsole(input, "예금");
        if (result == null) {
            System.out.println("에러: 계좌가 존재하지 않습니다.");
            return;
        }
        if (this.accountService.deposit(result.getBankNumber(), result.getCurrent())) {
            this.saveFile();
            System.out.println("결과: 예금이 성공되었습니다.");
        }
    }

    private void outcome(Scanner input) throws Exception {
        Account result = getInputConsole(input, "출금");
        if (result == null) {
            System.out.println("에러: 계좌가 존재하지 않습니다.");
            return;
        }
        if (this.accountService.withdraw(result.getBankNumber(), result.getCurrent())) {
            this.saveFile();
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
        if (account == null) {
            return null;
        }
        System.out.print(title + "액:");
        String current = input.nextLine();
        int money = Integer.parseInt(current);

        return new Account("임시명", bankNumber, money);
    }

    private void loadFile() throws Exception {
        accountRepository.loadJson(accountService.getAllAccount());
    }

    private void saveFile() throws Exception {
        accountRepository.saveJson(accountService.getAllAccount());
    }

    public static void main(String[] args) {
        if ( args.length < 1 ) {
            System.out.println("execute BankApplication -j or -t");
            return;
        }
        AccountRepository repository;
        if ( "-j".equals(args[0]) ) {
            repository = new AccountJSONRepository();
        } else if ( "-t".equals(args[0]) ) {
            repository = new AccountFileRepository();
        } else {
            System.out.println("execute BankApplication -j or -t");
            return;
        }
        BankApplication bapp = new BankApplication(repository);
        Scanner input = new Scanner(System.in);
        boolean run = true;

        try {
            bapp.loadFile();
        } catch (Exception e) {
            throw new RuntimeException("File Open Error !");
        }
        while (run) {
            try {
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
                    default:
                        System.out.println("!!! 잘못된 입력입니다. !!!");
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}