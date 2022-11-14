package kap1;

// sekjon 1.1.9

import java.util.Arrays;
import java.util.Random;

public class Program {
    public static void main(String[] args){

        /*
        int sum = 0;
        int antall = 10;

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
        */

        int n = 10_000;  // tabellstørrelse
        int antall = 2_000;     // antall gjentagelser
        long tid = 0;           // for tidsmåling
        int[] a = new int[n];
        Arrays.sort(a);
        randPerm(a);  // en permutasjon av 1, . .  n

        tid = System.currentTimeMillis();  // leser av klokken
        for (int i = 0; i < antall; i++) kostnader(a);
        tid = System.currentTimeMillis() - tid;  // medgått tid
        System.out.println("Faste kostnader: " + tid + " millisek");

        tid = System.currentTimeMillis();  // leser av klokken
        for (int i = 0; i < antall; i++) maks1(a);
        tid = System.currentTimeMillis() - tid;  // medgått tid
        System.out.println("Maks1-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();  // leser av klokken
        for (int i = 0; i < antall; i++) maks2(a);
        tid = System.currentTimeMillis() - tid;  // medgått tid
        System.out.println("Maks2-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();  // leser av klokken
        for (int i = 0; i < antall; i++) maks3(a);
        tid = System.currentTimeMillis() - tid;  // medgått tid
        System.out.println("Maks3-metoden: " + tid + " millisek");
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

    public static int kostnader(int[] a) // legges i class Program
    {
        int m = 0;
        for (int i = 1; i < a.length; i++) {} // en tom blokk
        return m;
    }

    public static int maks1(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1) throw new IllegalArgumentException("a er tom");

        int m = 0;  // indeks til største verdi

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] > a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    } // maks

    public static int maks2(int[] a)   // versjon 2 av maks-metoden
    {
        int m = 0;             // indeks til største verdi
        int maksverdi = a[0];  // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer indeks/posisjonen til største verdi

    } // maks


    public static int maks3(int[] a)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 1; ; i++)         // i starter med 1
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return a[sist] >= maksverdi ? sist : m; // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks
}
