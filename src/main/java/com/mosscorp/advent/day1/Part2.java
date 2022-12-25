package com.mosscorp.advent.day1;

import com.mosscorp.advent.Common;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Part2 {

    public static void main(String[] args) {
        final List<String> testData = Common.readTestData("src/main/resources/day1.txt");
        final List<Long> topElves = topElvesCalories(testData, 3);

        System.out.println("top elves sum = " + topElves.stream().reduce(Long::sum));
    }

    private static List<Long> topElvesCalories(final List<String> lines, int maxGroupSize) {
        long currentElf = 0;
        List<Long> elves = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            final String line = lines.get(i);
            if (line.equals("")) {
                elves.add(currentElf);
                currentElf = 0;
            } else {
                final long itemCalories = Long.parseLong(line);
                currentElf += itemCalories;
            }
        }

        if (currentElf != 0) {
            elves.add(currentElf);
        }

        final TreeSet<Long> topElves = new TreeSet<>();
        for (long elf : elves) {
            if (topElves.size() < maxGroupSize) {
                topElves.add(elf);
            } else {
                if (topElves.size() > 0 && elf > topElves.first()) {
                    topElves.remove(topElves.first());
                    topElves.add(elf);
                }
            }
        }

        return topElves.stream().toList();
    }
}
