package test.testfile0620;


import java.util.ArrayList;
import java.util.Scanner;

public class BankApplicationOld {
    private ArrayList<Account> arrayList = new ArrayList<>();

    private void printHeader() {
        System.out.println("========================================================");
        System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료|6.파일읽기|7.파일저장");
        System.out.println("========================================================");
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
        this.arrayList.add(new Account(name, bankNumber, money));
    }

    private void printAccounts() {
        for ( Account account : this.arrayList ) {
            System.out.println(account.toString());
        }
//        for ( int i = 0; i < this.arrayList.size(); i++ )
//            System.out.println(this.arrayList.get(i).toString());
//        }
    }

    private void income(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("예금");
        System.out.println("--------");

        System.out.print("계좌번호:");
        String bankNumber = input.nextLine();
        System.out.print("예금액:");
        String current = input.nextLine();
        int money = Integer.parseInt(current);
        for ( Account account : this.arrayList ) {
            if ( bankNumber.equals(account.getNum()) ) {
                account.setMoney( account.getMoney() + money );
                System.out.println("결과: 예금이 성공되었습니다.");
                break;
            }
        }
    }

    private void outcome(Scanner input) throws Exception {
        System.out.println("--------");
        System.out.println("출금");
        System.out.println("--------");

        System.out.print("계좌번호:");
        String bankNumber = input.nextLine();
        System.out.print("출금액:");
        String current = input.nextLine();
        int money = Integer.parseInt(current);
        for ( Account account : this.arrayList ) {
            if ( bankNumber.equals(account.getNum()) ) {
                account.setMoney( account.getMoney() - money );
                System.out.println("결과: 출금이 성공되었습니다.");
                break;
            }
        }
    }


    public static void main(String[] args) {
        try {
            BankApplicationOld bapp = new BankApplicationOld();
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
