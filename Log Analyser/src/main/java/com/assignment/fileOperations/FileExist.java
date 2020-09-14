package com.assignment.fileOperations;

import java.io.File;

public class FileExist {
    public boolean isFileExists(String path){
        try{
            File file = new File(path);
            return (file.length() == 0);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
