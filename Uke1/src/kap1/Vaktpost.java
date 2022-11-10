package kap1;

/*
 vaktpost = sentinel = stoppverdi
 Skal bruke maksimumsverdien for datatypen int, dvs. tallet 2147483647 (0x7fffffff) som vaktpost
 Når en vaktpost legges bakerst, må vi ta vare på det som opprinnelig lå der.
 */

public class Vaktpost {
    public static void main(String[] args){

        int[] tabell = {8,4,17,10,6,20,1,115,115,3,18,9,2,7,19};
        maks(tabell);

        int result = maks1(tabell);
        System.out.println("Indeksen med alternativ metode er " + result);

        int[] tabell1 = {2,10,5,4,4};
        maks2(tabell1);
    }

    static void maks(int[] a){

        // array ka last index find ker k us mein vaktpost ki verdi add ker rahy
        //need to store last indeks value to another variabel slik at we can place it back to arrayet

        int sisteIndeks = a.length - 1;
        int sisteElement = a[sisteIndeks];
        a[sisteIndeks] = 0x7fffffff;
        int vaktpost = a[sisteIndeks];

        // indeks til foreløpig største verdi (m for maks)

        int m = 0;
        int storsteverdi = a[m];

        for(int i = 0; ; i++){

            if(a[i] >= vaktpost){
                a[i] = sisteElement;

                // using break to stop code here since cannot use return as method type is void

                break;
            }
            else if (a[i] > storsteverdi ){
                storsteverdi = a[i];
                m = i;
            }
        }

        for(int liste : a){
            System.out.print(liste + " ");
        }
        System.out.println();
        System.out.println("Maksverdi blir " + storsteverdi + " og indeksen er " + m);
    }

    static int maks1(int[] a) {
        int m = a.length - 1;          // indeks til største verdi
        int maksverdi = a[m];          // største verdi
        int temp = a[0];               // tar vare på første verdi
        a[0] = 0x7fffffff;             // legger tallet 2147483647 først

        for (int i = m; ; i--) {       // i starter bakerst
            if (a[i] >= maksverdi)       // denne blir sann for i = 0
            {
                if (i == 0)                // sjekker om vi er ferdige
                {
                    a[0] = temp;             // legger siste verdi tilbake
                    return temp >= maksverdi ? 0 : m; // er første størst?
                } else {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
        }
    }

    static void maks2(int[] a){

        int sisteIndeks = a.length - 1;       // siste posisjon i tabellen
        int sisteElement = a[sisteIndeks];    // tar vare på siste verdi

        int m = 0;
        int maksverdi = a[0];

        a[sisteIndeks] = maksverdi; // maksverdi legges sist istdenfor vaktpost

        for(int i = 1; ; i++){

            if(a[i] >= maksverdi){

                if(i == sisteIndeks){
                    a[sisteIndeks] = sisteElement;
                    break;
                }
                else if(a[i] > maksverdi){
                    maksverdi = a[i];     // maksverdi oppdateres
                    a[sisteIndeks] = maksverdi; // maksverdi legges sist igjen
                    m = i;      // m oppdateres
                }
            }
        }
        System.out.println("Maksverdi blir " + maksverdi + " og indeksen er " + m);
    }
}
