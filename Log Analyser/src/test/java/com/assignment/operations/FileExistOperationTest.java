package com.assignment.operations;

import com.assignment.fileOperations.FileRead;
import com.assignment.timeStamp.SavedTimeStamp;
import com.assignment.timeStamp.TimeStampRepository;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FileExistOperationTest {

    @Test
    public void should_return_errorTimeStamp_as_error_found() throws IOException {
        String path = "E:\\Java\\Log Analyser\\src\\main\\resources\\example2.log";
        FileRead fileRead = new FileRead();
        Scanner scanner = fileRead.readFile(path);

        SavedTimeStamp savedTimeStamp = new SavedTimeStamp();
        String errorTimeStamp = savedTimeStamp.getTimeStamp("C:/Users/User/Desktop/Log Analyser/src/main/resources/output.txt");

        TimeStampRepository timeStampRepository = new TimeStampRepository();
        List<String> timeStampList = timeStampRepository.getTimeStamp(scanner);

        FileNotExistOperation fileNotExistOperation = new FileNotExistOperation();
        String output = fileNotExistOperation.performOperation(scanner,errorTimeStamp,timeStampList);

        String expected = "2020-09-06T17:25:20Z";
        assertEquals(expected,output);
    }

    @Test
    public void should_not_return_errorTimeStamp_as_no_error_found() throws IOException {
        String path = "E:\\Java\\Log Analyser\\src\\main\\resources\\example.log";
        FileRead fileRead = new FileRead();
        Scanner scanner = fileRead.readFile(path);

        SavedTimeStamp savedTimeStamp = new SavedTimeStamp();
        String errorTimeStamp = savedTimeStamp.getTimeStamp("C:/Users/User/Desktop/Log Analyser/src/main/resources/output.txt");

        TimeStampRepository timeStampRepository = new TimeStampRepository();
        List<String> timeStampList = timeStampRepository.getTimeStamp(scanner);

        FileNotExistOperation fileNotExistOperation = new FileNotExistOperation();
        String output = fileNotExistOperation.performOperation(scanner,errorTimeStamp,timeStampList);

        String expected = "";
        assertEquals(expected,output);
    }

}