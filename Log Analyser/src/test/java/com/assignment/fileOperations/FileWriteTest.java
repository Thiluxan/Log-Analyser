package com.assignment.fileOperations;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class FileWriteTest {

    @Test
    public void should_write_file(){

        String text = "write";
        String textPath = "C:\\Users\\User\\Desktop\\Log Analyser\\src\\main\\resources\\Test.txt";
        String expectedText = "write";

        //write text using FileWrite Class
        FileWrite fileWrite = new FileWrite();
        fileWrite.writeFile(text,textPath);

        //get written text using FileRead Class
        FileRead fileRead = new FileRead();
        Scanner scanner = fileRead.readFile(textPath);
        String actualText = scanner.nextLine();

        assertEquals(expectedText,actualText);


    }

}