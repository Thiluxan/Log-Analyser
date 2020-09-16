package com.assignment.operations;

import java.util.List;
import java.util.Scanner;

//Check for ERROR in log file, if it is read for first time in the application
public class FileNotExistOperation implements Operation{
    @Override
    public String performOperation(Scanner scanner, String errorTimeStamp, List<String> timeStampList) {
        String logLine;
        int index;
        while (scanner.hasNextLine()){
            logLine = scanner.nextLine();
            if(logLine.contains("ERROR")){

                //Getting the timeStamp of the line where ERROR found
                index = timeStampList.indexOf(logLine.split(" ")[0]);

                //Logic for finding the next timeStamp if a timeStamp found with error
                for(int i=index+1; i<timeStampList.size(); i++){
                    if(timeStampList.get(i).equals(timeStampList.get(index))){
                        continue;
                    }
                    else{
                        index = i;
                        break;
                    }
                }

                //Returning the timeStamp to be saved in the output text file
                String output = timeStampList.get(index);
                return output;
            }
        }
        return "";
    }
}

