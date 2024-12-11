package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanFile = new Scanner(new File("src/main/resources/puzzleInputDay1.txt"));

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        int number = 0;

        while(scanFile.hasNext()) {
            String someRandomObject = scanFile.next();

            System.out.println(someRandomObject);

            if ((number % 2) == 0) {
                rightList.add(Integer.valueOf(someRandomObject));
            }else {
                leftList.add(Integer.valueOf(someRandomObject));
            }
            number++;
        }

        int totalDistance = calculateTotalDistance(leftList,rightList);

        System.out.println("Total distance: " + totalDistance);
    }

    private static int calculateTotalDistance(List<Integer> leftList, List<Integer> rightList) {
        Collections.sort(leftList);
        Collections.sort(rightList);

        int totalDistance = 0;
        for (int i = 0; i < leftList.size(); i++) {
            totalDistance += Math.abs(leftList.get(i) - rightList.get(i));
        }
        return totalDistance;
    }
}