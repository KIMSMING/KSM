package com.studymavenspringboot.study001.mathExam;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;    //멤버편수(필드)는 무조건 private, Getter, Setter을 만들어야 한다.
    private int score;

    @Override
    public String toString() {
        return String.format("이름 : %s, 점수 : %d, %s"
                , name, score, super.toString());
    }
}
