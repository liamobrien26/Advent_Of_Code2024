package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanFile = new Scanner(new File("src/main/resources/puzzleInputDay3.txt"));

        StringBuilder memoryBuilder = new StringBuilder();

        while (scanFile.hasNextLine()) {
            memoryBuilder.append(scanFile.nextLine());
        }
        scanFile.close();

        String memory = memoryBuilder.toString();

        String mulPattern = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        String doPattern = "do\\(\\)";
        String dontPattern = "don't\\(\\)";

        Pattern mulRegex = Pattern.compile(mulPattern);

        Matcher matcher = Pattern.compile(mulPattern + "|" + doPattern + "|" + dontPattern).matcher(memory);

        boolean isEnabled = true;
        int totalSum = 0;

        while (matcher.find()) {
            String match = matcher.group();

            if (match.matches(doPattern)) {
                isEnabled = true;
            }else if (match.matches(dontPattern)) {
                isEnabled = false;
            }else if (match.matches(mulPattern) && isEnabled) {
                Matcher mulMatcher = mulRegex.matcher(match);
                if (mulMatcher.matches()) {
                    int x = Integer.parseInt(mulMatcher.group(1));
                    int y = Integer.parseInt(mulMatcher.group(2));
                    totalSum += x * y;
                }
            }
        }
        System.out.println("Total sum of enabled mul instructions: " + totalSum);
    }
}
