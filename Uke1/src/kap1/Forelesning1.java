package kap1;

/*
Til slutt i videoen så går vi såvidt igjennom hvordan vi kan bruke find_max(int[] a) til å sortere,
og hvordan sortering da blir en kvadratisk algoritme - mens å finne maksimum er en lineær algoritme.

videoen:  https://www.youtube.com/watch?v=Dx59JkIydJ4
*/

public class Forelesning1 {
    public static void main(String[] args) {
        int[] a = {17, 11, 4, 3};

        int max_val = max(a);
        System.out.println(max_val);
    }

    static int max(int[] a) {
        int max_value = a[0];
        for (int i=1; i<a.length; ++i) {

            /*
            Dominerende operasjoner Det er ikke vanlig å ta med alle operasjonene når en vurderer
            en algoritmes effektivitet. Det er ofte slik at én eller noen av operasjonene er viktigere,
            mer sentrale eller mer kostbare enn de andre. Slike operasjoner kalles dominerende.
            Eksempel: I maks-metoden er det å sammenligne verdier selve kjernen i algoritmen. De andre
            operasjonene er mer eller mindre en del av implementasjonen.
            Det å sammenligne er derfor den dominerende operasjonen. ->  (a[i] > max_value)

            i andre algoritmer kan det være andre typer operasjoner som er dominerende.
            I numeriske algoritmer (dvs. algoritmer som inneholder tallberegninger) kan f.eks. det å
            multiplisere eller det å dividere være den dominerende operasjonen.
             */

            if (a[i] > max_value) {
                max_value = a[i]; //Her gjør vi et nytt oppslag i a - er dette dyrt eller billig?
            }
        }
        return max_value;
    }
}
