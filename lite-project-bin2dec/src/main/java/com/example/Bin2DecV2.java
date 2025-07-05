package com.example;

import java.math.BigInteger;
import java.util.Scanner;
/**
 * Bin2DecV2.java
 * This program converts a binary number (as a string) to its decimal equivalent.
 * It also provides the hexadecimal representation and the bit length of the binary input.
 * The program handles invalid inputs gracefully.
 */
public class Bin2DecV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter a binary number: ");
            // Read and trim input
            String binaryString = scanner.nextLine().trim();
            
            // Check for empty input
            if (binaryString.isEmpty()) {
                System.out.println("Error: Empty input");
                return;
            }

            // Validate binary digits using regex
            if (!binaryString.matches("[01]+")) {
                System.out.println("Error: Input must contain only 0s and 1s");
                return;
            }

            // Convert the binary string to a decimal number using BigInteger
            BigInteger decimal = new BigInteger(binaryString, 2);
            
            System.out.println("\nConversion results:");
            System.out.println("Binary: " + binaryString);
            System.out.println("Decimal: " + decimal);
            System.out.println("Hexadecimal: 0x" + decimal.toString(16));
            System.out.println("Bit length: " + binaryString.length());
            
        } finally {
            scanner.close();
        }
    }
}