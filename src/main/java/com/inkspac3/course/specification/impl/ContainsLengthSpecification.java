package com.inkspac3.course.specification.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.specification.CustomArraySpecification;

public class ContainsLengthSpecification implements CustomArraySpecification {
    private final int length;

    public ContainsLengthSpecification(int length) {
        this.length = length;
    }

    @Override
    public boolean specify(CustomArray array) {
        for(String str: array) {
            if(str.length() == length) {
                return true;
            }
        }
        return false;
    }
}
