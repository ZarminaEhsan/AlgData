package kap1;

import java.util.*;

/*
	I randPerm-versjonen i Programkode 1.1.8 c) brukes det en boolsk hjelpetabell.
	Gjør om metoden slik at den bruker samme idé, men uten hjelpetabellen.
	Første kall på nextInt(n) gir en indeks k. Vi legger så inn 1 i a[k].
	Neste kall på nextInt(n) gir en ny indeks k. Hvis a[k] ikke er 0, kaller vi nextInt(n) på nytt.
	Hvis derimot a[k] er 0, legger vi inn 2 i a[k].
	Osv. til hele a er fylt opp
 */

public class RandomNr {
    public static void main(String[] args){

        System.out.println(Arrays.toString(randPerm(5)));
    }

    public static int[] randPerm(int n)  {
        Random r = new Random();      // en randomgenerator
        int[] a = new int[n];         // en tabell med plass til n tall

        for (int i = 0; i < n;)  {    // vi skal legge inn n tall
            int k = r.nextInt(n);   // nextInt(n) gir en indeks k

            if(a[k] == 0){
                a[k] = i;
                i++;
            }
        }
        return a;                     // tabellen returneres
    }
}
