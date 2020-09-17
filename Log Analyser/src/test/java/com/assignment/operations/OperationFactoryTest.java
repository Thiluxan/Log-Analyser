package com.assignment.operations;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

public class OperationFactoryTest {

    @Test
    public void should_return_FileExist_when_provide_true(){
        OperationFactory operationFactory = new OperationFactory();
        Operation operation = operationFactory.getInstance(true);

        assertThat(operation,instanceOf(FileExistOperation.class));
    }

    @Test
    public void should_return_FileNotExist_when_provide_false(){
        OperationFactory operationFactory = new OperationFactory();
        Operation operation = operationFactory.getInstance(false);

        assertThat(operation,instanceOf(FileNotExistOperation.class));
    }

}