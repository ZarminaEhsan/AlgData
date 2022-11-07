package kap1;


import java.util.Arrays;

public class ArraySortingExamples {

    public static void main(String[] args){

        ///creating an instance of an array or defining an array of integer type
        int[] liste = new int []{9,8,2,1,2,3,4,5};
        int[] liste1 = new int []{9,8,2,1,2,3,4,5};
        int[] liste2 = new int []{9,8,2,1,2,3,4,5};

        // ascending order: small to big
        // example 1: with sort method
        int[] result = sort(liste);

        //print out using loop
        System.out.print("Using loop to print out sorted array ");
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();

        //print out using toString
        System.out.println("Using toString method to print out sorted array " + Arrays.toString(result));


        // example2: using for-loop
        result = sort1(liste1);

        //print out using toString
        System.out.println("Sorted array using loop " + Arrays.toString(result));


        // example3: using while-loop and void method
        sort2(liste2, liste2.length);

        //accessing elements of the sorted array and printing out
        System.out.print("Using while-loop inside loop to sort array ");
        int i;
        for(i = 0; i <liste2.length; i++) {
            System.out.print(liste2[i] + " ");
        }
    }

    public static int[] sort(int[] a){

        // sort() method is of void type thats why kisi variable ko initialize nahi ker sakty with Arrays.sort(liste)
        // that is why we will print out array using loop

        Arrays.sort(a);
        return a;
    }

    public static int[] sort1(int[] b){

        int temp;

        for(int i = 0; i < b.length; i++){
            for(int j = i+1 ; j < b.length; j++){
                if(b[i] > b[j]){
                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }
        return b;
    }

    public static void sort2(int[] c, int lengde){

        for(int i = 1; i < lengde; i++){

            int j = i;
            int a = c[i];

            while( j > 0 && c[j-1] > a){
                c[j] = c[j-1]; //swapping
                j--;
            }
            c[j] = a;
        }
    }
}
