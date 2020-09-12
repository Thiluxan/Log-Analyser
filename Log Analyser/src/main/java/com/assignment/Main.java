package com.assignment;

import com.assignment.email.MailConfiguration;
import com.assignment.operation.LogOperation;

public class Main {
    public static void main(String args[]) throws Exception{
        LogOperation log = new LogOperation();
        log.performOperation();

        MailConfiguration mailConfiguration = new MailConfiguration();
        mailConfiguration.configureMail("luxanmani@gmail.com");

    }
}
