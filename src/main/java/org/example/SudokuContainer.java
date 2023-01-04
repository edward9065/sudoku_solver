package org.example;

//could probably do subclasses for rows, cols, and boxes so that the cell class can enforce that it only has one of each... but not for something this small
public class SudokuContainer {
   private boolean[] numbers;

    public SudokuContainer() {
        numbers = new boolean[9];
    }

    public void addNumber(int num) {
        num--;
        if(numbers[num]) {
            throw new IllegalArgumentException("Error, " + num +" is already in the container");
        }
        numbers[num] = true;
    }

    public void removeNumber(int num) {
        num--;
        if(!numbers[num]) {
            throw new IllegalArgumentException("Error, "+ num + " was not in the container");
        }
        numbers[num] = false;
    }

    public boolean isNumberPresent(int num) {
        return numbers[num-1];
    }
}
