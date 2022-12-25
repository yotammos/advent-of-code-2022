package com.mosscorp.advent.day2;

import com.mosscorp.advent.Common;

import java.util.List;
import java.util.Map;

public class Part2 {

    public static void main(String[] args) {
        final List<String> lines = Common.readTestData("src/main/resources/day2.txt");
        final long totalPoints = totalPoints(lines);

        System.out.println("total points = " + totalPoints);
    }

    private static long totalPoints(final List<String> lines) {
        return lines.stream().map(line -> {
            final char wantedResult = line.charAt(2);
            final char opponentMove = line.charAt(0);
            return (long) scoreRound(opponentMove, wantedResult);
        }).reduce(Long::sum).orElse(0L);
    }

    private static final Map<Character, Integer> MOVE_VALUE_MAP = Map.of(
            Move.Rock.getCharValue(), 1,
            Move.Paper.getCharValue(), 2,
            Move.Scissors.getCharValue(), 3
    );

    private static final Map<Character, Map<Character, Integer>> ROUND_VALUE_MAP = Map.of(
            Move.Rock.getCharValue(), Map.of(
                    OpponentMove.Rock.getCharValue(), 3,
                    OpponentMove.Paper.getCharValue(), 0,
                    OpponentMove.Scissors.getCharValue(), 6
            ),
            Move.Paper.getCharValue(), Map.of(
                    OpponentMove.Rock.getCharValue(), 6,
                    OpponentMove.Paper.getCharValue(), 3,
                    OpponentMove.Scissors.getCharValue(), 0
            ),
            Move.Scissors.getCharValue(), Map.of(
                    OpponentMove.Rock.getCharValue(), 0,
                    OpponentMove.Paper.getCharValue(), 6,
                    OpponentMove.Scissors.getCharValue(), 3
            )
    );

    private static final Map<Character, Map<Character, Character>> WANTED_RESULT_MOVE_MAP = Map.of(
            WantedResult.Win.getCharValue(), Map.of(
                    OpponentMove.Rock.getCharValue(), Move.Paper.getCharValue(),
                    OpponentMove.Paper.getCharValue(), Move.Scissors.getCharValue(),
                    OpponentMove.Scissors.getCharValue(), Move.Rock.getCharValue()
            ),
            WantedResult.Draw.getCharValue(), Map.of(
                    OpponentMove.Rock.getCharValue(), Move.Rock.getCharValue(),
                    OpponentMove.Paper.getCharValue(), Move.Paper.getCharValue(),
                    OpponentMove.Scissors.getCharValue(), Move.Scissors.getCharValue()
            ),
            WantedResult.Lose.getCharValue(), Map.of(
                    OpponentMove.Rock.getCharValue(), Move.Scissors.getCharValue(),
                    OpponentMove.Paper.getCharValue(), Move.Rock.getCharValue(),
                    OpponentMove.Scissors.getCharValue(), Move.Paper.getCharValue()
            )
    );

    private static int scoreRound(final char opponentMove, final char wantedResult) {
        final char move = WANTED_RESULT_MOVE_MAP.get(wantedResult).get(opponentMove);
        return MOVE_VALUE_MAP.get(move) + ROUND_VALUE_MAP.get(move).get(opponentMove);
    }
}
