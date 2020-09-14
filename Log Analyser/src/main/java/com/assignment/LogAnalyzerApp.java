package com.assignment;

import com.assignment.database.DatabaseConnection;
import com.assignment.database.EmailRepository;
import com.assignment.email.MailConfiguration;
import com.assignment.email.MailSending;
import com.assignment.fileOperations.FileExist;
import com.assignment.fileOperations.FileRead;
import com.assignment.fileOperations.FileWrite;
import com.assignment.input.Input;
import com.assignment.operations.Operation;
import com.assignment.operations.OperationFactory;
import com.assignment.timeStamp.SavedTimeStamp;
import com.assignment.timeStamp.TimeStampRepository;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class LogAnalyzerApp {
    private FileRead fileRead;
    private FileWrite fileWrite;
    private FileExist fileExist;
    private DatabaseConnection databaseConnection;
    private EmailRepository emailRepository;
    private MailConfiguration mailConfiguration;
    private Input input;
    private SavedTimeStamp savedTimeStamp;
    private MailSending mailSending;
    private TimeStampRepository timeStampRepository;
    private OperationFactory operationFactory;

    public LogAnalyzerApp(FileRead fileRead, FileWrite fileWrite, FileExist fileExist, DatabaseConnection databaseConnection,
                          EmailRepository emailRepository, MailConfiguration mailConfiguration, Input input,
                          OperationFactory operationFactory, SavedTimeStamp savedTimeStamp, MailSending mailSending,
                          TimeStampRepository timeStampRepository) {
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
        databaseConnection.connectDatabase();
        List<String> emailList = emailRepository.getEmails();

        String path = input.getInput();

        Scanner scanner = fileRead.readFile(path);

        List<String> timeStampList = timeStampRepository.getTimeStamp(scanner);

        Scanner scanner1 = fileRead.readFile(path);

        Operation operation = operationFactory.getInstance(fileExist);

        operation.performOperation(fileWrite,scanner1,savedTimeStamp,mailConfiguration,mailSending,emailList,timeStampList);

    }
}
