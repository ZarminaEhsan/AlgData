package kap1;

/*
Seksjon 1.1.2
Oppgave 1 og 2 :
Anta at vi har en min-metode, dvs. en metode som finner (og returnerer) posisjonen til den minste verdien i en tabell.
Hva ville metodekallet min(a) returnere med hvis a er tabellen i Figur 1.1.2? Lag denne min-metode.
[8	4	17	10	6	20	1	11	15	3	18	9	2	7	19]

Oppgave 3 :
Hvis den største verdien forekommer flere ganger, vil maks-metoden returnere posisjonen til den første av dem.
Hva må endres for at den skal returnere posisjonen til den siste?
*/

public class UkeOppgaver1 {

    public static void main(String[] args){

        //array
        int[] a = {8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};

        //metodekallet min(a) og skriver ut
        String minstetall = min(a);
        System.out.println(minstetall);

        //metodekallet maks(a) og skriver ut
        String maks = maks(a);
        System.out.println(maks);

        //metodekallet maks(a) og skriver ut
        String maks1 = maks1(a);
        System.out.println(maks1);

    }

    //Oppgave 1 og 2:
    private static String min(int[] a){

        /*
        * sjekker tabellens lengde hvis den har lengde lik 0, er tabellen tom.
        * det gjøres ingen eksplisitt sjekk på om tabellen eksisterer, dvs. om a er null eller ikke.
        * runtime-systemet tar seg av det.
        *
        * you can have a null array reference -- the reference is null, meaning that no array actually exists.
        * you can have an array with elements that are all set to null: this is the default for an array of references
        * when it's initially created.
        *
        * Arrays are objects in Java, so any variable that declares an array holds a reference to an object.
        * If the array hasn't been created yet and you try to print the value of the variable,
        * it will print null (meaning it doesn't reference any object yet)
        *
        * In Java, all arrays are heap objects / references. And when an array is passed to a method,
        * it is handled the same way that any reference is handled; i.e. the reference is passed by value.
        * (And no, this is NOT "call by reference" or "pass by reference" as those terms are properly understood.)
        */

        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        // indeks til foreløpig minste verdi og lager en variabel som skal brukes i for-løøke for å
        // inneholde posisjon av det minste tallet.

        int minste = a[0];
        int posisjon = 0;

        // obs: starter for-løkke med i = 1
        // bruker if setning inner løkke for å oppdatere minste tall og indeksen til dette minste tallet

        for(int i = 1; i < a.length; i++){

            if(a[i] < minste){
                minste = a[i];
                posisjon = i;
            }
        }

        // returnerer minste tallet og indeksen til største verdi

        String utskrift = "Posisjonen til minste tall er " + posisjon + " og tallet er " + minste;
        return utskrift;
    }

    //Oppgave 3:
    private static String maks(int[] a){

        int maks = a[0];
        int posisjon = 0;

        for(int i = 1; i < a.length; i++){

            // erstatter dette < med dette <=
            if(a[i] >= maks){
                maks = a[i];
                posisjon = i;
            }
        }

        String utskrift = "Posisjonen til den siste største verdien " + posisjon + " og verdien er " + maks;
        return utskrift;
    }

    //Oppgave 3 alternative:
    //å gå gjennom tabellen motsatt vei, dvs. starte lengst til høyre og så gå mot venstre. Det kan kodes slik:
    private static String maks1(int[] a){

        int maks = a[a.length-1];
        int posisjon = a.length-1;

        for(int i = a.length-2; i >= 0; i--){

            // erstatter dette < med dette <=
            if(a[i] >= maks){
                maks = a[i];
                posisjon = i;
            }
        }

        String utskrift = "Posisjonen til den siste største verdien " + posisjon + " og verdien er " + maks;
        return utskrift;
    }

}
