package com.inkspac3;

import com.inkspac3.entity.CustomArray;
import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.factory.ArrFactory;
import com.inkspac3.parser.ArrayParser;
import com.inkspac3.reader.ArrayReader;
import com.inkspac3.service.impl.*;
import com.inkspac3.validator.CustomArrayValidatorImpl;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CustomArrayException {
        var validator = new CustomArrayValidatorImpl();
        var factory = new ArrFactory(validator);
        var reader = new ArrayReader();
        var parser = new ArrayParser(validator, factory);

        CustomArray array = factory.createArray(10);

        array.add("1aegaegaa");
        array.add("2baeaegaegaegaeg22");
        array.add("3c3ge3");
        array.add("4d44ae4");
        array.add("5e55gegegeg55");
        array.add("6f66666");
        array.add("7g777geg777");
        array.add("8h8888888");
        array.add("9i99999eeeee999");

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

        var sortService = new SortServiceImpl();
        sortService.sortByLengthWQuickSort(array);
        System.out.println(array.toString());

        try {
            List<String> lines = reader.readLines("input.txt");
            CustomArray array3 = parser.parseToArray(lines);
            System.out.println(array);
        } catch (IOException | CustomArrayException e) {
            e.printStackTrace();
        }
    }
}
