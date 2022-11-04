package kap1;

import java.util.Arrays;

//Hvordan kan vi bruke algoritme finn maksimum til å sortere et array?
//finner maksimum tall og deretter flytter plass
//sortering er på ascending form: big to small
// took help from https://www.javatpoint.com/how-to-sort-an-array-in-java

public class Experimenting {

    public static void main(String[] args){

        int[] a = {11,17,2,18};
        System.out.println(Arrays.toString(finnMaks(a)));

    }

    public static int[] finnMaks(int[] a){

        int[] b = a.clone();

        int maks;
        int temp = 0;

        for(int i = 0; i < b.length; i++){

            for(int j = i + 1 ; j < b.length; j++){

                if(b[i] < b[j]){

                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                }
            }
        }

        return b;
    }
}
