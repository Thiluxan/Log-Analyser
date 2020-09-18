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
    @Test
    public void should_return_emailList() throws IOException {
        OperationFactory operationFactory = new OperationFactory();
        FileExist fileExist = new FileExist();
        FileRead fileRead  = new FileRead();
        FileWrite fileWrite = new FileWrite();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        MailConfiguration mailConfiguration = new MailConfiguration();
        DataRepository dataRepository = mock(DataRepository.class);
        MailSending mailSending = new MailSending();
        Input input = mock(Input.class);
        SavedTimeStamp savedTimeStamp = new SavedTimeStamp();
        TimeStampRepository timeStampRepository = new TimeStampRepository();

        List<String> emailList = new ArrayList<>();
        emailList.add("luxanmani@gmail.com");
        emailList.add("tthilux@ymail.com");
        when(dataRepository.getData()).thenReturn(emailList);

        when(input.getInput()).thenReturn("C:/Users/User/Desktop/Log Analyser/src/main/resources/example.log");

        LogAnalyzerApp logAnalyzerApp = new LogAnalyzerApp(fileRead,fileWrite,fileExist,databaseConnection,
                dataRepository,mailConfiguration,input,operationFactory, savedTimeStamp, mailSending, timeStampRepository);
        logAnalyzerApp.execute();
        verify(dataRepository).getData();
    }

}
