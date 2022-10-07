package delkap_1;

public class Optimalisering1 {

    public static void main(String[] args){

        int[] a = {2,4,5,5,5,5};
        int resultat = maks(a);
        System.out.println("Indeksen til største verdien i tabellen a blir " + resultat);

        //alternative solution 1
        int resultat1 = maks1(a);
        System.out.println("Indeksen til største verdien i tabellen a blir " + resultat1);

        //alternative solution 2
        int resultat2 = maks2(a);
        System.out.println("Indeksen til største verdien i tabellen a blir " + resultat2);
    }

    //swaped >= with > in line nr. 21 and 24
    //by doing so we are getting indeks to the first iggest value

    public static int maks(int[] a) {
        int sist = a.length - 1;
        int m = 0;
        int maksverdi = a[0];
        int temp = a[sist];
        a[sist] = 0x7_fff_ffff;

        for (int i = 1; ; i++) {
            if (a[i] > maksverdi) {
                if (i == sist) {
                    a[sist] = temp;
                    return temp > maksverdi ? sist : m;
                } else {
                    maksverdi = a[i];
                    m = i;
                }
            }
        }
    }

    //Alternative solution1 from løsningsforslag

    public static int maks1(int[] a) {

        //siste posisjon i tabellen
        int sist = a.length - 1;

        //indeks til største verdien
        int m = 0;

        //største verdi
        int maksverdi = a[0];

        //siste verdien i tabellen
        int temp = a[sist];

        //legger store tall på sist
        a[sist] = 0x7_fff_ffff;

        for (int i = 1; ; i++) {
            if (a[i] >= maksverdi) {

                //sjekker om vi er ferdige
                if (i == sist) {

                    //legger siste verdien tilbake i tabellen
                    a[sist] = temp;
                    return temp > maksverdi ? sist : m;
                }
                else if(a[i] > maksverdi){
                    maksverdi = a[i];
                    m = i;
                }
            }
        }
    }


    //Alternative solution2 from løsningsforslag
    //går gjennom løkke fra høyre mot venstre
    //maksverdien som ligger lengst til venstre returneres

    public static int maks2(int[] a) {

        //indeks til størsteverdien
        int m = a.length - 1;

        //største verdien
        int maksverdi = a[m];

        //første verdi
        int temp = a[0];

        //leggen inn store tall på første indeks siden vi går gjennom løkken baklengs
        a[0] = 0x7_fff_ffff;

        //i starter med m og går mot nulte posisjon dvs starter bakerst
        for (int i = m; ; i--) {

            //
            if (a[i] >= maksverdi) {

                //sjekker om vi er fersige
                if (i == 0) {

                    //legger siste verdi tilbake
                    a[0] = temp;
                    return temp >=  maksverdi ? 0 : m;
                } else {
                    maksverdi = a[i];
                    m = i;
                }
            }
        }
    }
}
