package com.github.prog2;

import java.util.Objects;

// public abstract sealed class Person permits Employee, Student {
public abstract class Person {
    private String name;

    public Person(String n) {
        name = Objects.requireNonNull(n, "The name cannot be null");
    }

    public String getName() {
        return name;
    }

    public abstract String getDescription();
}
