package com.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class Bin2DecTest {

    @Test
    void testValidBinaryConversion() {
        String input = "1010\nq\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Bin2Dec.main(new String[]{});
        
        String output = out.toString();
        assertTrue(output.contains("Decimal: 10"));
        assertTrue(output.contains("Hexadecimal: 0xA"));
        assertTrue(output.contains("Bit length: 4"));
    }

    @Test
    void testInvalidInput() {
        String input = "102\nq\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Bin2Dec.main(new String[]{});
        
        String output = out.toString();
        assertTrue(output.contains("Error: Input must contain only 0s and 1s"));
    }

    @Test
    void testEmptyInput() {
        String input = "\nq\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Bin2Dec.main(new String[]{});
        
        String output = out.toString();
        assertTrue(output.contains("Error: No input provided"));
    }

    @Test
    void test32BitLimit() {
        String input = "11111111111111111111111111111111\nq\n"; // 32 бита
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Bin2Dec.main(new String[]{});
        
        String output = out.toString();
        assertTrue(output.contains("Decimal: -1")); // Ожидаем переполнение int
    }
}