package test.testfile0620;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    public Account(){
        this.name = "";
        this.num = "";
    }

    private String name;
    private String num;
    private int money;

    /**
     * 계좌 (Account) 를 생성하는 사용자 정의 생성자
     * @param name : 계좌 대표명
     * @param num : 계좌번호
     * @param money : 현재 금액
     */

    public Account(String name, String num, int money) {
        this.name = name;
        this.num = num;
        this.money = money;
    }

    /**
     * 계좌(Account) 정보(계좌대표명, 계좌번호, 현재금액)를 String 으로 리턴한다.
     * @return
     */

    @Override
    public String toString() {
        return String.format("성함 : '%s', 계좌번호 : '%s', 잔금 : %d"
            , this.name, this.num, this.money);
    }
}
