package kap1;

/*

Syntax:
public static void sort(int[] a, int fromIndex, int toIndex)

The method parses the following three parameters:
a: An array to be sort.
fromIndex: The index of the first element of the subarray. It participates in the sorting.
toIndex: The index of the last element of the subarray. It does not participate in the sorting.

If fromIndex is equal to the toIndex, the range to be sorted is empty.
If fromIndex is greater than toIndex. It throws IllegalArgumentException.
If fromIndex < 0 or toIndex > a.length. It throws ArrayIndexOutOfBoundsException.
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortSubArray {
    public static void main(String[] args){

        //defining an array
        int[] a = {12, 90, 34, 2, 45, 3, 22, 18, 5, 78};

        // sorts subarray form index 2 to 7
        //Arrays.sort(a, 2, 7);

        //prints array using the for loop
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();

        // using loop to sort in ascending order

        int fromIndex = 2;
        int toIndex = 7;
        int temp;

        for(int i = fromIndex; i < toIndex; i++){
            for(int j = i + 1; j < toIndex; j++){
                if(a[i] > a[j]){
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));

        // using loop to print array
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
