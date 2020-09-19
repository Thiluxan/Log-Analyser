package com.assignment;

import com.assignment.database.DataRepository;
import com.assignment.database.DatabaseConnection;
import com.assignment.email.MailConfiguration;
import com.assignment.email.MailSending;
import com.assignment.fileOperations.FileExist;
import com.assignment.fileOperations.FileRead;
import com.assignment.fileOperations.FileWrite;
import com.assignment.input.Input;
import com.assignment.operations.Operation;
import com.assignment.operations.OperationFactory;
import com.assignment.timeStamp.LogRepository;
import com.assignment.timeStamp.SavedTimeStamp;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class LogAnalyzerApp {
    private FileRead fileRead;
    private FileWrite fileWrite;
    private FileExist fileExist;
    private DatabaseConnection databaseConnection;
    private DataRepository emailRepository;
    private MailConfiguration mailConfiguration;
    private Input input;
    private SavedTimeStamp savedTimeStamp;
    private MailSending mailSending;
    private LogRepository timeStampRepository;
    private OperationFactory operationFactory;

    public LogAnalyzerApp(FileRead fileRead, FileWrite fileWrite, FileExist fileExist, DatabaseConnection databaseConnection,
                          DataRepository emailRepository, MailConfiguration mailConfiguration, Input input,
                          OperationFactory operationFactory, SavedTimeStamp savedTimeStamp, MailSending mailSending,
                          LogRepository timeStampRepository) {
        this.fileRead = fileRead;
        this.fileWrite = fileWrite;
        this.fileExist = fileExist;
        this.databaseConnection = databaseConnection;
        this.emailRepository = emailRepository;
        this.mailConfiguration = mailConfiguration;
        this.input = input;
        this.operationFactory = operationFactory;
        this.savedTimeStamp = savedTimeStamp;
        this.mailSending = mailSending;
        this.timeStampRepository = timeStampRepository;
    }

    public void execute() throws IOException, NullPointerException {
        //Getting list of emails
        databaseConnection.connectDatabase();
        List<String> emailList = emailRepository.getData();
        
        String outputPath = "E:\\Java\\Log Analyser\\src\\main\\resources\\output.txt";
        
        // Getting the timeStamp already saved
        boolean isOutputFileExist = fileExist.isFileExists(outputPath);
        Scanner outputFileScanner = fileRead.readFile(outputPath);
        String errorTimeStamp = savedTimeStamp.getTimeStamp(isOutputFileExist,outputFileScanner);
        
        //Getting user input
        String path = input.getInput();

        Scanner scanner = fileRead.readFile(path);
        
        //Getting List of timeStamps in the log file
        List<String> timeStampList = timeStampRepository.getTimeStamp(scanner);

        Scanner scanner1 = fileRead.readFile(path);

        boolean isFileExists = fileExist.isFileExists(outputPath);

        Operation operation = operationFactory.getInstance(isFileExists);

        //Finding the error in the log file
        String output = operation.performOperation(scanner1,outputPath,timeStampList);

        if(output.length() != 0){
            fileWrite.writeFile(output,outputPath);
            mailSending.sendMail(mailConfiguration,emailList);
        }

    }
}
