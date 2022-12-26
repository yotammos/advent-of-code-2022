package com.mosscorp.advent.day3;

import com.mosscorp.advent.Common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Part2 {
    public static void main(String[] args) {
        final List<String> lines = Common.readTestData("src/main/resources/day3.txt");
        final long itemPrioritiesSum = itemPrioritiesSum(lines);

        System.out.println("item priorities sum = " + itemPrioritiesSum);
    }

    private static long itemPrioritiesSum(final List<String> lines) {
        long total = 0L;
        for (int i = 0; i < lines.size() - 2; i += 3) {
            final char commonItem = findCommonItem(
                    lines.get(i),
                    lines.get(i + 1),
                    lines.get(i + 2)
            );

            total += getItemValue(commonItem);
        }

        return total;
    }

    private static int getItemValue(final char item) {
        final boolean isLowerCase = Character.toLowerCase(item) == item;
        return isLowerCase ? item - 'a' + 1 : item - 'A' + 27;
    }

    private static char findCommonItem(final String sack1, final String sack2, final String sack3) {
        final Set<Character> itemSet1 = toItemSet(sack1);
        final Set<Character> itemSet2 = toItemSet(sack2);
        final Set<Character> itemSet3 = toItemSet(sack3);

        final Map<Character, Integer> itemCount = new HashMap<>();
        for (char item : itemSet1) {
            itemCount.putIfAbsent(item, 0);
            itemCount.put(item, itemCount.get(item) + 1);
        }
        for (char item : itemSet2) {
            itemCount.putIfAbsent(item, 0);
            itemCount.put(item, itemCount.get(item) + 1);
        }
        for (char item : itemSet3) {
            itemCount.putIfAbsent(item, 0);
            itemCount.put(item, itemCount.get(item) + 1);
        }

        return itemCount
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 3)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new RuntimeException("Failed to find common item!"));
    }

    private static Set<Character> toItemSet(final String sack) {
        final Set<Character> itemSet = new HashSet<>();
        for (char item : sack.toCharArray()) {
            itemSet.add(item);
        }
        return itemSet;
    }
}
