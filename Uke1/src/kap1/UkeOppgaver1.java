package kap1;

/*
Oppgave 1 og 2 :
Anta at vi har en min-metode, dvs. en metode som finner (og returnerer) posisjonen til den minste verdien i en tabell.
Hva ville metodekallet min(a) returnere med hvis a er tabellen i Figur 1.1.2? Lag denne min-metode.
[8	4	17	10	6	20	1	11	15	3	18	9	2	7	19]

*/

/*
Oppgave 3 :
Hvis den største verdien forekommer flere ganger, vil maks-metoden returnere posisjonen til den første av dem.
Hva må endres for at den skal returnere posisjonen til den siste?
*/

public class UkeOppgaver1 {

    //Oppgave 1:
    private static String min(int[] a){

        int minste = a[0];
        int posisjon = 0;

        for(int i = 0; i < a.length; i++){

            if(a[i] < minste){
                minste = a[i];
                posisjon = i;
            }
        }

        String utskrift = "Posisjonen til minste tall er " + posisjon + " og tallet er " + minste;
        return utskrift;
    }

    //Oppgave 3:
    private static String maks(int[] a){

        int maks = a[0];
        int posisjon = 0;

        for(int i = 0; i < a.length; i++){

            // erstatter dette < med dette <=
            if(a[i] >= maks){
                maks = a[i];
                posisjon = i;
            }
        }

        String utskrift = "Posisjonen til den siste største verdien " + posisjon + " og verdien er " + maks;
        return utskrift;
    }


    public static void main(String[] args){

        //array
        int[] a = {8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};

        //metodekallet min(a) og skriver ut
        String minstetall = min(a);
        System.out.println(minstetall);

        //metodekallet maks(a) og skriver ut
        String maks = maks(a);
        System.out.println(maks);

    }
}
