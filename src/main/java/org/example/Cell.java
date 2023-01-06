package org.example;

public class Cell {
    SudokuContainer row, column, box, possibilities;
    private int value;
    public Cell (SudokuContainer row, SudokuContainer column, SudokuContainer box, int value) {
        this.row = row;
        this.column = column;
        this.box = box;
        this.possibilities = new SudokuContainer();
        if(value > 9 || value < 0) {
            throw new IllegalArgumentException("Error value of cell must be a value between 0 and 9");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    //throw exception later, return 0 now
    public int getNextPossibleValue() {
        //do smth
        for(int i = 1; i<9; i++) {
            if(!possibilities.isNumberPresent(i)) {
                if(row.isNumberPresent(i) || column.isNumberPresent(i) || box.isNumberPresent(i)) {
                    possibilities.addNumber(i);
                } else {
                    return i;
                }
            }
        }
        return 0;
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
