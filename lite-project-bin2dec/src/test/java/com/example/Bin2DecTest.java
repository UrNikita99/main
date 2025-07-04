package com.example;

import org.junit.jupiter.api.Test;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class Bin2DecTest {
    @Test
    void testValidBinary() throws Exception {
        String input = "1010\n";
        String expected = "Decimal: 10";
        assertTrue(runMainAndCapture(Bin2Dec.class, input).contains(expected));
    }

    @Test
    void testInvalidBinary() throws Exception {
        String input = "10201\n";
        String expected = "Error: Input must contain only 0s and 1s";
        assertTrue(runMainAndCapture(Bin2Dec.class, input).contains(expected));
    }

    @Test
    void testEmptyInput() throws Exception {
        String input = "\n";
        String expected = "Error: No input provided";
        assertTrue(runMainAndCapture(Bin2Dec.class, input).contains(expected));
    }

    private String runMainAndCapture(Class<?> clazz, String input) throws Exception {
        InputStream sysInBackup = System.in;
        PrintStream sysOutBackup = System.out;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
        try {
            clazz.getMethod("main", String[].class).invoke(null, (Object) new String[]{});
        } finally {
            System.setIn(sysInBackup);
            System.setOut(sysOutBackup);
        }
        return out.toString();
    }
}
