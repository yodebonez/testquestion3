import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        int[] array1 = {1, 3, 6, 4, 1, 2};
        int[] array2 = {5, -1, -3};

        System.out.println("Smallest missing + integer in array1: " + findSmallestMissingPositive(array1)); 
        System.out.println("Smallest missing + integer in array2: " + findSmallestMissingPositive(array2));
    }

    public static int findSmallestMissingPositive(int[] array) {
        Set<Integer> numberSet = new HashSet<>();

        // Add all positive numbers to the set
        for (int num : array) {
            if (num > 0) {
                numberSet.add(num);
            }
        }


        int smallestMissingPositive = 1;
        while (numberSet.contains(smallestMissingPositive)) {
            smallestMissingPositive++;
        }

        return smallestMissingPositive;
    }
}