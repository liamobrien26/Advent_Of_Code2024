package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Day4.Part1.findXMAS;

public class part2 {


    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanFile = new Scanner(new File("src/main/resources/puzzleInputDay4.txt"));

        List<String> lines = new ArrayList<>();
        while (scanFile.hasNextLine()) {
            lines.add(scanFile.nextLine());
        }
        scanFile.close();
        // Convert the input into a character grid
        char[][] grid = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            grid[i] = lines.get(i).toCharArray();
        }
        // Search for "XMAS" in all directions
        int totalCount = findXMAS(grid);
        System.out.println("Total number of 'XMAS' found: " + totalCount);

    }

    public static int findDiagonal(List<List<Character>> listOfLists) {
        List<Character> xmas = List.of('M', 'A', 'S');
        int diagonal = 0;
        for (int i = 1; i < listOfLists.size()-1; i++) {
            for (int j = 1; j < listOfLists.get(i).size()-1; j++) {
                if (listOfLists.get(i).get(j) == xmas.get(1)) {
                    if (((listOfLists.get(i - 1).get(j - 1) == xmas.get(0)) &&
                         (listOfLists.get(i + 1).get(j + 1) == xmas.get(2))) ||
                        ((listOfLists.get(i - 1).get(j - 1) == xmas.get(2)) &&
                         (listOfLists.get(i + 1).get(j + 1) == xmas.get(0)))) {
                        if (((listOfLists.get(i - 1).get(j + 1) == xmas.get(2)) &&
                             (listOfLists.get(i + 1).get(j - 1) == xmas.get(0))) ||
                            ((listOfLists.get(i - 1).get(j + 1) == xmas.get(0)) &&
                             (listOfLists.get(i + 1).get(j - 1) == xmas.get(2)))) {
                            diagonal++;
                        }
                    }
                }
            }
        }
        return diagonal;

    }

}