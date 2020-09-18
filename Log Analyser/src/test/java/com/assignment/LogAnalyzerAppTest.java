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
import com.assignment.operations.OperationFactory;
import com.assignment.timeStamp.SavedTimeStamp;
import com.assignment.timeStamp.TimeStampRepository;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LogAnalyzerAppTest {
    OperationFactory operationFactory = new OperationFactory();

    FileExist fileExist = new FileExist();
    FileRead fileRead  = new FileRead();
    FileWrite fileWrite = new FileWrite();
    DatabaseConnection databaseConnection = new DatabaseConnection();
    EmailRepository emailRepository = new EmailRepository();
    MailConfiguration mailConfiguration = new MailConfiguration();
    MailSending mailSending = new MailSending();
    Input input = mock(Input.class);
    SavedTimeStamp savedTimeStamp = new SavedTimeStamp();
    TimeStampRepository timeStampRepository = new TimeStampRepository();

    LogAnalyzerApp app = new LogAnalyzerApp(fileRead,fileWrite,fileExist,databaseConnection,emailRepository,mailConfiguration,
            input,operationFactory,savedTimeStamp,mailSending,timeStampRepository);

    @Test
    public void should_return_scanner_object() throws IOException, NullPointerException {

        app.execute();

        String path = "C:/Users/User/Desktop/Log Analyser/src/main/resources/example.log";

        verify(fileRead).readFile(path);

    }

}