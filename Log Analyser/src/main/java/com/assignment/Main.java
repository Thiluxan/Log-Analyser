package com.assignment;

import com.assignment.database.DatabaseConnection;
import com.assignment.database.EmailRepository;
import com.assignment.email.MailConfiguration;
import com.assignment.email.MailSending;
import com.assignment.fileOperations.FileExist;
import com.assignment.fileOperations.FileRead;
import com.assignment.fileOperations.FileWrite;
import com.assignment.input.CommandLineInput;
import com.assignment.input.Input;
import com.assignment.operations.LogOperation;
import com.assignment.operations.TimeStamp;

public class Main {
    public static void main(String args[]) throws Exception{
        LogOperation logOperation = new LogOperation();
        FileExist fileExist = new FileExist();
        FileRead fileRead  = new FileRead();
        FileWrite fileWrite = new FileWrite();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        EmailRepository emailRepository = new EmailRepository();
        MailConfiguration mailConfiguration = new MailConfiguration();
        MailSending mailSending = new MailSending();
        Input input = new CommandLineInput();
        TimeStamp timeStamp = new TimeStamp();

        LogAnalyzerApp logAnalyzerApp = new LogAnalyzerApp(fileRead,fileWrite,fileExist,databaseConnection,
                emailRepository,mailConfiguration,input,logOperation,timeStamp, mailSending);
        logAnalyzerApp.execute();

    }
}
