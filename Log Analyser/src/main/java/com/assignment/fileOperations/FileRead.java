package com.assignment.fileOperations;

import java.io.*;
import java.util.Scanner;

public class FileRead {

    public Scanner readFile(String path) {
        try
        {
            FileInputStream file = new FileInputStream(path);
            Scanner scanner = new Scanner(file);
            return scanner;
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
