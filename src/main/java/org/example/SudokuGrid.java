package org.example;

public interface SudokuGrid {
    //ideally, user of grid should not need to interact directly with cells...
    //return 0 if no value in cell
    public int getCellValue(int row, int column);

    //should throw exception if invalid
    public void setCellValue(int row, int column, int value);

    //for backtracking algprithm
    public void setCellValueToNextValidValue(int row, int column);
}
