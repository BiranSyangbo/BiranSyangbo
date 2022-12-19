package com.example.datastructure;

import java.util.Objects;
import java.util.function.Supplier;

public class NonNullCheck {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        String s = safeNull(() -> teacher.getEmployee().getId());
        boolean isNull = nonNullSafe(teacher::getEmployee);
        System.out.println("s = " + s);
        System.out.println("isNull = " + isNull);
    }

    private static <T> boolean nonNullSafe(final Supplier<T> supplier) {
        try {
            return Objects.nonNull(supplier.get());
        } catch (NullPointerException e) {
            return false;
        }
    }

    private static <T> T safeNull(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (NullPointerException ex) {
            return null;
        }
    }
}


class Employee {
    private String id;

    public String getId() {
        return id;
    }

}

class Teacher {

    private String id;

    private Employee employee;

    public String getId() {
        return id;
    }

    public Employee getEmployee() {
        return employee;
    }

}
