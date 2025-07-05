package com.example;

import java.util.Scanner;

/**
 * Bin2Dec.java
 * This program converts up to 8 binary numbers (as strings) to their decimal equivalents.
 * It handles invalid inputs and checks for maximum length (32 bits).
 */
public class Bin2Dec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        for (int count = 0; count < 8; count++) {
            System.out.println("\nEnter binary number #" + (count + 1) + " (or 'q' to quit):");
            
            // Read and trim input
            String binaryString = scanner.nextLine().trim();
            
            // Check for quit command
            if (binaryString.equalsIgnoreCase("q")) {
                break;
            }
            
            // Check for empty input
            if (binaryString.isEmpty()) {
                System.out.println("Error: No input provided");
                count--; // Don't count this iteration
                continue;
            }

            // Manual validation of binary digits
            boolean isValid = true;
            for (int i = 0; i < binaryString.length(); i++) {
                char c = binaryString.charAt(i);
                if (c != '0' && c != '1') {
                    isValid = false;
                    break;
                }
            }

            // Handle invalid input
            if (!isValid) {
                System.out.println("Error: Input must contain only 0s and 1s");
                count--; // Don't count this iteration
                continue;
            }

            // Check for maximum length (32-bit integer)
            if (binaryString.length() > 32) {
                System.out.println("Warning: Input exceeds 32 bits. Result may be inaccurate.");
                // Continue processing anyway
            }

            // Convert binary string to decimal manually
            int decimal = 0;
            for (int i = 0; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '1') {
                    decimal += 1 << (binaryString.length() - 1 - i);
                }
            }
            
            // Display conversion result
            System.out.println("\nConversion results:");
            System.out.println("Binary: " + binaryString);
            System.out.println("Decimal: " + decimal);
            System.out.println("Hexadecimal: 0x" + Integer.toHexString(decimal).toUpperCase());
            System.out.println("Bit length: " + binaryString.length());
        }
        
        scanner.close();
        System.out.println("\nProgram finished. Thank you!");
    }
}