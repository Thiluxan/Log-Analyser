package com.assignment.timeStamp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeStampRepository {
    public List<String> getTimeStamp(Scanner scanner)  {
        List<String> timeStampList = new ArrayList<>();
        String timeStamp;

        while (scanner.hasNextLine()){
            timeStamp = scanner.nextLine().split(" ")[0];
            timeStampList.add(timeStamp);
        }

        return timeStampList;
    }
}
