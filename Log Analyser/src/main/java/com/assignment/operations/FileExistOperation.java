package com.assignment.operations;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//Check for ERROR in log file, if it is read already and an ERROR is recorded in output text file
public class FileExistOperation implements Operation {
    @Override
    public String performOperation(Scanner scanner, String errorTimeStamp,
                                 List<String> timeStampList) throws IOException {

        String logLine;
        int flag = 0;
        int index;
        while (scanner.hasNextLine()){
            logLine = scanner.nextLine();
            if(flag==1){
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

            //Seeking for already recorded timeStamp in the output text file
            if(logLine.split(" ")[0].equals(errorTimeStamp)){
                flag = 1;
            }
        }
        return "";
    }
}
