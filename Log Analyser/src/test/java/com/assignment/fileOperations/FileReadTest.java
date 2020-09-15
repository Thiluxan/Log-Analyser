package com.assignment.fileOperations;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FileReadTest {

    @Test
    public void should_contain_object_if_file_read() throws Exception{
        FileRead fileRead = new FileRead();
        Scanner scanner = fileRead.readFile("C:\\Users\\User\\Desktop\\Log Analyser\\src\\main\\resources\\output.txt");
        assertNotNull(scanner);
    }

}