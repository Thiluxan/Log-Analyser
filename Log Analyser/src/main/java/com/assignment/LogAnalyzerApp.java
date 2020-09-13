package com.assignment;

import com.assignment.database.DatabaseConnection;
import com.assignment.database.EmailRepository;
import com.assignment.email.MailConfiguration;
import com.assignment.email.MailSending;
import com.assignment.fileOperations.FileExist;
import com.assignment.fileOperations.FileRead;
import com.assignment.fileOperations.FileWrite;
import com.assignment.input.Input;
import com.assignment.operations.LogOperation;
import com.assignment.operations.TimeStamp;

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
    private LogOperation logOperation;
    private TimeStamp timeStamp;
    private MailSending mailSending;

    public LogAnalyzerApp(FileRead fileRead, FileWrite fileWrite, FileExist fileExist, DatabaseConnection databaseConnection, EmailRepository emailRepository,
                          MailConfiguration mailConfiguration, Input input, LogOperation logOperation,
                          TimeStamp timeStamp, MailSending mailSending) {
        this.fileRead = fileRead;
        this.fileWrite = fileWrite;
        this.fileExist = fileExist;
        this.databaseConnection = databaseConnection;
        this.emailRepository = emailRepository;
        this.mailConfiguration = mailConfiguration;
        this.input = input;
        this.logOperation = logOperation;
        this.timeStamp = timeStamp;
        this.mailSending = mailSending;
    }

    public void execute() throws IOException, NullPointerException {
        databaseConnection.connectDatabase();
        List<String> emailList = emailRepository.getEmails();

        String path = input.getInput();

        Scanner scanner = fileRead.readFile(path);

        logOperation.performOperation(fileWrite,scanner,fileExist,timeStamp,mailConfiguration, mailSending, emailList);



    }
}
