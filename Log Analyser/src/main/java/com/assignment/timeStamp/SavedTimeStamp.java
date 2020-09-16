package com.assignment.timeStamp;

import java.io.IOException;
import java.util.Scanner;

public class SavedTimeStamp {
    public String getTimeStamp(boolean result, Scanner scanner) throws IOException {
        //This will return the saved timeStamp in the output text file
        if(result){
            return scanner.next();
        }
        else{
            return "";
        }
    }
}

