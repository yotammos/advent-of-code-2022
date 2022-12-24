package com.mosscorp.advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        final List<String> testData = readTestData("src/main/resources/day1.txt");
        final long maxElfCalories = maxElfCalories(testData);

        System.out.println("maxElfCalories = " + maxElfCalories);
    }

    private static List<String> readTestData(final String fileName) {
        final List<String> lines = new ArrayList<>();
        final File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                final String data = scanner.nextLine();
                lines.add(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lines;
    }

    private static long maxElfCalories(final List<String> lines) {
        long maxCalories = 0;
        long currentElf = 0;
        for (final String line : lines) {
            if (currentElf > maxCalories) {
                maxCalories = currentElf;
            }

            if (line.equals("")) {
                currentElf = 0;
            } else {
                final long itemCalories = Long.parseLong(line);
                currentElf += itemCalories;
            }
        }

        return maxCalories;
    }

}
