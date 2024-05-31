package com.studymavenspringboot.study001;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class exam001Test {
    @Test
    public void subtract001() throws Exception{
        assertThat(1001).isGreaterThan(1000);
        //given     테스트하기 위한 준비 동작
        // int num1 = -50001;
        // int num2 = 3;
        // int expected = -50004;

        //when      테스트 실시
        // int actual = subTest001(num1, num2);

        //then      실체값과 기대값을 비교해서 테스트 한다
        /*assertThat(-1).isEqualTo(subTest001(2,3));
        assertThat(98).isEqualTo(subTest001(100, 2));
        assertThat(3).isEqualTo(subTest001(10, 7));
        assertThat(10).isLessThan(subTest001(100, 70));
        assertThat(32).isGreaterThan(subTest001(100, 70));
        //      assertThat(actual).isEqualTo(expected).describedAs("실제값과 다름");

         */
        assertThatThrownBy(() -> subTest001(70000, 7))
                .isInstanceOf(Exception.class);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
                subTest001(2330, 50002);
        });
        System.out.println(exception.toString());
    }
    int subTest001(int n1, int n2) throws Exception{
        if( n1 < -50000 || n1 > 50000){
            throw new Exception("num1 값은 -50001보다 작거나 num1 값은 50000보다 큽니다");
        }
        if( n2 < -50000 || n2 > 50000){
            throw new RuntimeException("num2 값은 -50001보다 작거나 num2 값은 50000보다 큽니다");
        }
        return n1 - n2;
    }
}
