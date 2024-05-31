package com.studymavenspringboot.study001;

import com.studymavenspringboot.study001.mathExam.MathExam;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class exam001Test {
    @Test
    public void subtract001() throws Exception{
        assertThat(1001).isGreaterThan(1000);
        //given     테스트하기 위한 준비 동작
        MathExam math = new MathExam();
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
        assertThatThrownBy(() -> math.subTest001(70000, 7))
                .isInstanceOf(Exception.class);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
                math.subTest001(2330, 50002);
        });
    }
    public void multiply001() throws Exception{
        // given
        MathExam math = new MathExam();

        // when

        // then
        assertThat(12).isEqualTo(math.mathTest002(3,4));
        assertThat(513).isEqualTo(math.mathTest002(27, 19));
        assertThatThrownBy(() -> math.mathTest002(-1, 10))
                .isInstanceOf(Exception.class);
        assertThatThrownBy(() -> math.mathTest002(-1, 10))
                .isInstanceOf(Exception.class);


    }
    public void comparison() throws Exception{
        //given
        MathExam math = new MathExam();

        //when

        //then
        assertThat(-1).isEqualTo(math.mathTest002(2,3));
        assertThat(1).isEqualTo(math.mathTest002(11,11));
        assertThat(-1).isEqualTo(math.mathTest002(7,99));
        assertThatThrownBy(() -> math.mathTest003(-1, 10))
                .isInstanceOf(Exception.class);
        assertThatThrownBy(() -> math.mathTest003(-1, 10))
                .isInstanceOf(Exception.class);

    }

}
