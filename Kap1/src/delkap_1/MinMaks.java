package delkap_1;

import java.util.Arrays;

class FinnerMinMaks{

    public static int[] minmaks(int[] a){
        int[] b = {1,2};

        //sjekker hvis tabellen a er tom
        if(a.length < 1){
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }

        //bruker første verdi i a som en største verdi foreløpig
        int maks = a[0];
        int min = a[0];

        //bruker løkke for å finne største i tabellen a
        for(int i = 1; i < a.length; i++){

            if(a[i] > a[maks]){
                maks = i;
                b[1] = a[i];
            }

            else if(a[i] < a[min]){
                min = i;
                b[0] = a[i];
            }
        }

        return b;
    }
}


public class MinMaks {
    public static void main(String[] args){

        int[] a = {8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};
        FinnerMinMaks nyMinMaks = new FinnerMinMaks();

        //sender tabellen a til andre klassen
        int[] posisjonen =  FinnerMinMaks.minmaks(a);

        //skriver ut
        System.out.print(Arrays.toString(posisjonen));

    }
}
