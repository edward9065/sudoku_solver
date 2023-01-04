package org.example;

public class Cell {
    SudokuContainer row, column, box, possibilities;
    int value;
    public Cell (SudokuContainer row, SudokuContainer column, SudokuContainer box, int value) {
        this.row = row;
        this.column = column;
        this.box = box;
        if(value > 9 || value < 0) {
            throw new IllegalArgumentException("Error value of cell must be a value between 0 and 9")
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNextPossibleValue() {
        //do smth
    }

    public SudokuContainer getRow() {
        return row;
    }

    public SudokuContainer getColumn() {
        return column;
    }

    public SudokuContainer getBox() {
        return box;
    }
}
