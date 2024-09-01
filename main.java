import java.util.Scanner;

public class InsertionSort {
    // performing insertion sort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]; // shift larger elements one position to the right
                j--; // move to the previous element
            }
            array[j + 1] = key; // insert the key into its correct position
            System.out.println("Step " + i + ": [" + arrayToString(array) + "]"); // print the array after each iteration
        }
    }

    // converting array
    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(", ");
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    // printing the array
    public static void printArray(int[] array) {
        System.out.println(arrayToString(array));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please input a list of numbers (use spaces): ");
            String input = scanner.nextLine();

            String[] numbers = input.split("\\s+");
            int[] array = new int[numbers.length];
            
            for (int i = 0; i < numbers.length; i++) {
                try {
                    array[i] = Integer.parseInt(numbers[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter integers separated by spaces.");
                    return;
                }
            }
            
            System.out.println("Original Array:");
            printArray(array);
            
            System.out.println("Sorting Steps:");
            insertionSort(array);
            
            System.out.println("Sorted Array:");
            printArray(array);
        }
    }
}

