package kap1;

/*
Oppgave 1:
vi har en min-metode, dvs. en metode som finner (og returnerer) posisjonen til den minste verdien i en tabell.
Hva ville metodekallet min(a) returnere med hvis a er tabellen i Figur 1.1.2?
[8	4	17	10	6	20	1	11	15	3	18	9	2	7	19]
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


    public static void main(String[] args){

        //array
        int[] a = {8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};

        //metodekallet min(a) og skriver ut
        String minstetall = min(a);
        System.out.print(minstetall);
    }
}
