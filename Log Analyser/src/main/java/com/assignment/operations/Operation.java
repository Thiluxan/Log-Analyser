package com.assignment.operations;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface Operation {
    String performOperation(Scanner scanner, String errorTimeStamp,List<String> timeStampList) throws IOException;
}
