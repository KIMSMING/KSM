package jsonexample.jsonexample;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private String name;
    private String bankNumber;
    private int current;

    /**
     * 계좌 (Account) 기본 생성자
     */
    public Account() {
        this.name = "";
        this.bankNumber = "";
        this.current = 0;
    }

    /**
     * 계좌 (Account) 를 생성하는 사용자 정의 생성자
     * @param name : 계좌 대표명
     * @param bankNumber : 계좌번호
     * @param current : 현재 금액
     */
    public Account(String name, String bankNumber, int current) {
        this.name = name;
        this.bankNumber = bankNumber;
        this.current = current;
    }

    /**
     * 계좌(Account) 정보(계좌대표명, 계좌번호, 현재금액)를 String 으로 리턴한다.
     * @return
     */
    @Override
    public String toString() {
        return String.format("Account{name='%s', bankNumber='%s', current=%d}"
                , this.name, this.bankNumber, this.current);
    }
}