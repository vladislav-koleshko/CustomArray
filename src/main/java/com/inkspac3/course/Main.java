package com.inkspac3.course;

import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.factory.CustomArrayFactory;
import com.inkspac3.course.parser.CustomArrayParser;
import com.inkspac3.course.reader.CustomArrayReader;
import com.inkspac3.course.validator.impl.CustomArrayValidatorImpl;

public class Main {
    public static void main(String[] args){
        var validator = new CustomArrayValidatorImpl();
        var factory = new CustomArrayFactory(validator);
        var reader = new CustomArrayReader();
        var parser = new CustomArrayParser(validator, factory);
    }
}
