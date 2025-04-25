import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numbers = generate(1, 100, 10000);
        mergeSort(numbers, 0, numbers.length - 1);
        display(numbers);
    }

    // Generate 10000 random integers between 1 and 100
    public static int[] generate(int low, int high, int size) {
        int[] result = new int[size];
        Random rand = new Random();

        // Fill the array with random numbers between low and high
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(high - low + 1) + low;
        }
        return result;
    }

    // Merge Sort function
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the two halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Merge two sorted halves
    public static void merge(int[] array, int left, int mid, int right) {
        int size1 = mid - left + 1;
        int size2 = right - mid;

        int[] leftArray = new int[size1];
        int[] rightArray = new int[size2];

        // Copy data to temp arrays leftArray[] and rightArray[]
        for (int i = 0; i < size1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < size2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // Merge the temp arrays back into the original array
        while (i < size1 && j < size2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Copy any remaining elements of leftArray[], if any
        while (i < size1) {
            array[k++] = leftArray[i++];
        }

        // Copy any remaining elements of rightArray[], if any
        while (j < size2) {
            array[k++] = rightArray[j++];
        }
    }

    // Display function to print the array
    public static void display(int[] a) {
        for (int x : a) {
            System.out.print(x + "\t");
        }
    }
}
