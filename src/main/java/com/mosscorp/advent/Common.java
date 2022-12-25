package com.mosscorp.advent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Common {
    public static List<String> readTestData(final String fileName) {
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
}
