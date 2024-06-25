package jsonexample.jsonexample;

import java.util.List;

public interface AccountRepository {
    void loadJson(List<Account> accountList) throws Exception;
    void saveJson(List<Account> accountList) throws Exception;
}