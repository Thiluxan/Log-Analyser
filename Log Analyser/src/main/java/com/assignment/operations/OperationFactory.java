package com.assignment.operations;

public class OperationFactory {
    public Operation getInstance(boolean result){

        //Select the operation based on whether the log file is already read or not
        Operation operation = null;
        if(result){
            operation = new FileExistOperation();
        }
        else {
            operation = new FileNotExistOperation();
        }
        return operation;
    }
}
