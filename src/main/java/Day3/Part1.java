package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private Part1() {
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanFile = new Scanner(new File("src/main/resources/puzzleInputDay3.txt"));

       StringBuilder memoryBuilder = new StringBuilder();
       while (scanFile.hasNextLine()) {
           memoryBuilder.append(scanFile.nextLine());
       }
       scanFile.close();
       String memory = memoryBuilder.toString();

       System.out.println("Memory: " + memory +"\n");

       String pattern = "mul\\((\\d{1,3}),(\\d{1,3})\\)";

       Pattern regex = Pattern.compile(pattern);

       Matcher matcher = regex.matcher(memory);

       int totalSum = 0;

       while (matcher.find()) {
           int x = Integer.parseInt(matcher.group(1));
           int y = Integer.parseInt(matcher.group(2));

           totalSum += x * y;
       }

       System.out.println("Total sum of valid mul instructions: " + totalSum);

}
}
