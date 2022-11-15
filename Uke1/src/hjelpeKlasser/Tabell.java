package hjelpeKlasser;

import java.util.*;

public class Tabell {
    private Tabell() {}   // privat standardkonstruktør - hindrer instansiering

    // Metoden bytt(int[] a, int i, int j)       Programkode 1.1.8 d)
    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Metoden randPerm(int n)                   Programkode 1.1.8 e)
    public static int[] randPerm(int n) {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    // Metoden randPerm(int[] a)               Programkode 1.1.8 f) stokker om a
    public static void randPerm(int[] a) {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a, k, i);
        }
    }

     // Metoden maks(int[] a, int fra, int til)   Programkode 1.2.1 b)
     public static int maks(int[] a, int fra, int til) {

         /*
         denne if testen kan erstattes med kall på metode  fratilKontroll(a.length,fra,til);
         og en ny if test som er for tom tabell

         if (fra < 0 || til > a.length || fra >= til)
         {
             throw new IllegalArgumentException("Illegalt intervall!");
         }

          */

         //iss test ny top per ana hai else vanlig NullPointerException error ae ga
         if (a == null) {
             throw new NullPointerException
                     ("parametertabellen a er null!");
         }

         fratilKontroll(a.length,fra,til);

         if (fra == til) {
             throw new NoSuchElementException
                     ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
         }

         int m = fra;              // indeks til største verdi i a[fra:til>
         int maksverdi = a[fra];   // største verdi i a[fra:til>

         for (int i = fra + 1; i < til; i++)
         {
             if (a[i] > maksverdi)
             {
                 m = i;                // indeks til største verdi oppdateres
                 maksverdi = a[m];     // største verdi oppdateres
             }
         }

         return m;  // posisjonen til største verdi i a[fra:til>
     }

    // Metoden maks(int[] a)                     Programkode 1.2.1 c)
    public static int maks(int[] a){
        return maks(a,0,a.length);     // kaller metoden over
    }

    // min-metodene - se Oppgave 1 i Avsnitt 1.2.1
    public static int min(int[] a, int fra, int til) {
        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;             // indeks til minste verdi i a[fra:til>
        int minverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minverdi) {
                m = i;               // indeks til minste verdi oppdateres
                minverdi = a[m];     // minste verdi oppdateres
            }
        }
        return m;  // posisjonen til minste verdi i a[fra:til>
    }

    public static int min(int[] a){  // bruker hele tabellen
        return min(a,0,a.length);     // kaller metoden over
    }

    // oppgave 3
    public static void byttChar(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    // oppgave 4 : alle på én linje og et mellomrom mellom hvert tall.
    // Ikke mellomrom og ikke linjeskift etter siste verdi.
    public static void skriv(int[] a, int fra, int til){

        fratilKontroll(a.length,fra,til);

        for(int i = fra; i < til; i++){
            System.out.print(" " + a[i]);
        }
    }

    public static void skriv(int[] a){
        skriv(a, 0, a.length);
    }

    // oppgave 5 : utskriften skal avsluttes med et linjeskift resten er samme som oppgave 4
    public static void skrivln(int[] a, int fra, int til) {

        skriv(a,fra,til);
        System.out.println();
    }

    public static void skrivln(int[] a) {
        skrivln(a, 0, a.length);
    }

    //oppgave 6 : samme som oppgave 4 men med cha[]
    public static void skrivChar(char[] c, int fra, int til){

        fratilKontroll(c.length,fra,til);

        for(int i = fra; i < til; i++){
            System.out.print(" " + c[i]);
        }
    }

    public static void skrivC(char[] a){
        skrivChar(a, 0, a.length);
    }

    //oppgave 7 :
    public static int[] naturligeTall(int n){

        //Hvis n er mindre enn 1 skal det kastes et unntak
        if(n < 1){
            throw new ArrayIndexOutOfBoundsException("n(" + n + ") er mindre enn 1!");
        }

        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = i + 1;
        }
        return a;
    }

    public static int[] heleTall(int fra, int til){

        if(fra > til){
            throw new ArrayIndexOutOfBoundsException("fra ("+fra+") er større enn til ("+til+")");
        }

        int[] a = new int[til - fra];

        if(fra == til){
            return a;
        }

        for(int i = fra; i < til; i++){
            a[i - fra] = i;
        }

        //returnere en heltallstabell som inneholder tallene fra og med fra og til
        return a;
    }

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h) {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    // oppgave : 6 sekjon 1.2.3
    public static void snu(int[] a, int v, int h){

        vhKontroll(a.length,v,h);
        System.out.println(Arrays.toString(a));

        while(v < h){
            bytt(a,v++,h--);
        }

        System.out.println(Arrays.toString(a));
    }

    public static void snuHeltabell(int[] a){

        vhKontroll(a.length,0,a.length-1);
        System.out.println(Arrays.toString(a));

        int v = 0, h = a.length-1;
        while (v < h) {
            bytt(a,v++,h--);
        }

        System.out.println(Arrays.toString(a));
    }

    // oppgave 7
    public static void snuChar(char[] a, int v, int h){

        vhKontroll(a.length,v,h);
        System.out.println(Arrays.toString(a));

        while(v < h){
            byttChar(a,v++,h--);
        }

        System.out.println(Arrays.toString(a));
    }

    // metode for den nest største verdien
    public static int[] nestMaks(int[] a){

        int n = a.length;

        if (n < 2) {          // må ha minst to verdier!
            throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");
        }

        int m = maks(a);  // m er posisjonen til tabellens største verdi
        int nm;           // nm skal inneholde posisjonen til nest største verdi

        /*
        To spesialtilfeller:
        hvis m = 0, dvs. den største verdien ligger lengst til venstre i tabellen a,
        så er intervallet til venstre for m tomt.
        Da søker vi videre kun på høyre side av m. Hvis m = a.length – 1, dvs. den største verdien ligger
        lengst til høyre, så er intervallet til høyre for m tomt. Da søker vi videre kun til venstre for m.
        */

        if (m == 0){    // den største ligger først
            nm = maks(a, 1, n);  // leter i a[1:n>
        }
        else if (m == n - 1) { // den største ligger bakerst
            nm = maks(a, 0, n - 1);    // leter i a[0:n-1>
        }
        else {
            int mv = maks(a, 0, m);              // leter i a[0:m>
            int mh = maks(a, m + 1, n);          // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1
    }

    // nest maksverdi versjon 2
    public static int[] nestMaks2(int[] a) {

        int n = a.length;

        if (n < 2) {          // må ha minst to verdier!
            throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");
        }

        int m = maks(a);  // m er posisjonen til tabellens største verdi
        int nm;           // nm skal inneholde posisjonen til nest største verdi

        bytt(a,0, m); // bytter om slik at den største kommer forrest

        nm = maks(a,1,a.length);

        if (nm == m){   // den nest største lå opprinnelig forrest
            nm = 0;
        }

        bytt(a,0,m); // bytter tilbake

        return new int[]{m, nm};      // m i posisjon 0 , nm i posisjon 1
    }

}

