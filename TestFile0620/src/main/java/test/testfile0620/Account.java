package test.testfile0620;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private Account(){
        this.name = "";
        this.num = "";
    }

    private String name;
    private String num;
    private int money;

    public Account(String name, String num, int money) {
        this.name = name;
        this.num = num;
        this.money = money;
    }

    @Override
    public String toString() {
        return String.format("성함 : '%s', 계좌번호 : '%s', 잔금 : %d", this.name, this.num, this.money);
    }
}
