package com.assignment.timeStamp;

import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SavedTimeStampTest {

    @Test
    public void check_whether_the_file_exists_or_not() {
        String path = "C:/Users/User/Desktop/Log Analyser/src/main/resources/output.txt"; // insert an existing file
        File file = new File(path);
        boolean expected = true;

        //case 1 --> file exist
        //use exists() Function to check whether the return value is true
        assertTrue(file.exists());
    }

    @Test
    public void check_whether_the_file_not_exists() {
        String path = "C:/Users/User/Desktop/Log Analyser/src/main/resources/outpt.txt"; // insert a non existing file
        File file = new File(path);
        boolean expected = true;

        //case 2 --> file does not exist
        //use exists() Function to check whether the return value is false
        assertFalse(file.exists());
    }

    @Test
    public void should_return_current_timeStamp() throws IOException {
        SavedTimeStamp savedTimeStamp = new SavedTimeStamp();
        String timeStamp = savedTimeStamp.getTimeStamp();
        String expected = "2020-09-06T17:25:20Z";
        assertEquals(expected,timeStamp);
    }

    @Test
    public void should_return_empty_timeStamp() throws IOException {
        SavedTimeStamp savedTimeStamp = new SavedTimeStamp();
        String timeStamp = savedTimeStamp.getTimeStamp();
        String expected = "";
        assertEquals(expected,timeStamp);
    }

}
