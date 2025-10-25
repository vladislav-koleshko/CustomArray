package com.inkspac3;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.factory.ArrFactory;
import com.inkspac3.service.impl.*;
import com.inkspac3.validator.CustomArrayValidatorImpl;

public class Main {
    public static void main(String[] args) throws CustomArrayException {
        var validator = new CustomArrayValidatorImpl();
        var factory = new ArrFactory(validator);
        CustomArray array = factory.createArray(10);

        array.add("1a");
        array.add("2b2");
        array.add("3c33");
        array.add("4d444");
        array.add("5e5555");
        array.add("6f66666");
        array.add("7g777777");
        array.add("8h8888888");
        array.add("9i99999999");

        System.out.println(array.getElem(8));
        System.out.println(array.toString());

        var calculateAvgLengthService = new AvgLengthServiceImpl();
        System.out.println(calculateAvgLengthService.calculateAvgLength(array));


        CustomArray array2 = factory.createArray(1);
        System.out.println(array2.size());
        System.out.println(calculateAvgLengthService.calculateAvgLength(array2));

        var calculateCountOfElemService = new CountOfElemServiceImpl();
        System.out.println(calculateCountOfElemService.calculateCountOfElem(array));

        var minMaxService = new MinMaxServiceImpl(validator);
        System.out.println(minMaxService.getMin(array));
        System.out.println(minMaxService.getMax(array));

        var sumService = new SumServiceImpl();
        System.out.println(sumService.calculateSumLength(array));

        var replaceByConditionService = new ReplaceByConditionServiceImpl(validator);
        System.out.println(replaceByConditionService.replaceByIndex(2, array, "2"));
        System.out.println(array.toString());
    }
}
