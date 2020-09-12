package com.assignment.input;

import java.util.Scanner;

public class CommandLineInput implements Input{

    public String getInput(){
        System.out.println("Enter Log file path");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
        return path;
    }
}
