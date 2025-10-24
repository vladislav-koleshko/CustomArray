package com.inkspac3;

import com.inkspac3.entities.CustomArray;
import com.inkspac3.factory.ArrFactory;

public class Main {
    public static void main(String[] args) {
        CustomArray array = ArrFactory.createArray(10);
        array.add("1h");
        array.add("2h");
        array.add("3h");
        array.add("4h");
        array.add("5h");
        array.add("6h");
        array.add("7h");
        array.add("8h");
        array.add("9h");
        System.out.println(array.get(8));
        array.printArray();
    }
}
