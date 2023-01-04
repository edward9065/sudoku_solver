package org.example;

public class SudokuGridImpl implements SudokuGrid{
    int[][] grid;
    SudokuContainer[] rows, columns, boxes;

    public SudokuGridImpl(){
        grid = new int[9][9];
        rows = new SudokuContainer[9];
        columns = new SudokuContainer[9];
        boxes = new SudokuContainer[9];
        //instantiate new cells
    }
    //add one that takes a JSON later

    //will return 0 for a non-value
    public int getCellValue(int row, int column) {
        return grid[0][0];
    }

    //sets the cell value regardless
    public void setCellValue(int row, int column, int value) {
        if(rows[row].isNumberPresent(value) || columns[column].isNumberPresent(value) || ) {

        }
    }

    //for backtracking algprithm
    public void setCellValueToNextValidValue(int row, int column) {

    }
}
