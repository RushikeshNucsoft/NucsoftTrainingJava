import java.util.ArrayList;
import java.util.List;

public class MissingNumbers {
    public static void main(String[] args) {
        int[] allNumbers = new int[100];
        for (int i = 0; i < allNumbers.length; i++) {
            allNumbers[i] = i + 1;
        }

        int[] numbers = {1, 2, 4, 7, 10, 15, 17, 19,  20, 30, 41, 50, 75, 100}; // Example array with some missing numbers

        List<Integer> missingNumbers = findMissingNumbers(allNumbers, numbers);
        int missingCount = missingNumbers.size();

        System.out.println("Missing Numbers:");
        for (int num : missingNumbers) {
            System.out.print(num + " ");
        }
        System.out.println("\nTotal missing count: " + missingCount);
    }

    private static List<Integer> findMissingNumbers(int[] allNumbers, int[] numbers) {
        List<Integer> missingNumbers = new ArrayList<>();

        boolean[] found = new boolean[101]; // Boolean array to track which numbers are found

        for (int num : numbers) {
            found[num] = true;
        }

        for (int num : allNumbers) {
            if (!found[num]) {
                missingNumbers.add(num);
            }
        }

        return missingNumbers;
    }
}
