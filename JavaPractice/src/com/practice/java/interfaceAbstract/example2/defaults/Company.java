package com.practice.java.interfaceAbstract.example2.defaults;

public interface Company {
    default String getName() {
        return "defaults.Company";
    }
}
