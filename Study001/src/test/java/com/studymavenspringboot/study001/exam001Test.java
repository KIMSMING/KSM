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

    @Test
    public void exam120818() throws Exception{
        System.out.println("exam120818");
        MathExam math=new MathExam();

        assertThat(math.exam120818(150000)).isEqualTo(142500);
        assertThat(math.exam120818(580000)).isEqualTo(464000);
        Throwable exception = assertThrows(Exception.class, () ->math.exam120818(1200000));
        System.out.println(exception.toString());
        Throwable exception2 = assertThrows(Exception.class, () ->math.exam120818(10009));
        System.out.println(exception2.toString());
    }

    @Test
    public void exam120835() throws Exception{
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
    @Test
    public void exam120906() throws Exception{
        System.out.println("exam120906");
        MathExam math = new MathExam();
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120906(-1));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120906(10000001));
        System.out.println(ex2.toString());

        assertThat(math.exam120906(1234)).isEqualTo(10);
        assertThat(math.exam120906(930211)).isEqualTo(16);
    }
    @Test
    public void exam120839() throws Exception{
        System.out.println("exam120839");
        MathExam math = new MathExam();

        Throwable ex = assertThrows(Exception.class, () -> math.exam120839(null));
        System.out.println(ex.toString());
        ex = assertThrows(Exception.class, () -> math.exam120839(""));
        System.out.println(ex.toString());
        ex = assertThrows(Exception.class, () -> math.exam120839("026"));
        System.out.println(ex.toString());
        assertThat(math.exam120839("2")).isEqualTo("0");
        assertThat(math.exam120839("205")).isEqualTo("052");
    }
/*
    @Test
    public void exam120891() throws Exception{
        System.out.println("exam120891");
        MathExam math = new MathExam();

        Throwable ex = assertThrows(Exception.class, () -> math.exam120891(null));
        System.out.println(ex.toString());
        ex = assertThrows(Exception.class, () -> math.exam120891(""));
        System.out.println(ex.toString());
        ex = assertThrows(Exception.class, () -> math.exam120891("0"));
        System.out.println(ex.toString());

        assertThat(math.exam120891("3")).isEqualTo("1");
        assertThat(math.exam120891("29423")).isEqualTo("2");
    }

 */

    @Test
    public void exam120899() throws Exception{
        System.out.println("exam120899");
        MathExam math = new MathExam();

        Throwable ex = assertThrows(Exception.class, () -> math.exam120899(null));
        System.out.println(ex.toString());
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120899(new int[]{}));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120899(new int[]{1001, -1}));
        System.out.println(ex2.toString());
        Throwable ex3 = assertThrows(Exception.class, () -> math.exam120899(new int[]{23, 23, 23}));
        System.out.println(ex3.toString());

        assertThat(math.exam120899(new int[]{1, 8, 3})).isEqualTo(new int[]{8, 1});
        assertThat(math.exam120899(new int[]{9, 10, 11, 8})).isEqualTo(new int[] {11, 2});
    }
    @Test
    public void numberPrint() throws Exception{
        int x = 0b1011, y = 0206, z = 0x2A0F;
        char a = 'A', b = 'B', c = 'C';
        System.out.println(String.format("10진수 : x = %d, y = %d, z = %d", x, y, z));
        System.out.println(String.format("8진수 : x = %o, y = %o, z = %o", x, y, z));
        System.out.println(String.format("16진수 : x = %X, y = %X, z = %X", x, y, z));
        System.out.println(String.format("Char : x = %c, y = %c, z = %c", x, y, z));

        System.out.println(String.format("10진수 : a = %d, b = %d, c = %d", (int)a, (int)b, (int)c));
        System.out.println(String.format("8진수 : a = %o, b = %o, c = %o", (int)a, (int)b, (int)c));
        System.out.println(String.format("16진수 : a = %X, b = %X, c = %X", (long)a, (byte)b, (short)c));
        System.out.println(String.format("Char : a = %c, b = %c, c = %c", a, b, c));

        int value = 1 + 2 + 3;
        String str1 = 1 + 2 + "3";
        String str2 = 1 + "2" + 3;
        String str3 = "1" + 2 + 3;
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

    }
    @Test
    public void exam120810() throws Exception{
        System.out.print("120810");
        MathExam math = new MathExam();
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120810(-1, 12));
        System.out.println(ex1.toString());

        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120810(12, -1));
        System.out.println(ex1.toString());

        Throwable ex3 = assertThrows(Exception.class, () -> math.exam120810(101, 12));
        System.out.println(ex1.toString());

        Throwable ex4 = assertThrows(Exception.class, () -> math.exam120810(23, 103));
        System.out.println(ex4.toString());

        assertThat(math.exam120810(3, 2)).isEqualTo(1);
        assertThat(math.exam120810(10, 5)).isEqualTo(0);
    }
    @Test
    public void exam120806() throws Exception{
        System.out.print("exam120806");
        MathExam math = new MathExam();
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120806(-1, 12));
        System.out.println(ex1.toString());

        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120806(12, -1));
        System.out.println(ex1.toString());

        Throwable ex3 = assertThrows(Exception.class, () -> math.exam120806(101, 12));
        System.out.println(ex1.toString());

        Throwable ex4 = assertThrows(Exception.class, () -> math.exam120806(23, 103));
        System.out.println(ex4.toString());

        assertThat(math.exam120806(3, 2)).isEqualTo(1500);
        assertThat(math.exam120806(7, 3)).isEqualTo(2333);
        assertThat(math.exam120806(1, 16)).isEqualTo(62);
    }
    /*
    @Test
    public void exam120811() throws Exception{
        System.out.print("exam120811");
        MathExam math = new MathExam();
        Throwable ex1 = assertThrows(Exception.class, () -> math.exam120811(new int[]{1,2}));
        System.out.println(ex1.toString());
        Throwable ex2 = assertThrows(Exception.class, () -> math.exam120811(new int[]{-1001}));
        System.out.println(ex2.toString());
        Throwable ex3 = assertThrows(Exception.class, () -> math.exam120811(new int[]{1001}));
        System.out.println(ex3.toString());


        assertThat(math.exam120811(new int[] {1, 2, 7, 10, 11})).isEqualTo(7);
        assertThat(math.exam120811(new int[] {9, -1, 0})).isEqualTo(0);

    }

     */

}























