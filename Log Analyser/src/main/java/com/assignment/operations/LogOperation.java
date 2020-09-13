package com.assignment.operations;

import com.assignment.email.MailConfiguration;
import com.assignment.email.MailSending;
import com.assignment.fileOperations.FileExist;
import com.assignment.fileOperations.FileWrite;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LogOperation {

    public void performOperation(FileWrite fileWrite, Scanner scanner, FileExist fileExist, TimeStamp timeStamp,
                                 MailConfiguration mailConfiguration, MailSending mailSending, List<String> emailList) throws IOException{
        String logLine;
        int flag = 0;
        String outputPath = "E:\\Java\\Log Analyser\\src\\main\\resources\\output.txt";
        while (scanner.hasNextLine()){
            logLine = scanner.nextLine();
            if(fileExist.isFileExists(outputPath)){
                if(logLine.contains("ERROR")){
                    System.out.println("error found");
                    fileWrite.writeFile(logLine.split(" ")[0],outputPath);
                    //mailSending.sendMail(mailConfiguration,emailList);
                    break;
                }
                else {
                    System.out.println(logLine);
                }
            }
            else{
                if(flag==1){
                    if(logLine.contains("ERROR")){
                        System.out.println("error found");
                        fileWrite.writeFile(logLine.split(" ")[0],outputPath);
                        //mailSending.sendMail(mailConfiguration,emailList);
                        break;
                    }
                    else{
                        System.out.println(logLine);
                    }
                }

                if(logLine.split(" ")[0].equals(timeStamp.getTimeStamp())){
                    flag = 1;
                }
            }
        }
    }
}
