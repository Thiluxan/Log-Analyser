package com.assignment.email;

import java.util.List;

public class MailSending {
    public void sendMail(MailConfiguration mailConfiguration, List<String> emailList){
        for(String email: emailList){
            mailConfiguration.configureMail(email);
        }
    }
}
