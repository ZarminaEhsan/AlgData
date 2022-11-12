package kap1;

    /*
    Note! An empty array is an array of length zero; it has no elements int[] emptyArray = new int[0] or
    int[] arrayOfThreeZeroes = { 0, 0, 0 };

    for null array exception:
    https://stackoverflow.com/questions/2950319/is-null-check-needed-before-calling-instanceof
    "At run time, the result of the instanceof operator is true if the value of the RelationalExpression is not null
    and the reference could be cast to the ReferenceType without raising a ClassCastException.
    Otherwise the result is false."
    */

public class Testing {
    public static void main(String[] args){
        makstest();
    }

    // versjon 1 av maks-metoden
    public static int maks1(int[] a){

        // unntak for tom tabell
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }

        // indeks til foreløpig største verdi (m for maks)
        int m = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[m]){
                m = i;  // indeksen oppdateres
            }
        }

        return m;  // returnerer indeksen/posisjonen til største verdi
    }

    // versjon 2 av maks-metoden:
    /*
    I setningen int maksverdi = a[0]; vil det under kjøring av programmet bli sjekket om a er null eller ikke.
    Hvis a er null blir det kastet en NullPointerException, og det er slik det skal være.
    Hvis a er tom (a.length = 0), vil a[0] gi en ArrayIndexOutOfBoundsException.
    Hvis vi ønsker at det skal kastes en NoSuchElementException for en tom tabell, må metoden
    inneholde en test på om tabellen er tom. Da blir metoden slik:
    */
    public static int maks2(int[] a){

        // unntak for tom tabell
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }

        int m = 0;               // indeks til største verdi
        int maksverdi = a[0];    // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdateres
        }
        return m;   // returnerer indeks/posisjonen til største verdi

    }

    // versjon 3 av maks-metoden:
    /*
    Setningen int sist = a.length - 1; vil gi en NullPointerException hvis a er null.
    Setningen int maksverdi = a[0]; vil gi en en ArrayIndexOutOfBoundsException hvis a er tom.
    Hvis det skal kastes en NoSuchElementException for en tom tabell,
    må metoden inneholde en test på om tabellen er tom.
    I flg. versjon av Programkode 1.1.5 er dette gjort og det er også lagt inn kode som gjør at
    hvis den største verdien forekommer flere steder, er det posisjonen til den første av dem som returneres.
    */
    public static int maks(int[] a) {

        // unntak for tom tabell
        if (a.length < 1) {
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }

        int sisteIndeks = a.length - 1;       // siste posisjon i tabellen
        int sisteElement = a[sisteIndeks];    // tar vare på siste verdi

        int m = 0;
        int maksverdi = a[0];

        a[sisteIndeks] = maksverdi; // maksverdi legges sist istdenfor vaktpost

        for(int i = 0; ; i++){

            if(a[i] >= maksverdi){

                if(i == sisteIndeks){
                    a[sisteIndeks] = sisteElement;
                    return sisteElement > maksverdi ? sisteIndeks : m;
                }
                else if(a[i] > maksverdi){
                    maksverdi = a[i];     // maksverdi oppdateres
                    a[sisteIndeks] = maksverdi; // maksverdi legges sist igjen
                    m = i;      // m oppdateres
                }
            }
        }
    }

    //test metode
    public static void makstest() {

        // for å telle opp antall feil

        int antallFeil = 0;


        // kaller maks-metoden for å sjekke hvis maksverdien er i posisjon 6

        int[] a = {8,3,5,7,9,6,10,2,1,4};
        if (maks(a) != 6) {
            System.out.println("Test 1: Gir feil posisjon for maksverdien!");
            antallFeil++;
        }


        // oppretter ny array og kaller maks-metoden for å sjekke hvis maksverdien er i første posisjon

        a = new int[] {10,8,3,5,7,9,6,2,1,4};
        if (maks(a) != 0) {
            System.out.println("Test 2: Gir feil posisjon for maksverdien!");
            antallFeil++;
        }


        // oppretter ny array og kaller maks-metoden for å sjekke hvis maksverdien er i siste posisjon

        a = new int[] {4,8,3,5,7,9,6,2,1,10};
        if (maks(a) != 9) {
            System.out.println("Test 3: Gir feil posisjon for maksverdien!");
            antallFeil++;
        }


        // oppretter ny array og kaller maks-metoden for å sjekke hvis maksverdien er på flere steder

        a = new int[] {10,8,3,5,10,9,6,10,1,4};
        if (maks(a) != 0) {
            System.out.println("Test 4: Gir feil posisjon for maksverdien!");
            antallFeil++;
        }

        // oppretter ny array med kun én verdi og kaller maks-metoden

        a = new int[] {2};
        if (maks(a) != 0) {
            System.out.println("Test 5: Gir feil posisjon for maksverdien!");
            antallFeil++;
        }


        // oppretter ny array med to verdier som er ulike og kaller maks-metoden

        a = new int[] {2,6};
        if (maks(a) != 1) {
            System.out.println("Test 6: Gir feil posisjon for maksverdien!");
            antallFeil++;
        }


        // oppretter ny array med to verdier som er like og kaller maks-metoden

        a = new int[] {2,2};
        if (maks(a) != 0) {
            System.out.println("Test 7: Gir feil posisjon for maksverdien!");
            antallFeil++;
        }


        // oppretter ny en tom tabell, lengde lik 0 og bruker try catch for å teste metoden

        a = new int[0];
        boolean unntak = false;

        try {
            maks(a);
        }
        catch (Exception e) {
            unntak = true;
            if (!(e instanceof java.util.NoSuchElementException)){
                System.out.println("Test 8: Feil unntak for en tom tabell!");
                antallFeil++;
            }
        }

        if (!unntak){
            System.out.println("Test 9: Mangler unntak for en tom tabell!");
            antallFeil++;
        }

        // tester for null tabell

        a = null;
        unntak = false;

        try {
            maks(a);
        }
        catch (Exception e) {
            unntak = true;
            if (!(e instanceof NullPointerException)){
                System.out.println("Test 10: Feil unntak for en tom tabell!");
                antallFeil++;
            }
        }

        if (!unntak){
            System.out.println("Test 11: Mangler unntak for en null tabell!");
            antallFeil++;
        }
    }
}
