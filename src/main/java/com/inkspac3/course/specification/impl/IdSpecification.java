package com.inkspac3.course.specification.impl;

import com.inkspac3.course.entity.CustomArray;
import com.inkspac3.course.specification.CustomArraySpecification;

public class IdSpecification implements CustomArraySpecification {
    private final long id;

    public IdSpecification(long id) {
        this.id = id;
    }

    @Override
    public boolean specify(CustomArray array) {
        return array.getId() == id;
    }
}
