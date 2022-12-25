package com.mosscorp.advent.day2;

import com.mosscorp.advent.Common;

import java.util.List;
import java.util.Map;

public class Part1 {

    public static void main(String[] args) {
        final List<String> lines = Common.readTestData("src/main/resources/day2.txt");
        final long totalPoints = totalPoints(lines);

        System.out.println("total points = " + totalPoints);
    }

    private static long totalPoints(final List<String> lines) {
        return lines.stream().map(line -> {
            final char move = line.charAt(2);
            final char opponentMove = line.charAt(0);
            return (long) scoreRound(move, opponentMove);
        }).reduce(Long::sum).orElse(0L);
    }

    private static final Map<Character, Integer> MOVE_VALUE_MAP = Map.of(
            'X', 1,
            'Y', 2,
            'Z', 3
    );

    private static final Map<Character, Map<Character, Integer>> ROUND_VALUE_MAP = Map.of(
            'X', Map.of(
                    'A', 3,
                    'B', 0,
                    'C', 6
            ),
            'Y', Map.of(
                    'A', 6,
                    'B', 3,
                    'C', 0
            ),
            'Z', Map.of(
                    'A', 0,
                    'B', 6,
                    'C', 3
            )
    );

    private static int scoreRound(final char move, final char opponentMove) {
        return MOVE_VALUE_MAP.get(move) + ROUND_VALUE_MAP.get(move).get(opponentMove);
    }
}
