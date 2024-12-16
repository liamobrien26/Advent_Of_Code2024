package Day4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) throws FileNotFoundException {
        // Read the input file
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
    public static int findXMAS(char[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        // Directions: {row offset, col offset}
        int[][] directions = {
            {0, 1},  // Right
            {0, -1}, // Left
            {1, 0},  // Down
            {-1, 0}, // Up
            {1, 1},  // Down-Right
            {-1, -1},// Up-Left
            {1, -1}, // Down-Left
            {-1, 1}  // Up-Right
        };
        // Loop through every cell in the grid
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Check each direction from the current cell
                for (int[] direction : directions) {
                    if (searchWord(grid, row, col, direction, "XMAS")) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private static boolean searchWord(char[][] grid, int row, int col, int[] direction, String word) {
        int rows = grid.length;
        int cols = grid[0].length;
        // Check each character in the word
        for (int i = 0; i < word.length(); i++) {
            int newRow = row + i * direction[0];
            int newCol = col + i * direction[1];
            // If out of bounds or character doesn't match, stop
            if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || grid[newRow][newCol] != word.charAt(i)) {
                return false;
            }
        }
        return true; // Found the word in this direction
    }
}