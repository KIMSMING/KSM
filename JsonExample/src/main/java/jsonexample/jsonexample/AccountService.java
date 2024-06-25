package jsonexample.jsonexample;

import java.util.ArrayList;
import java.util.List;

public interface AccountService {
    int size();
    void clear();
    boolean addAccount(String name, String bankAccount, int money);
    boolean addAccount(Account account);
    List<Account> getAllAccount();
    boolean deposit(String bankAccount, int money);
    boolean withdraw(String bankAccount, int money);
    Account findAccountByNumber( String bankAccount );
    void loadData(List<Account> list) throws Exception;
    void saveData(List<Account> list) throws Exception;
}