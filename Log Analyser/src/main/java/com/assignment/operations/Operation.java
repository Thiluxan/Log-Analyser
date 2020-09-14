package com.assignment.operations;

import com.assignment.email.MailConfiguration;
import com.assignment.email.MailSending;
import com.assignment.fileOperations.FileWrite;
import com.assignment.timeStamp.SavedTimeStamp;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface Operation {
    void performOperation(FileWrite fileWrite, Scanner scanner, SavedTimeStamp savedTimeStamp,
                          MailConfiguration mailConfiguration, MailSending mailSending, List<String> emailList,
                          List<String> timeStampList) throws IOException;
}
