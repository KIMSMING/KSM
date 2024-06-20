package test.testfile0620;


import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private List<Account> accountarray = new ArrayList<>();

    public int size() {
        return this.accountarray.size();
    }

    public void clear() {
        this.accountarray.clear();
    }

    public boolean addAccount(String name, String num, int money) {
        if (name == null || num == null || money < 0) {
            System.out.print("유효하지 않은 입력값입니다.");
            return false;
        } else{
            return this.accountarray.add(new Account(name, num, money));
        }
    }

    public boolean addAccount(Account account) {
        return this.accountarray.add(account);
    }

    public List<Account> getAllAccount() {
        return this.accountarray;
    }

    public boolean deposit(String num, String name, int money) {
        Account account = this.findAccountByNumberAndName(num, name);
        if ( account == null ) {
            return false;
        }
        if ( money <= 0 ){
            System.out.println("예금하려는 금액은 0보다 커야합니다");
            return false;
        }
        account.setMoney(account.getMoney() + money);
        return true;
    }

    public boolean withdraw(String num,String name, int money) {
        Account account = this.findAccountByNumberAndName(num, name);
        if ( account == null ) {
            System.out.print("출금하려는 계좌번호를 적으셔야합니다.");
            return false;
        }
        if ( account.getMoney() >= money ) {
            account.setMoney(account.getMoney() - money);
            return true;
        } else {
            System.out.println("잔액이 부족합니다");
            return false;
        }
    }

    public Account findAccountByNumberAndName(String num, String name) {
        if (num == null || num.isEmpty() || name == null || name.isEmpty()) {
            System.out.println("계좌번호와 계좌주 이름을 입력해야 합니다.");
            return null;
        }
        for (Account account : accountarray) {
            if (num.equals(account.getNum())) {
                if (name.equals(account.getName())) {
                    return account;
                } else {
                    System.out.println("계좌번호는 맞지만 계좌주가 일치하지 않습니다.");
                    return null;
                }
            }
        }
        System.out.println("찾으시는 계좌번호가 존재하지 않습니다.");
        return null;
    }

}
