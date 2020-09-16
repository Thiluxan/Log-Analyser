package com.assignment.timeStamp;

import com.assignment.fileOperations.FileExist;
import com.assignment.fileOperations.FileRead;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SavedTimeStampTest {

    @Test
    public void should_return_current_timeStamp() throws IOException {
        String outputPath = "E:\\Java\\Log Analyser\\src\\main\\resources\\output.txt";
        
        FileRead fileRead = new FileRead();
        Scanner scanner = fileRead.readFile(outputPath);
        
        FileExist fileExist = new FileExist();
        boolean result = fileExist.isFileExists(outputPath);
        
        SavedTimeStamp savedTimeStamp = new SavedTimeStamp();
        String timeStamp = savedTimeStamp.getTimeStamp(result,scanner);
        
        assertThat(timeStamp,is("2020-09-06T17:25:20Z"));
    }

    @Test
    public void should_return_empty_timeStamp() throws IOException {
        String outputPath = "E:\\Java\\Log Analyser\\src\\main\\resources\\output.txt";
        
        FileRead fileRead = new FileRead();
        Scanner scanner = fileRead.readFile(outputPath);
        
        FileExist fileExist = new FileExist();
        boolean result = fileExist.isFileExists(outputPath);
        
        SavedTimeStamp savedTimeStamp = new SavedTimeStamp();
        String timeStamp = savedTimeStamp.getTimeStamp(result,scanner);
        
        assertThat(timeStamp,is(""));
    }

}
