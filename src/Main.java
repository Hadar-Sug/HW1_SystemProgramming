import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Character; //not sure this is allowed, but it doesnt say it isnt allowed


public class Main {
    /**
     * Prints a message according to a given grade.
     * <p>
     * It is guaranteed that the grade is within the range [0, 100].
     *
     * @param grade The grade
     */
    public static void gradeMessage(int grade) {
        switch (grade) {
            case 100 -> System.out.println("Excellent");
            case 99 -> System.out.println("Great");
            case 98 -> System.out.println("Great");
            case 97 -> System.out.println("Great");
            case 96 -> System.out.println("Great");
            case 95 -> System.out.println("Great");
            case 94 -> System.out.println("Great");
            case 93 -> System.out.println("Great");
            case 92 -> System.out.println("Great");
            case 91 -> System.out.println("Great");
            case 90 -> System.out.println("Great");
            case 89 -> System.out.println("Very Good");
            case 88 -> System.out.println("Very Good");
            case 87 -> System.out.println("Very Good");
            case 86 -> System.out.println("Very Good");
            case 85 -> System.out.println("Very Good");
            case 84 -> System.out.println("Very Good");
            case 83 -> System.out.println("Very Good");
            case 82 -> System.out.println("Very Good");
            case 81 -> System.out.println("Very Good");
            case 80 -> System.out.println("Very Good");
            case 79 -> System.out.println("Good");
            case 78 -> System.out.println("Good");
            case 77 -> System.out.println("Good");
            case 76 -> System.out.println("Good");
            case 75 -> System.out.println("Good");
            case 74 -> System.out.println("Good");
            case 73 -> System.out.println("Good");
            case 72 -> System.out.println("Good");
            case 71 -> System.out.println("Good");
            case 70 -> System.out.println("Good");
            default -> System.out.println("OK");
        }
        // no explanation needed   :)
    }

    /**
     * Compresses a given string.
     * <p>
     * The compression process is done by replacing a sequence of identical consecutive characters
     * with that same character followed by the length of sequence.
     * <p>
     * It is guaranteed that the string contains only letters (lowercase and uppercase).
     *
     * @param stringToCompress The string to compress
     * @return The compressed version of the string
     */
    public static String compressString(String stringToCompress) {
        String compressedString = "";
        int countConsecutive = 0;
        for (int i = 0; i < stringToCompress.length(); i++) {
            countConsecutive++;
// If next character is different than current append this char to result
            if (i + 1 >= stringToCompress.length() || stringToCompress.charAt(i) != stringToCompress.charAt(i + 1)) {
                compressedString = compressedString + stringToCompress.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }//took this part from the tutorial, delete this comment after you read this ;)
        return compressedString;
    }

    /**
     * Decompresses a given string.
     * <p>
     * The decompression process is done by duplicating each sequence of characters
     * according to the number which appears after the sequence.
     * <p>
     * It is guaranteed that the string is a legal compressed string.
     *
     * @param compressedString The string to decompress
     * @return The decompressed string
     */
    public static String decompressString(String compressedString) {
        String decompressedString = "";
        for (int i = 0; i < compressedString.length(); i++) {
            char current = compressedString.charAt(i);
            if (!Character.isDigit(current)) {
                decompressedString = decompressedString + compressedString.charAt(i);
            } //if current character isnt a number, just add it to our wanted string
            else {
                int j = 0;
                int decompNum = 0;
                while (Character.isDigit(compressedString.charAt(i + j))) {
                    decompNum += (Character.getNumericValue(compressedString.charAt(i))) * Math.pow(10, j);
                    j++;
                }
                decompressedString = decompressedString + decompNum * compressedString.charAt(i - 1);
            }
        }
        /*
         * if it is a number, we start a loop to check if its >10.
         * we do this using j, which goes over the number until it reaches a letter.
         * so, decompNum sums up the amount of letters we must add to the string.
         * */
        return decompressedString;
    }

    /**
     * Calculates the tax of a given salary.
     * <p>
     * The tax is calculated according to the tax brackets method.
     *
     * @param salary The salary
     * @return The tax for the given salary
     */
    public static double calculateTax(int salary) {
        double tax = 0.0;
        int salaryStep = 5000;
        double[] steps = {0.1, 0.14, 0.2, 0.31, 0.35, 0.5};
        int i = 0;
        while ((salary - salaryStep) > 0) {
            tax += salary * steps[i++];
            salary -= salaryStep;
        }
        tax += salary * steps[i];
        // need to change the constants here to constant variables, didnt know how to do that.
        return tax;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = args[0];
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        // Tests for part A
        System.out.println("---------- Tests for part A ----------");
        int numberOfGrades = scanner.nextInt();
        for (int i = 0; i < numberOfGrades; i++) {
            int grade = scanner.nextInt();
            gradeMessage(grade);
        }

        // Tests for part B1
        System.out.println("\n---------- Tests for part B1 ----------");
        int numberOfStringsToCompress = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfStringsToCompress; i++) {
            String stringToCompress = scanner.nextLine();
            String compressedString = compressString(stringToCompress);
            System.out.println("The compressed version of " + stringToCompress + " is " + compressedString);
        }

        // Tests for part B2
        System.out.println("\n---------- Tests for part B2 ----------");
        int numberOfDecompressedStrings = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfDecompressedStrings; i++) {
            String compressedString = scanner.nextLine();
            String decompressedString = decompressString(compressedString);
            System.out.println("The decompressed version of " + compressedString + " is " + decompressedString);
        }

        // Tests for both part B1 and B2
        System.out.println("\n---------- Tests for parts B1 and B2 ----------");
        int numberOfCombinedTests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfCombinedTests; i++) {
            String stringToCompress = scanner.nextLine();
            String compressedString = compressString(stringToCompress);
            String decompressedString = decompressString(compressedString);
            boolean isEqual = stringToCompress.equals(decompressedString);
            System.out.println("decompress(compress(" + stringToCompress + ")) == " + stringToCompress + "? " + isEqual);
        }

        // Tests for part C
        System.out.println("\n---------- Tests for part C ----------");
        int numberOfSalaries = scanner.nextInt();
        for (int i = 0; i < numberOfSalaries; i++) {
            int salary = scanner.nextInt();
            double tax = calculateTax(salary);
            System.out.println("The tax for salary of " + salary + "₪ is " + tax + "₪");
        }
    }
}
