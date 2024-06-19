package test.testfile0620;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountServiceTests {

    @Test
    public void findAccountByNumberAndNameTest() {
        AccountService accountService = new AccountService();
        Account account = accountService.findAccountByNumberAndName(null, null);
        assertThat(account).isNull();

        accountService.addAccount("홍길동", "111-111", 20000);
        account = accountService.findAccountByNumberAndName("111-111", "홍길동");
        assertThat(account).isNotNull();
    }

    @Test
    public void addAccountTest() {
        AccountService accountService = new AccountService();

        accountService.clear();
        accountService.addAccount("홍길동", "111-111", 20000);

        assertThat(accountService.size()).isEqualTo(1);

        Account find = accountService.findAccountByNumberAndName("111-111", "홍길동");
        assertThat(find).isNotNull();
        assertThat(find.getName()).isEqualTo("홍길동");
        assertThat(find.getMoney()).isEqualTo(20000);
    }

    @Test
    public void depositTest() {
        AccountService accountService = new AccountService();
        accountService.addAccount("홍길동", "111-111", 20000);
        accountService.addAccount("이순신", "222-222", 30000);
        assertThat(accountService.size()).isEqualTo(2);

        boolean result = accountService.deposit("222-222", "이순신", 10000);
        assertThat(result).isEqualTo(true);

        Account find = accountService.findAccountByNumberAndName("222-222", "이순신");
        assertThat(find).isNotNull();
        assertThat(find.getMoney()).isEqualTo(40000);

        Account find2 = accountService.findAccountByNumberAndName("444-444", "홍길동");
        assertThat(find2).isNull();

        Account find3 = accountService.findAccountByNumberAndName("123-231", "홍길동");
        assertThat(find3).isNull();

        boolean result2 = accountService.deposit("222-222", "이순신", -10000);
        assertThat(result2).isEqualTo(false);

        boolean result3 = accountService.deposit(null, "이순신", 10000);
        assertThat(result3).isEqualTo(false);
    }

    @Test
    public void withdrawTest() {
        AccountService accountService = new AccountService();
        accountService.addAccount("홍길동", "333-333", 40000);
        assertThat(accountService.size()).isEqualTo(1);

        boolean result = accountService.withdraw("333-333", "홍길동", 20000);
        assertThat(result).isEqualTo(true);

        Account find = accountService.findAccountByNumberAndName("333-333", "홍길동");
        assertThat(find).isNotNull();
        assertThat(find.getMoney()).isEqualTo(20000);

        Account find2 = accountService.findAccountByNumberAndName("555-555", "홍길동");
        assertThat(find2).isNull();

        boolean result2 = accountService.withdraw("333-333", "홍길동", 30000);
        assertThat(result2).isEqualTo(false);

        Account find3 = accountService.findAccountByNumberAndName("333-333", "홍길동");
        assertThat(find3).isNotNull();
        assertThat(find3.getMoney()).isEqualTo(20000);

        boolean result3 = accountService.withdraw("333-333", "홍길동", 50000);
        assertThat(result3).isEqualTo(false);
    }
}
