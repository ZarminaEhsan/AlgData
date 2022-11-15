package kap1Del1;

// sekjon 1.1.9

import java.util.*;

//importing package which is created here: syntax: nameOfPackage.*; * means all classes in that package

import hjelpeKlasser.*;

public class Program {
    public static void main(String[] args){

        int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) {
            System.out.print(k + " ");  // skriver ut a
        }

        int maks = Tabell.maks(a);   // finner posisjonen til største verdi
        int min = Tabell.min(a);   // finner posisjonen til største verdi
        System.out.println("\nMaksverdi har indeks " + maks);
        System.out.println("\nMinstverdi har indeks " + min);

        char[] c = {'A','B','C','D','E','F','G','H','I','J'};  // 10 bokstaver
        for (char k : c){
            System.out.print(k + " ");     // kopien d skrives ut
        }
        System.out.println();
        Tabell.byttChar(c,0,9);
        for (char k : c){
            System.out.print(k + " ");     // kopien d skrives ut
        }

        a = new int[]{1,2,3,4,5};
        System.out.println();
        Tabell.skriv(a);
        System.out.println();
        Tabell.skriv(a);
        System.out.println();
        Tabell.skrivC(c);
        System.out.println();

        System.out.println(Arrays.toString(Tabell.naturligeTall(6)));
        System.out.println(Arrays.toString(Tabell.heleTall(1,6)));

        a = Tabell.randPerm(10);
        // Tabell.maks(a,-1,10);
        // Tabell.maks(a,0,11);
        // Tabell.maks(a,10,0);
        // Tabell.maks(a,0,0);
        // a = null;
        // Tabell.maks(a,0,0);

        Tabell.snu(a,2,8);
        Tabell.snuHeltabell(a);

        Tabell.snuChar(c,0,9);

        a = Tabell.randPerm(10); // tilfeldig permutasjon av 1 . . 10
        System.out.print("Den nest maksverdi versjon 1: ");
        int[] b = Tabell.nestMaks(a);  // metoden returnerer en tabell
        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks
        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Maksverdi(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest maksverdi(" + a[nm] + ") har posisjon " + nm);


        System.out.print("Den nest maksverdi versjon 2: ");
        b = Tabell.nestMaks2(a);  // metoden returnerer en tabell
        m = b[0];  // m for maks
        nm = b[1];  // nm for nestmaks
        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Maksverdi(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest maksverdi(" + a[nm] + ") har posisjon " + nm);

    }
}
