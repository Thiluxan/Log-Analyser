package com.assignment.fileOperations;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class FileExistTest {

   //Case 1 -->File Exsist
    @Test
    public void should_return_true_when_file_exists(){

        String validPath = "C:\\Users\\User\\Desktop\\Log Analyser\\src\\main\\resources\\test.txt";
        FileExist fileExist = new FileExist();
        boolean result = fileExist.isFileExists(validPath);
        assertTrue(result);

    }
    //Case 2 -->File Not Exsist

    @Test
    public void should_return_false_when_file_not_exists() throws FileNotFoundException {

        String inValidPath = "C:\\Users\\User\\Desktop\\Log Analyser\\src\\main\\resources\\tes.txt";
        FileExist fileExist = new FileExist();
        boolean result = fileExist.isFileExists(inValidPath);
        assertFalse(result);
    }

}