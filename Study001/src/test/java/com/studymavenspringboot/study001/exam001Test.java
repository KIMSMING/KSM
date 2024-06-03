package com.studymavenspringboot.study001;

import com.studymavenspringboot.study001.mathExam.MathExam;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class exam001Test {
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
        /*
        assertThat(subTest001(2,3)).isEqualTo(-1);
        assertThat(subTest001(100, 2)).isEqualTo(98);
        assertThat(subTest001(10, 7)).isEqualTo(3);
        assertThat(subTest001(100, 70)).isGreatThan(10);
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
        assertThat(math.mathTest002(3,4)).isEqualTo(12);
        assertThat(math.mathTest002(27, 19)).isEqualTo(513);
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
        assertThat(math.mathTest002(2,3)).isEqualTo(-1);
        assertThat(math.mathTest002(11,11)).isEqualTo(1);
        assertThat(math.mathTest002(7,99)).isEqualTo(-1);
        assertThatThrownBy(() -> math.mathTest003(-1, 10))
                .isInstanceOf(Exception.class);
        assertThatThrownBy(() -> math.mathTest003(-1, 10))
                .isInstanceOf(Exception.class);

    }

    @Test
    public void exam120817() throws Exception {
        MathExam math = new MathExam();
        assertThat(math.exam120817(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})).isEqualTo(5.5);
        assertThat(math.exam120817(new int[]{89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99})).isEqualTo(94.0);
        //  assertThatThrownBy(() -> math.exam120817(new int[] {0, 1000, 2000}))
        //         .isInstanceOf(Exception.class);

        Throwable exception = assertThrows(Exception.class, () -> {
            math.exam120817(new int[]{0, 1000, 2000});
        });
        System.out.println(exception.toString());
        //     assertThatThrownBy(() -> math.exam120817(new int[] {}))
        //         .isInstanceOf(Exception.class);
        exception = assertThrows(Exception.class, () -> math.exam120817(new int[] {}));
        System.out.println(exception.toString());
    }
}
