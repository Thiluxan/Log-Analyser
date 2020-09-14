package com.assignment.input;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;

public class CommandLineInputTest {

    @Test
    public void shouldTakeUserInput() // Check whether the user input and return value are same
    {
        CommandLineInput inp = new CommandLineInput();
        String input = "test.log";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("test.log", inp.getInput());
    }

}
