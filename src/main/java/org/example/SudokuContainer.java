package org.example;

//could probably do subclasses for rows, cols, and boxes so that the cell class can enforce that it only has one of each... but not for something this small
public class SudokuContainer {
   private boolean[] numbers;

    public SudokuContainer() {
        numbers = new boolean[9];
    }

    public void addNumber(int num) {
        num--;

        if(num > 8 || num < 0) {
            throw new IllegalArgumentException("Error, " + num+1 + " is not a valid number between 1 and 9");
        } else if(numbers[num]) {
            throw new IllegalArgumentException("Error, " + num+1 +" is already in the container");
        }
        numbers[num] = true;
    }

    public void removeNumber(int num) {
        num--;
        if(num > 8 || num < 0) {
            throw new IllegalArgumentException("Error, " + num+1 + " is not a valid number between 1 and 9");
        } else if(!numbers[num]) {
            throw new IllegalArgumentException("Error, " + num+1 +" is not in the container already");
        }
        numbers[num] = false;
    }

    public boolean isNumberPresent(int num) {
        return numbers[num-1];
    }
}
