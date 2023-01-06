package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SudokuContainerTest {
    SudokuContainer sudokuContainer;
    boolean[] numbers;
    Field numbersField;
    @BeforeEach
    public void initialize() {
        sudokuContainer = new SudokuContainer();
        try {
            numbersField = SudokuContainer.class.getDeclaredField("numbers");
            numbersField.setAccessible(true);
            numbers = (boolean[])numbersField.get(sudokuContainer);
        } catch( Exception e ) { System.out.println(e); } //do nothing

    }

    @Test
    public void testSudokuContainerAddZero(){
        assertThrows(IllegalArgumentException.class, () -> sudokuContainer.addNumber(0));
    }

    @Test
    public void testSudokuContainerAddNine() {
        sudokuContainer.addNumber(9);
        assertTrue(numbers[9]);
    }

    @Test
    public void testAddDuplicateNumber() {
        numbers[0] = true; //the internal array indexs from 0, so indices are all shifted to the left by 1.
        assertThrows(IllegalArgumentException.class, () -> sudokuContainer.addNumber(1));
    }

    //technically the method under test should only be tested once but oh well.
    @Test
    public void testAddAllNumbers() {
        for(int i = 1; i<=numbers.length; i++) { sudokuContainer.addNumber(i); }
        for(int i = 0; i<numbers.length; i++ ) { assertTrue(numbers[i]); }
    }

    @Test
    public void testAddOutOfBoundsNumber() {
        assertThrows(IllegalArgumentException.class, () -> sudokuContainer.addNumber(10));
    }

}