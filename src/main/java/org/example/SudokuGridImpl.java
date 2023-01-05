package org.example;

public class SudokuGridImpl implements SudokuGrid{
    Cell[][] grid;
    SudokuContainer[] rows, columns, boxes;

    public SudokuGridImpl(int[][] inputGrid){
        grid = new Cell[9][9];
        rows = new SudokuContainer[9];
        columns = new SudokuContainer[9];
        boxes = new SudokuContainer[9];

        fillInGrid(inputGrid);
    }
    //add one that takes a JSON later

    //will return 0 for a non-value
    public int getCellValue(int row, int column) {
        return grid[0][0].getValue();
    }

    //sets the cell value regardless
    public void setCellValue(int row, int column, int value) {
        grid[row][column].setValue(value);
    }

    //for backtracking algorithm
    public void setCellValueToNextValidValue(int row, int column) {
        int nextValue = grid[row][column].getNextPossibleValue();
        if(nextValue == 0) {
            throw new IllegalStateException("Error: Cell at " + row +", "+column+" does not have a possible value");
        }
        grid[row][column].setValue(nextValue);
    }

    private void fillInGrid(int[][] inputGrid){
        if(inputGrid.length !=9) { throw new IllegalArgumentException("Error, input grid must be 9x9"); }

        int boxCount = 0;

        for(int i=0; i<9; i++) {
            if(inputGrid[i].length!=0) { throw new IllegalArgumentException("Error, input grid must be 9x9"); }
            //create new row
            rows[i] = new SudokuContainer();
            for(int j = 0; j<9; j++) {
                if((i==0 || i==3 || i==6) && (j==0 || j==3 || j==6)) {
                    //create new column and box
                    columns[j] = new SudokuContainer();
                    //probably could just be a list but oh well...
                    boxes[boxCount] = new SudokuContainer();
                } else if(j==0) {
                    //create new column
                    columns[j] = new SudokuContainer();
                }
                //refactor so that rows, columns, etc are different classes so that the compiler can enforce that a cell will get one of each
                grid[i][j] = new Cell(rows[i], columns[j], boxes[boxCount], inputGrid[i][j]);
            }
        }
    }
}
