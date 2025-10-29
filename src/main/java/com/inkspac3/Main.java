package com.inkspac3;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.factory.ArrFactory;
import com.inkspac3.parser.ArrayParser;
import com.inkspac3.reader.ArrayReader;
import com.inkspac3.validator.impl.CustomArrayValidatorImpl;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CustomArrayException {
        var validator = new CustomArrayValidatorImpl();
        var factory = new ArrFactory(validator);
        var reader = new ArrayReader();
        var parser = new ArrayParser(validator, factory);
    }
}
