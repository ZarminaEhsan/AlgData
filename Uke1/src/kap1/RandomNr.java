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

        int n = 10000;
        long tid = System.currentTimeMillis();
        int[] a = randPerm1(n);
        tid = System.currentTimeMillis() - tid;
        System.out.println("Programkode 1.1.8 b tar " + tid + "ms.");

        System.out.println("Effektiv kode: tabell a etter flytting " + Arrays.toString(randPerm2(5)));
        System.out.println("Oppgave 10 " + Arrays.toString(randPerm3(5)));

        int[] b = new int[] {1,2,3,4,5};
        System.out.println("Tabellen b " + Arrays.toString(b));
        randPerm4(b,0,4);

        int[] c = new int[] {1,2,3,4,5};
        System.out.println("Tabellen c " + Arrays.toString(c));
        randPerm5(c);

        n = 5;
        int k = 0;
        System.out.println("Oppgave 12 " + Arrays.toString(randPerm6(n,k)));

        ArrayList<Integer> liste = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            liste.add(i);
        }
        System.out.println("List before Shuffle : " + liste);
        Collections.shuffle(liste);
        System.out.println("List after shuffle : " + liste);

        // solution: oppgave 13
        System.out.println("Oppgave 13 " + Arrays.toString(randPerm7(5)));

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

    // randPerm from 1.1.8 b : ineffektiv
    public static int[] randPerm1(int n)  // virker, men er svært ineffektiv
    {
        Random r = new Random();      // en randomgenerator
        int[] a = new int[n];         // en tabell med plass til n tall

        for (int i = 0; i < n; )      // vi skal legge inn n tall
        {
            int k = r.nextInt(n) + 1;   // trekker et nytt tall k

            int j = 0;
            for ( ; j < i; j++)         // leter i intervallet a[0:i>
            {
                if (a[j] == k) break;     // stopper hvis vi har k fra før
            }
            if (i == j) a[i++] = k;     // legger inn k og øker i
        }
        return a;                     // tabellen returneres
    }

    // randPerm from 1.1.8 e : veldig effektiv
    public static int[] randPerm2(int n){  // en effektiv versjon

        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n
        System.out.println("Tabell a " + Arrays.toString(a));

        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        System.out.println("Tabell a versjon 2: " + Arrays.toString(a));

        for (int k = n - 1; k > 0; k--){  // løkke som går n - 1 ganger

            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }
        return a;                        // permutasjonen returneres
    }

    // randPerm from 1.1.8 e : motsatt vei : oppgave 10
    public static int[] randPerm3(int n){  // en effektiv versjon

        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        //oppretter et array
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        System.out.println("Tabell a versjon 2 for oppgave 10: " + Arrays.toString(a));

        for (int i = 0; i < n; i++){

            int k = r.nextInt(n - i) + i; // bound aesy iss liye ki hai cause white side left per hai
            bytt(a,i,k);
        }
        return a;
    }

    // Flg. metode stokker om på verdiene i tabellen a: vi får ikke ny tabell hvergang som i randPerm2/3
    public static void randPerm4(int[] b, int v, int h){

        if (v < 0 || h >= b.length)
            throw new IllegalArgumentException("Ulovlig intervall!");

        Random r = new Random();

        for (int k = h; k > v; k--) {
            int i = r.nextInt(k - v + 1);
            bytt(b,k,v + i);
        }

        System.out.println("Oppgave 11: " + Arrays.toString(b));
    }

    //example code for shuffling
    public static void randPerm5(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int i = a.length - 1; i > 0; i--)
        {
            int j = r.nextInt(i + 1);  // tilfeldig tall fra [0,k]
            bytt(a,i,j);
        }

        System.out.println("Tabellen c after shuffling " + Arrays.toString(a));

    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm6(int n, int k){

        if (k < 0 || k > n)
            throw new IllegalArgumentException("Ulovlig k!");

        int[] a = new int[n];   // fyller tabellen med 1, 2, . . , n
        for (int i = 0; i < n; i++) a[i] = i+1;

        Random r = new Random();

        for (int j = n-1; j >= n-k; j--)
        {
            int i = r.nextInt(j+1);
            bytt(a,i,j);
        }

        int[] b = new int[k];
        System.arraycopy(a,n-k,b,0,k);
        System.out.println("Oppgave 12 " + Arrays.toString(b));

        return b;   // tabellen med permutasjonen returneres
    }

    public static int[] randPerm7(int n) {
        ArrayList<Integer> liste = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) liste.add(i);

        Collections.shuffle(liste);

        int[] a = new int[n];
        int i = 0;
        for (int k : liste) a[i++] = k;

        return a;
    }

}
