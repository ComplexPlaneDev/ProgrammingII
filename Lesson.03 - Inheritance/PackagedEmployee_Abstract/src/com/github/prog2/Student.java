package com.github.prog2;

// public final class Student extends Person {
public class Student extends Person {

    public Student(String n) {
        super(n);
    }

    @Override
    public String getDescription() {
        return "I'm a student";
    }
}
