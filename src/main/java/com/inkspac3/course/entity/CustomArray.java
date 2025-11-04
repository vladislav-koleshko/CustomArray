package com.inkspac3.course.entity;

import com.inkspac3.course.exception.CustomArrayException;
import com.inkspac3.course.observer.ArrayObservable;
import com.inkspac3.course.observer.ArrayObserver;
import com.inkspac3.course.validator.CustomArrayValidator;
import org.apache.log4j.Logger;

import java.util.*;

public class CustomArray implements Iterable<String>, ArrayObservable {
    private static final Logger log = Logger.getLogger(CustomArray.class);
    private long id;
    private final String[] data;
    private int size;
    private final List<ArrayObserver> observers = new ArrayList<>();


    public CustomArray(long id, int capacity) throws CustomArrayException {
        this.id = id;
        this.data = new String[capacity];
        this.size = 0;
        log.info("Array of capacity " + capacity + " was created");
    }

    public CustomArray(String[] data) throws CustomArrayException {
        if (data == null) {
            throw new CustomArrayException("Array cannot be null");
        }
        this.data = data.clone();
        this.size = data.length;
        log.info("CustomArray created from existing array, size: " + data.length);
    }

    public Long getId() {
        return id;
    }

    public void add(String item) throws CustomArrayException {
        if (size < data.length) {
            data[size++] = item;
            notifyObservers();
            log.info("The item " + item + " was added to the array");
        } else {
            log.error("Error occured while adding " + item + " to the array");
            throw new CustomArrayException("Array is full");
        }
    }

    public String getElem(int index, CustomArrayValidator validator) throws CustomArrayException {
        if(!validator.validateArrayElement(index, this.size)) {
            throw new CustomArrayException("Invalid index");
        }
        return data[index];
    }

    public String[] get() {
        return data;
    }

    public void set(int index, String value, CustomArrayValidator validator) throws CustomArrayException {
        if(!validator.validateArrayElement(index, this.size)) {
            throw new CustomArrayException("Invalid index");
        }
        data[index] = value;
        notifyObservers();
    }

    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;

        if (size != that.size) return false;
        return Arrays.equals(Arrays.copyOf(data, size), Arrays.copyOf(that.data, that.size));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + size;

        for (int i = 0; i < size; i++) {
            String element = data[i];
            result = 31 * result + (element == null ? 0 : element.hashCode());
        }

        return result;
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

    @Override
    public void registerObserver(ArrayObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ArrayObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ArrayObserver obs : observers) {
            obs.update(this);
        }
    }
}
