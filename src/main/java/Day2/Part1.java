package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.abs;

public final class Part1 {

    private Part1() {
    }

//            Report are True if:
//            -The levels are either all increasing or all decreasing
//            -Any two adjacent levels differ by at least one and at most three.
//
//            (EXAMPLES):
//
//                7 6 4 2 1: Safe because the levels are all decreasing by 1 or 2.
//                1 2 7 8 9: Unsafe because 2 7 is an increase of 5.
//                9 7 6 2 1: Unsafe because 6 2 is a decrease of 4.
//                1 3 2 4 5: Unsafe because 1 3 is increasing but 3 2 is decreasing.
//                8 6 4 4 1: Unsafe because 4 4 is neither an increase or a decrease.
//                1 3 6 7 9: Safe because the levels are all increasing by 1, 2, or 3.
    public static void main(String[] args) throws FileNotFoundException {
        int numberOfReportAreSafe = getNumberOfReportAreSafe();
        System.out.println(numberOfReportAreSafe);
    }

    private static int getNumberOfReportAreSafe() throws FileNotFoundException {
        Scanner scanFile = new Scanner(new File("src/main/resources/puzzleInputDay2.txt"));

        int numberOfReportAreSafe = 0;

        while (scanFile.hasNext()) {
            List<Integer> row = new ArrayList<>();

            for (String line : scanFile.nextLine().split(" ")) {
                row.add(Integer.parseInt(line));
            }

            if (isRowSafe(row)) {
                numberOfReportAreSafe++;
            }

        }
        return numberOfReportAreSafe;
    }
    
    static boolean isRowSafe(List<Integer> row) {
        int numberThatIncrease = 0;
        int numberThatDecrease = 0;
        int numberThatHaveValidDifference = 0;

        for (int positionOfNumber = 0; positionOfNumber < (row.size() - 1); positionOfNumber++) {
            if (row.get(positionOfNumber) > row.get(positionOfNumber + 1)) {
                numberThatIncrease++;
            }

            if (row.get(positionOfNumber) < row.get(positionOfNumber + 1)) {
                numberThatDecrease++;
            }

            int differentNumbers = abs(row.get(positionOfNumber) - row.get(positionOfNumber + 1));
            if((differentNumbers >= 1) && (differentNumbers <= 3)) {
                numberThatHaveValidDifference++;
            }
        }
        return ((numberThatIncrease == 0) || (numberThatDecrease == 0)) && (numberThatHaveValidDifference == (row.size() - 1));
    }
}


