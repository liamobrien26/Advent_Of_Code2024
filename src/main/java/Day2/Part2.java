package Day2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.Math.abs;

public final class Part2 {
    private Part2() {
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
            // Check if the row is safe or can become safe
            if (isRowSafe(row) || canBecomeSafe(row)) {
                numberOfReportAreSafe++;
            }
        }
        return numberOfReportAreSafe;
    }
    static boolean isRowSafe(List<Integer> row) {
        return Part1.isRowSafe(row);
    }
    static boolean canBecomeSafe(List<Integer> row) {
        for (int i = 0; i < row.size(); i++) {
            // Create a new row excluding the current level
            List<Integer> modifiedRow = new ArrayList<>(row);
            modifiedRow.remove(i);
            // Check if the modified row is safe
            if (isRowSafe(modifiedRow)) {
                return true;
            }
        }
        return false;
    }
}
