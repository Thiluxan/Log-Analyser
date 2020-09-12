package com.assignment.fileOperations;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

    public void writeFile(String text,String path) {
        try
        {
            FileWriter writer = new FileWriter(path,false);
            writer.write(text);
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
