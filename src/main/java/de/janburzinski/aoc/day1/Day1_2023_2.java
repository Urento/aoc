package de.janburzinski.aoc.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Day1_2023_2 {
    private static final Map<String, String> transformMap = Map.of(
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9"
    );

    public static void main(String[] args) {
        long totalSum = 0L;
        String filePath = "input_day1.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String str = replaceWords(line);
                totalSum += sum(str);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

        System.out.println("solution:" + totalSum);
    }

    private static String replaceWords(String s) {
        int index = Integer.MAX_VALUE;
        while (index == Integer.MAX_VALUE) {
            String first = "";
            for (Map.Entry<String, String> entry : transformMap.entrySet()) {
                int pos = s.indexOf(entry.getKey());
                if (pos != -1 && pos < index) {
                    index = s.indexOf(entry.getKey());
                    first = entry.getKey();
                }
            }
            index = -1;
            if (transformMap.containsKey(first)) {
                s = s.replace(first.substring(0, first.length() - 1), transformMap.get(first));
                index = Integer.MAX_VALUE;
            }
        }
        return s;
    }

    private static int sum(String str) {
        int flag = 0;
        int result = 0;
        char currChar = '\0';

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                currChar = str.charAt(i);
                if (flag == 0) {
                    result += 10 * (currChar - '0');
                    flag++;
                }
            }
        }
        result += (currChar - '0');
        return result;
    }
}