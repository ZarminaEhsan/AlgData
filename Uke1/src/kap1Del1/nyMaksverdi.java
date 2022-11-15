package kap1Del1;

import java.util.OptionalInt;

public class nyMaksverdi {
    public static void main(String[] args){

        // to tabeller
        int[] a = {8,3,5,7,9,6,10,2,1,4}, b = {};

        OptionalInt resultat1 = maks(a);
        OptionalInt resultat2 = maks(b);

        if(resultat1.isPresent()){
            System.out.println( resultat1.getAsInt()); // utskrift: OptionalInt[6]
        }
        else {
            System.out.println("Ingen verdi!");
        }

        if(resultat2.isPresent()){
            System.out.println(resultat2.getAsInt());       // utskrift: OptionalInt.empty
        }
        else{
            System.out.println("Ingen verdi!");
        }
    }

    public static OptionalInt maks(int[] a){

        // unntak for tom tabell
        if (a.length < 1) {
            return  OptionalInt.empty(); // en konstruksjonsmetode
        }

        // startindeks og verdi
        int m = 0;
        int maksverdi = a[0];

        // bruker løkke for å finne maksverdien og deretter oppdaterer indeksen og maksverdien
        for (int i = 1; i < a.length; i++) {
            if (a[i] > maksverdi){
                m = i;
                maksverdi = a[i];
            }
        }
        return OptionalInt.of(m);  // returnerer indeksen/posisjonen til største verdi
    }
}
