package com.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class Bin2DecV2Test {

    @Test
    void testValidBinaryConversion() {
        String input = "1010\nq\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Bin2DecV2.main(new String[]{});
        
        String output = out.toString();
        assertTrue(output.contains("Decimal: 10"));
        assertTrue(output.contains("Hexadecimal: 0xA"));
        assertTrue(output.contains("Bit length: 4"));
    }

    @Test
    void testLargeBinaryNumber() {
        String input = "111111111111111111111111111111111\nq\n"; // 33 бита
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Bin2DecV2.main(new String[]{});
        
        String output = out.toString();
        assertTrue(output.contains("Decimal: 8589934591")); // BigInteger корректно обрабатывает
    }

    @Test
    void testEarlyExit() {
        String input = "q\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Bin2DecV2.main(new String[]{});
        
        String output = out.toString();
        assertTrue(output.contains("Exiting program"));
        assertFalse(output.contains("Conversion results"));
    }

    @Test
    void testMultipleInputs() {
        String input = "1010\n1100\nq\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        
        Bin2DecV2.main(new String[]{});
        
        String output = out.toString();
        assertTrue(output.contains("Binary: 1010"));
        assertTrue(output.contains("Binary: 1100"));
        assertTrue(output.contains("Decimal: 12")); // Проверяем второе число
    }
}