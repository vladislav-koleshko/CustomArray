package com.inkspac3.entity;

import com.inkspac3.exception.CustomArrayException;
import com.inkspac3.validator.impl.CustomArrayValidator;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArray implements Iterable<String> {
    private static final Logger log = Logger.getLogger(CustomArray.class);
    private final String[] data;
    private int size;
    private final CustomArrayValidator validator;


    public CustomArray(int capacity, CustomArrayValidator validator) throws CustomArrayException {
        this.validator = validator;
        this.validator.validateArrayCreation(capacity);
        this.data = new String[capacity];
        this.size = 0;
        log.info("Array of capacity " + capacity + " was created");
    }

    public void add(String item) throws CustomArrayException {
        if (size < data.length) {
            data[size++] = item;
            log.info("The item " + item + " was added to the array");
        } else {
            log.error("Error occured while adding " + item + " to the array");
            throw new CustomArrayException("Array is full!");
        }
    }

    public String getElem(int index) throws CustomArrayException {
        validator.validateArrayElement(index, this.size);
        return data[index];
    }

    public String[] get(){
        return data;
    }

    public void set(int index, String value) throws CustomArrayException {
        validator.validateArrayElement(index, this.size);
        data[index] = value;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Array");
        return builder.append(Arrays.toString(data)).toString();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public String next() {
                if(!hasNext()) {
                    throw new NoSuchElementException("No more elements");
                }
                return data[index++];
            }
        };
    }
}
