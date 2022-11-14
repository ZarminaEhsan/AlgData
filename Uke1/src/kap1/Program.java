package kap1;

// sekjon 1.1.9

import java.util.Arrays;
import java.util.Random;

public class Program {
    public static void main(String[] args){

        int n = 100_000;  // tabellstørrelse
        int sum = 0, antall = 10;

        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = i+1; // a = {1,2,3, . . }
        }

        System.out.print("Antall : ");
        for (int i = 0 ; i < antall; i++){
            randPerm(a);
            int ant = antallMaks(a);
            sum += ant;
            System.out.print(ant + " ");
        }

        double gjsnitt = (double)sum/antall;
        System.out.println("\nGjennomsnitt = " + gjsnitt);

    }

    // 1. Metoden bytt fra Programkode 1.1.8 d) skal inn her
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    // 2. Metoden randPerm fra Programkode 1.1.8 f) skal inn her
    public static void randPerm(int[] a){  // stokker om a

        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    // 3. Metoden antallMaks fra Programkode 1.1.9 a) skal inn her
    public static int antallMaks(int[] a){    // teller opp i a

        int antall = 0;            // antall tall
        int maksverdi = a[0];

        for (int i = 1; i < a.length; i++)    // går gjennom tabellen a
        {
            if (a[i] > maksverdi)    // a[i] er større enn største foran
            {
                antall++;              // har funnet et nytt tall
                maksverdi = a[i];      // oppdaterer maksverdi
            }
        }

        return antall;    // de som er større enn det største foran
    }
}
