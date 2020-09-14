package com.assignment.timeStamp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SavedTimeStamp {
    public String getTimeStamp() throws IOException {
        String path = "E:\\Java\\Log Analyser\\src\\main\\resources\\output.txt";
        FileInputStream file = new FileInputStream(path);
        File fp = new File(path);
        if(!(fp.length()==0)){
            Scanner sc = new Scanner(file);
            return sc.next();
        }
        else{
            return "";
        }
    }
}
