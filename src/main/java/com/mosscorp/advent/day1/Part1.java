package com.mosscorp.advent.day1;

import com.mosscorp.advent.Common;

import java.util.List;

public class Part1 {

    public static void main(String[] args) {
        final List<String> testData = Common.readTestData("src/main/resources/day1.txt");
        final long maxElfCalories = maxElfCalories(testData);

        System.out.println("maxElfCalories = " + maxElfCalories);
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
