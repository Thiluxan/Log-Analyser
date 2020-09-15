package com.assignment.timeStamp;

import com.assignment.fileOperations.FileRead;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TimeStampRepositoryTest {

    @Test
    public void should_return_timeStampList(){
        FileRead fileRead = new FileRead();
        Scanner scanner = fileRead.readFile("C:/Users/User/Desktop/Log Analyser/src/main/resources/output.txt");

        TimeStampRepository timeStampRepository = new TimeStampRepository();
        List<String> timeStampList = timeStampRepository.getTimeStamp(scanner);   // get the number of strings

        assertEquals(1,timeStampList.size());
    }


}