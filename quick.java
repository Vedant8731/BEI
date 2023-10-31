import java.util.Scanner;
import java.util.Random;
public class quick {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter the number of elements: ");
            int n = input.nextInt();
            int[] arr = new int[n];
            int[] deterministicArr = new int[n];
            int[] randomizedArr = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                arr[i] = input.nextInt();
                deterministicArr[i] = arr[i];
                randomizedArr[i] = arr[i];
            }

            System.out.println("\nSorting using Deterministic Quick Sort:");
            long startTime = System.nanoTime();
            deterministicQuickSort(deterministicArr, 0, n - 1);
            long endTime = System.nanoTime();
            System.out.println("Sorted array: ");
            printArray(deterministicArr);
            double elapsedTime = (endTime - startTime) / 1e9;
            System.out.printf("Time taken: %.6f seconds%n", elapsedTime);

            System.out.println("\nSorting using Randomized Quick Sort:");
            startTime = System.nanoTime();
            randomizedQuickSort(randomizedArr, 0, n - 1);
            endTime = System.nanoTime();
            System.out.println("Sorted array: ");
            printArray(randomizedArr);
            elapsedTime = (endTime - startTime) / 1e9;
            System.out.printf("Time taken: %.6f seconds%n", elapsedTime);
        } catch (Exception e) {
            System.out.println("Please enter a valid integer.");
        }
    }
    public static int deterministicPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    public static void deterministicQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = deterministicPartition(arr, low, high);
            deterministicQuickSort(arr, low, pivot - 1);
            deterministicQuickSort(arr, pivot + 1, high);
        }
    }

    public static int randomizedPartition(int[] arr, int low, int high) {
        Random random = new Random();
        int pivotIndex = random.nextInt(high - low + 1) + low;
        swap(arr, pivotIndex, high);
        return deterministicPartition(arr, low, high);
    }
    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, pivot - 1);
            randomizedQuickSort(arr, pivot + 1, high);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
