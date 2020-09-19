package com.assignment;

import com.assignment.database.DataRepository;
import com.assignment.database.DatabaseConnection;
import com.assignment.database.EmailRepository;
import com.assignment.email.MailConfiguration;
import com.assignment.email.MailSending;
import com.assignment.fileOperations.FileExist;
import com.assignment.fileOperations.FileRead;
import com.assignment.fileOperations.FileWrite;
import com.assignment.input.CommandLineInput;
import com.assignment.input.Input;
import com.assignment.operations.OperationFactory;
import com.assignment.timeStamp.LogRepository;
import com.assignment.timeStamp.SavedTimeStamp;
import com.assignment.timeStamp.TimeStampRepository;

public class Main {
    public static void main(String args[]) throws Exception{
        OperationFactory operationFactory = new OperationFactory();

        FileExist fileExist = new FileExist();
        FileRead fileRead  = new FileRead();
        FileWrite fileWrite = new FileWrite();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        MailConfiguration mailConfiguration = new MailConfiguration();
        DataRepository dataRepository = new EmailRepository();
        MailSending mailSending = new MailSending();
        Input input = new CommandLineInput();
        SavedTimeStamp savedTimeStamp = new SavedTimeStamp();
        LogRepository timeStampRepository = new TimeStampRepository();

        LogAnalyzerApp logAnalyzerApp = new LogAnalyzerApp(fileRead,fileWrite,fileExist,databaseConnection,
                dataRepository,mailConfiguration,input,operationFactory, savedTimeStamp, mailSending, timeStampRepository);
        logAnalyzerApp.execute();

    }
}
