package com.inkspac3.course.entity;

public class CustomArrayData {
    private int avgLength;
    private int maxLength;
    private int minLength;
    private int sumLength;
    private int countOfElements;

    public CustomArrayData() {}

    public CustomArrayData(int avgLength, int maxLength, int minLength, int sumLength, int countOfElements) {
        this.avgLength = avgLength;
        this.maxLength = maxLength;
        this.minLength = minLength;
        this.sumLength = sumLength;
        this.countOfElements = countOfElements;
    }

    public int getAvgLength() {
        return avgLength;
    }

    public void setAvgLength(int avgLength) {
        this.avgLength = avgLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getSumLength() {
        return sumLength;
    }

    public void setSumLength(int sumLength) {
        this.sumLength = sumLength;
    }

    public int getCountOfElements() {
        return countOfElements;
    }

    public void setCountOfElements(int countOfElements) {
        this.countOfElements = countOfElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ArrayData{");
        sb.append("minLength=").append(minLength)
                .append(", maxLength=").append(maxLength)
                .append(", sumLength=").append(sumLength)
                .append(", avgLength=").append(avgLength)
                .append(", countOfElements=").append(countOfElements)
                .append('}');
        return sb.toString();
    }
}
