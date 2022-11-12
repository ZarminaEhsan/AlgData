package kap1;

import java.util.*;

public class Testverdier {
    public static void main(String[] args){

        int n = 10;
        System.out.println(Arrays.toString(randPerm(n)));

        // alternative simple way to get random permutations
        for(int i  = 0; i < 6 ; i++) {
            System.out.print(Arrays.toString(randPerm(2)) + " ");
        }

        System.out.println();

        // viser hvor lang tid det tar å generere en tilfeldig permutasjon av tallet n
        n = 5;
        long tid = System.currentTimeMillis();
        int[] a = randPerm1(n);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Det tar " + tid + " ms.");
    }

    // kodebit 1.1.8a
    public static int[] randPerm(int n)  // en versjon som ikke virker
    {
        Random r = new Random();      // en randomgenerator
        int[] a = new int[n];         // en tabell med plass til n tall

        for (int i = 0; i < n; i++)
            a[i] = r.nextInt(n) + 1;    // tabellen fylles med tall

        return a;                     // tabellen returneres
    }

    // kodebit 1.1.8b: kode virker, men er svært ineffektiv
    public static int[] randPerm1(int n){

        Random r = new Random();      // en randomgenerator
        int[] a = new int[n];         // en tabell med plass til n tall

        for (int i = 0; i < n; ){      // vi skal legge inn n tall

            int k = r.nextInt(n) + 1;   // trekker et nytt tall k

            int j = 0;
            for ( ; j < i; j++) {        // leter i intervallet a[0:i>
                if (a[j] == k){
                    break;     // stopper hvis vi har k fra før
                }
            }
            if (i == j){
                a[i++] = k;     // legger inn k og øker i
            }
        }
        return a;
    }
}
