package com.studymavenspringboot.study001;

import com.studymavenspringboot.study001.mathExam.MathExam;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

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
        assertThatThrownBy(() -> math.exam120803(70000, 7))
                .isInstanceOf(Exception.class);
        Throwable exception = assertThrows(RuntimeException.class, () -> {
                math.exam120803(2330, 50002);
        });
    }
    public void multiply001() throws Exception{
        // given
        MathExam math = new MathExam();

        // when

        // then
        assertThat(math.exam120804(3,4)).isEqualTo(12);
        assertThat(math.exam120804(27, 19)).isEqualTo(513);
        assertThatThrownBy(() -> math.exam120804(-1, 10))
                .isInstanceOf(Exception.class);
        assertThatThrownBy(() -> math.exam120804(-1, 10))
                .isInstanceOf(Exception.class);


    }
    public void comparison() throws Exception{
        //given
        MathExam math = new MathExam();

        //when

        //then
        assertThat(math.exam120804(2,3)).isEqualTo(-1);
        assertThat(math.exam120804(11,11)).isEqualTo(1);
        assertThat(math.exam120804(7,99)).isEqualTo(-1);
        assertThatThrownBy(() -> math.mathTest120807(-1, 10))
                .isInstanceOf(Exception.class);
        assertThatThrownBy(() -> math.mathTest120807(-1, 10))
                .isInstanceOf(Exception.class);

    }


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
    public void exam120820() throws Exception{
        System.out.println("exam120820");
        MathExam math = new MathExam();
        assertThat(math.exam120820(40)).isEqualTo(1983);
        assertThat(math.exam120820(23)).isEqualTo(2000);

        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120820(0));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120820(121));
        System.out.println(ex2.toString());
    }
    @Test
    public void exam120829() throws Exception{
        System.out.println("exam120829");
        MathExam math = new MathExam();
        assertThat(math.exam120829(70)).isEqualTo(1);
        assertThat(math.exam120829(90)).isEqualTo(2);
        assertThat(math.exam120829(91)).isEqualTo(3);
        assertThat(math.exam120829(180)).isEqualTo(4);
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120829(0));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120829(181));
        System.out.println(ex2.toString());
    }
    @Test
    public void exam120831() throws Exception{
        System.out.println("exam120831");
        MathExam math = new MathExam();
        assertThat(math.exam120831(10)).isEqualTo(30);
        assertThat(math.exam120831(4)).isEqualTo(6);
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120831(0));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120831(1001));
        System.out.println(ex2.toString());
    }
    @Test
    public void exam120583() throws Exception{
        System.out.println("exam120583");
        MathExam math = new MathExam();
        assertThat(math.exam120583(new int[]{1, 1, 2, 3, 4, 5}, 1)).isEqualTo(2);
        assertThat(math.exam120583(new int[]{0, 2, 3, 4}, 1)).isEqualTo(0);
        Throwable exception = assertThrows(Exception.class, () -> {
            math.exam120583(new int[]{0, 1000, 2000}, 12);
        });
    }
    public void exam120813() throws Exception{
        System.out.println("exam120813");
        MathExam math = new MathExam();
        assertThat(math.exam120813(10)).isEqualTo((new int[]{1, 3, 5, 7, 9}));
        assertThat(math.exam120813(15)).isEqualTo((new int[]{1, 3, 5, 7, 9, 11, 13, 15}));
    }
    @Test
    public void exam120819() throws Exception{
        System.out.println("exam120819");
        MathExam math = new MathExam();
        assertThat(math.exam120819(5500)).isEqualTo((new int[]{1, 0}));
        assertThat(math.exam120819(15000)).isEqualTo((new int[]{2, 4000}));
    }
    @Test
    public void exam120585() throws Exception{
        System.out.println("exam120585");
        MathExam math = new MathExam();
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120585(new int[]{}, 150));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120585(new int[]{150, 201}, 130));
        System.out.println(ex2.toString());
        Throwable ex3 = assertThrows(Exception.class, () -> math.exam120585(new int[]{150, 180}, 201));
        System.out.println(ex3.toString());

        assertThat(math.exam120585(new int[]{149, 180, 192, 170}, 167)).isEqualTo(3);
        assertThat(math.exam120585(new int[]{180, 120, 140}, 190)).isEqualTo(0);
    }

    @Test
    public void exam120837() throws Exception{
        System.out.println("exam120837");
        MathExam math = new MathExam();
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120837(-1));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120837(1001));
        System.out.println(ex2.toString());

        assertThat(math.exam120837(23)).isEqualTo(5);
        assertThat(math.exam120837(24)).isEqualTo(6);
        assertThat(math.exam120837(999)).isEqualTo(201);
    }
}
