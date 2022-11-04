package kap1;


import java.util.Arrays;

public class ArraySortingExamples {

    public static void main(String[] args){

        ///creating an instance of an array or defining an array of integer type
        int[] liste = new int []{9,8,2,1,2,3,4,5};

        // ascending order: small to big
        // example 1: with sort method
        sort(liste);


        // example2: using loop
        sort1(liste);

    }

    public static int[] sort(int[] a){

        Arrays.sort(a);

        // sort() method is of void type thats why kisi variable ko initialize nahi ker sakty with Arrays.sort(liste)
        // printing out array using loop

        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }

        System.out.println();

        //print out using toString
        System.out.println(Arrays.toString(a));

        return a;
    }

    public static int[] sort1(int[] b){

    }

}
