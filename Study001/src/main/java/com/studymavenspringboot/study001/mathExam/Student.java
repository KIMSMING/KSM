package com.studymavenspringboot.study001.mathExam;

public class Student {
    private String name;
    private int score;

    public Student() {
    }

    public String toString() {
        return String.format("이름 : %s, 점수 : %d, %s", this.name, this.score, super.toString());
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setScore(final int score) {
        this.score = score;
    }
}
