package com.inkspac3.entities;

import com.inkspac3.exception.ArrayFullException;
import com.inkspac3.exception.InvalidArgumentException;
import com.inkspac3.exception.InvalidIndexException;
import org.apache.log4j.Logger;

public class CustomArray {
    private static final Logger log = Logger.getLogger(CustomArray.class);
    private final String[] data;
    private int size;

    public CustomArray(int size) {
        if (size < 0) {
            log.error("Размер массива должна быть больше 0");
            throw new InvalidArgumentException("Размер массива должна быть больше 0");
        }
        this.data = new String[size];
        this.size = 0;
        log.info("Массив размера " + size + " был создан");
    }

    public void add(String item) {
        if (size < data.length) {
            data[size++] = item;
            log.info("Элемент был успешно добавлен в массив");
        } else {
            log.error("Ошибка добавления элемента в массив: массив переполнен!");
            throw new ArrayFullException("Массив переполнен");
        }
    }

    public String get(int index) {
        if (index >= size || index < 0) {
            log.error("Неверный индекс " + index);
            throw new InvalidIndexException("Индекс выходит за границы массива: " + index);
        }
        return data[index];
    }

    public int size() {
        return size;
    }

    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
