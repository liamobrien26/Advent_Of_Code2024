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


