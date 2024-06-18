package test.testfile0620;


import java.util.ArrayList;
import java.util.List;

public class AccountService {
    /**
     * 계좌 배열 인스턴스 변수 (객체 프로퍼티, 인스턴스 필드)
     */
    private List<Account> accountarray = new ArrayList<>();
    /**
     * 계좌 배열 길이를 int 형으로 리턴한다.
     * return Accounts array size (int)
     * @return : Accounts array size (int)
     */
    public int size() {
        return this.accountarray.size();
    }
    /**
     * 계좌 목록을 전체 삭제하고 Clear 한다.
     * clear Accounts all array elements. size will be 0.
     */
    public void clear() {
        this.accountarray.clear();
    }

    /**
     * 계좌(Account) 배열에 계좌정보(Account) 를 추가한다.
     * @param name : 계좌대표이름
     * @param num : 계좌번호
     * @param money : 초기금액
     * @return : true or false
     */
    public boolean addAccount(String name, String num, int money) {
        Account account = new Account(name, num, money);
        if(account == null){
            return false;
        }else{
            return this.accountarray.add(new Account(name, num, money));
        }
    }

    /**
     * 계좌(Account) 배열에 계좌정보(Account) 를 추가한다.
     * @param account : 계좌정보 Account 객체
     * @return : true or false
     */
    public boolean addAccount(Account account) {
        return this.accountarray.add(account);
    }

    /**
     * 계좌 배열을 리턴한다.
     * return Accounts Array List
     * @return
     */
    public List<Account> getAllAccount() {
        return this.accountarray;
    }

    /**
     * 계좌번호로 찾은 계좌에 예금을 한다.
     * @param num : 계좌번호
     * @param money : 예금액
     * @return : 성공일때 true, 실패하면 false
     */
    public boolean deposit(String num, int money) {
        Account account = this.findAccountByNumber(num);
        if ( account == null ) {
            return false;
        }
        account.setMoney(account.getMoney() + money);
        return true;
    }

    /**
     * 계좌번호로 찾은 계좌에 출금을 한다. 현재금액보다 출금액은 커야 한다.
     * @param num : 계좌번호
     * @param money : 출금액
     * @return : 성공일때 true, 실패하면 false
     */
    public boolean withdraw(String num, int money) {
        Account account = this.findAccountByNumber(num);
        if ( account == null ) {
            return false;
        }
        if ( account.getMoney() >= money ) {
            account.setMoney(account.getMoney() - money);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 계좌번호로 계좌(Account)를 찾아서 리턴한다. 계좌번호가 없으면 null 을 리턴한다.
     * @param num : 찾을 계좌번호
     * @return : Account 객체, 찾지 못하면 null
     */
    public Account findAccountByNumber( String num ) {
        if ( num == null || num.isEmpty() ) {
            return null;
        }
        for ( Account account : accountarray) {
            if ( num.equals(account.getNum()) ) {
                return account;
            }
        }
        return null;
    }
}
