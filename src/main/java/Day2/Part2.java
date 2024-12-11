package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Part2 {
    public static void main(String[] args) throws FileNotFoundException {

        String breakingDownTaskPartOnce = """
            Problem Dampener
            
            """;

        int numberOfReportAreSafe = getNumberOfReportAreSafe();
        System.out.println(numberOfReportAreSafe);
    }

    private static int getNumberOfReportAreSafe() throws FileNotFoundException {
        Scanner scanFile = new Scanner(new File("src/main/resources/puzzleInputDay2.txt"));

        int numberOfReportAreSafe = 0;

        while (scanFile.hasNext()) {
            List<Integer> aListOfNumbers = new ArrayList<>();

            for (String line : scanFile.nextLine().split(" ")) {
                aListOfNumbers.add(Integer.parseInt(line));
            }

            if(Part1.isRowSafe(aListOfNumbers)) {
                numberOfReportAreSafe++;
            }

        }
        return numberOfReportAreSafe;
    }
}


