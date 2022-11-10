package kap1;

/*
 vaktpost = sentinel = stoppverdi
 Skal bruke maksimumsverdien for datatypen int, dvs. tallet 2147483647 (0x7fffffff) som vaktpost
 Når en vaktpost legges bakerst, må vi ta vare på det som opprinnelig lå der.
 */

public class Vaktpost {
    public static void main(String[] args){

        int[] tabell = {8,4,17,10,6,20,1,11,115,3,18,9,2,7,19};
        maks(tabell);
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
        int størsteverdi = a[m];

        for(int i = 0; ; i++){

            if(a[i] >= vaktpost){
                a[i] = sisteElement;

                // using break to stop code here since cannot use return as method type is void

                break;
            }
            else if (a[i] > størsteverdi ){
                størsteverdi = a[i];
                m = i;
            }
        }

        for(int liste : a){
            System.out.print(liste + " ");
        }
        System.out.println();
        System.out.println("Maks verdi blir " + størsteverdi);

    }
}
