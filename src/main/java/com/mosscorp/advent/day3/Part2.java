package com.mosscorp.advent.day3;

import com.mosscorp.advent.Common;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Part1 {
    public static void main(String[] args) {
        final List<String> lines = Common.readTestData("src/main/resources/day3.txt");
        final long itemPrioritiesSum = itemPrioritiesSum(lines);

        System.out.println("item priorities sum = " + itemPrioritiesSum);
    }

    private static long itemPrioritiesSum(final List<String> lines) {
        return lines.stream().map(line -> {
            final String sack1 = line.substring(0, line.length() / 2);
            final String sack2 = line.substring(line.length() / 2);

            final char commonItem = findCommonItem(sack1, sack2);
            return (long) getItemValue(commonItem);
        })
                .reduce(Long::sum)
                .orElse(0L);
    }

    private static int getItemValue(final char item) {
        final boolean isLowerCase = Character.toLowerCase(item) == item;
        return isLowerCase ? item - 'a' + 1 : item - 'A' + 27;
    }

    private static char findCommonItem(final String sack1, final String sack2) {
        final Set<Character> itemSet = new HashSet<>();

        for (char item : sack1.toCharArray()) {
            itemSet.add(item);
        }

        for (char item : sack2.toCharArray()) {
            if (itemSet.contains(item)) {
                return item;
            }
        }

        throw new RuntimeException("Failed to find common item!");
    }
}
