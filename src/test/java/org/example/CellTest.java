package org.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito.*;

import java.lang.reflect.Field;

class CellTest {
    SudokuContainer row, column, box, possibilities;
    Field possibilitiesField;
    Cell cell;

    //refactor with spring?
    @BeforeEach
    public void initialize(){
        row = mock(SudokuContainer.class);
        column = mock(SudokuContainer.class);
        box = mock(SudokuContainer.class);
        possibilities = mock(SudokuContainer.class);

        try {
            possibilitiesField = Cell.class.getDeclaredField("possibilities");
            possibilitiesField.setAccessible(true);
            cell = new Cell(row, column, box, 0);
            possibilitiesField.set(cell, possibilities);
        } catch( Exception e) { System.out.println(e); } //do nothing
    }

    @Test
    public void testGetNextPossibleValueAllPossibilities() {
        assertEquals(1, cell.getNextPossibleValue());
    }

    @Test
    public void testGetNextPossibleValueWithValuesInRow() {
        when(row.isNumberPresent(1)).thenReturn(true);
        when(row.isNumberPresent(2)).thenReturn(true);
        when(row.isNumberPresent(3)).thenReturn(false);
        assertEquals(3, cell.getNextPossibleValue());
        verify(row, times(3)).isNumberPresent(anyInt());

    }

    @Test
    public void testGetNextPossibleValueWithValuesInColumn() {
        when(column.isNumberPresent(1)).thenReturn(true);
        when(column.isNumberPresent(2)).thenReturn(true);
        when(column.isNumberPresent(3)).thenReturn(false);
        assertEquals(3, cell.getNextPossibleValue());
        verify(column, times(3)).isNumberPresent(anyInt());
    }

    @Test
    public void testGetNextPossibleValueWithValuesInBox() {
        when(box.isNumberPresent(1)).thenReturn(true);
        when(box.isNumberPresent(2)).thenReturn(true);
        when(box.isNumberPresent(3)).thenReturn(false);
        assertEquals(3, cell.getNextPossibleValue());
        verify(box, times(3)).isNumberPresent(anyInt());
    }

    @Test
    public void testGetNextPossibleValueWithValuesInAllContainers() {
        //can replace with hamcrest
        when(box.isNumberPresent(1)).thenReturn(true);
        when(box.isNumberPresent(2)).thenReturn(true);
        when(box.isNumberPresent(3)).thenReturn(false);

        when(column.isNumberPresent(1)).thenReturn(true);
        when(column.isNumberPresent(3)).thenReturn(true);

        when(row.isNumberPresent(1)).thenReturn(true);
        when(row.isNumberPresent(2)).thenReturn(false);
        when(row.isNumberPresent(4)).thenReturn(true);

        assertEquals(5, cell.getNextPossibleValue());
        //number of invokations differs because of short-circuiting of || in getNextPossibleValue

        verify(row, times(5)).isNumberPresent(anyInt());
        verify(column, times(5)).isNumberPresent(anyInt());
        verify(box, times(5)).isNumberPresent(anyInt());
    }

    @Test
    public void testGetNextPossibleValueWithPossibilities() {
        when(possibilities.isNumberPresent(anyInt())).thenReturn(true);
        assertEquals(0, cell.getNextPossibleValue());
        verify(possibilities, times(8)).isNumberPresent(anyInt());
    }
}