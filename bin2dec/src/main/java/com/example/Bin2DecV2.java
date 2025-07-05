package com.example;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Bin2DecV2.java
 * This program converts up to 8 binary numbers (as strings) to their decimal equivalents.
 * It also provides hexadecimal representation and bit length.
 * The program handles invalid inputs gracefully.
 */
public class Bin2DecV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Binary to Decimal Converter (v2)");
        System.out.println("Enter up to 8 binary numbers or 'q' to quit:");

        for (int count = 0; count < 8; count++) {
            try {
                System.out.print("\nEnter binary number #" + (count + 1) + ": ");
                
                // Read and trim input
                String binaryString = scanner.nextLine().trim();
                
                // Check for quit command
                if (binaryString.equalsIgnoreCase("q")) {
                    System.out.println("Exiting program...");
                    break;
                }
                
                // Check for empty input
                if (binaryString.isEmpty()) {
                    System.out.println("Error: No input provided");
                    count--; // Don't count this iteration
                    continue;
                }

                // Validate binary digits using regex
                if (!binaryString.matches("[01]+")) {
                    System.out.println("Error: Input must contain only 0s and 1s");
                    count--; // Don't count this iteration
                    continue;
                }

                // Convert the binary string to decimal using BigInteger
                BigInteger decimal = new BigInteger(binaryString, 2);
                
                // Display conversion results
                System.out.println("Conversion results:");
                System.out.println("Binary: " + binaryString);
                System.out.println("Decimal: " + decimal);
                System.out.println("Hexadecimal: 0x" + decimal.toString(16).toUpperCase());
                System.out.println("Bit length: " + binaryString.length());
                
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                count--; // Don't count this iteration
            }
        }
        
        scanner.close();
        System.out.println("\nProgram finished. Thank you!");
    }
}