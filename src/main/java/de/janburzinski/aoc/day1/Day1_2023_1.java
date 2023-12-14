package de.janburzinski.aoc.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day1_2023_1 {
    public static void main(String[] args) {
        int solution = 0;

        try {
            byte[] lines = Files.readAllBytes(Paths.get("input_day1.txt"));
            String content = new String(lines);
            String[] splitLines = content.split("\n");

            for (String line : splitLines) {
                if (line.isEmpty()) continue;
                solution += sumOfDigits(line);
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }

        System.out.println("Solution: " + solution);
    }

    private static int sumOfDigits(String str) {
        int flag = 0;
        int num = 0;
        char currChar = '\0';

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                currChar = str.charAt(i);
                if (flag == 0) {
                    num += 10 * (currChar - '0');
                    flag++;
                }
            }
        }

        num += (currChar - '0');
        return num;
    }
}
