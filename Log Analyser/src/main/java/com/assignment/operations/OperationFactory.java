package com.assignment.operations;

import com.assignment.fileOperations.FileExist;

public class OperationFactory {
    public Operation getInstance(FileExist fileExist){
        Operation operation = null;
        String outputPath = "E:\\Java\\Log Analyser\\src\\main\\resources\\output.txt";
        if(fileExist.isFileExists(outputPath)){
            operation = new FileExistOperation();
        }
        else {
            operation = new FileNotExistOperation();
        }
        return operation;
    }
}
