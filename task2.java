import java.util.Random;
import java.util.Arrays;

public class task2 {

    public static int[] createArrayRandom() {
       
        int[] arrRandom = new int[11];
        Random num = new Random();
    
        for (int i = 0; i < arrRandom.length; i++) {
            arrRandom[i] = num.nextInt(0, 100);
        }
        return arrRandom;
    }

    public static int[] sortArrayBubble(int[] arr) {
       
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            
            }
        } 
        return arr; 
    }

    public static int[] mergingTwoArrays(int[] left, int[] right, int size) {
       
        int[] mergedArray = new int[size];
        int l = 0, r = 0, f = 0;

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) mergedArray[f++] = left[l++];
            else mergedArray[f++] = right[r++];
        }
        while (l < left.length) mergedArray[f++] = left[l++];
        while (r < right.length) mergedArray[f++] = right[r++];

        return mergedArray;
    }

    public static int[] mergeSorting(int[] startArr, int size) {
       
        if (size < 2) return startArr;

        int[] finishArr = new int[size];

        int midSize = size / 2;

        int[] left = new int[midSize];
        for (int i = 0; i < midSize; i++) 
            left[i] = startArr[i];
        sortArrayBubble(left);

        int[] right = new int[size - midSize];
        for (int i = midSize; i < size; i++) 
            right[i - midSize] = startArr[i];
        sortArrayBubble(right);

        finishArr = mergingTwoArrays(left, right, size);
        return finishArr;
    }


    public static void main(String[] args) {
        
        int[] arr = createArrayRandom();
        System.out.println("       заданный массив: " + Arrays.toString(arr));

        int[] arrSort = mergeSorting(arr, arr.length);
        System.out.print("отсортированный массив: " + Arrays.toString(arrSort));
    }

         
}
