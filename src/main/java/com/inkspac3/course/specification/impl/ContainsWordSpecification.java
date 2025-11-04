package com.inkspac3.course.specification.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.specification.CustomArraySpecification;

public class ContainsWordSpecification implements CustomArraySpecification {
    private final String word;

    public ContainsWordSpecification(String word) {
        this.word = word;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        for (String str : customArray) {
            if (str!= null && str.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
