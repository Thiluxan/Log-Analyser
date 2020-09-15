package com.assignment.operations;

public class OperationFactory {
    public Operation getInstance(boolean result){
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
