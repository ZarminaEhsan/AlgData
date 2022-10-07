package delkap_1;
//eksempel 1.1.5

public class Optimalisering {
    public static void main(String[] args){

        int[] a = {8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};

        //oppgave 1.1.5: 1 hva skjer hvis a har lengde 1 og a er tom dvs. a har lengde 0?

        //for lengde 1 fungerer kode som vanlig mens tom tabellen gir error
        int[] b = {9};

        //denne kodesetningen gir error
        //int[] c = {};


        int resultat = maks(a);
        int resultat1 = maks(b);
        //int resultat2 = maks(c);


        System.out.println("Indeksen til største verdien i tabellen a blir " + resultat);
        System.out.println("Indeksen til største verdien i tabellen b blir " + resultat1);
        //System.out.println("Indeksen til største verdien i tabellen c blir " + resultat2);
    }

    public static int maks(int[] a) {
        int sist = a.length - 1;
        int m = 0;
        int maksverdi = a[0];
        int temp = a[sist];
        a[sist] = 0x7_fff_ffff;

        for (int i = 0; ; i++) {
            if (a[i] >= maksverdi) {
                if (i == sist) {
                    a[sist] = temp;
                    return temp >= maksverdi ? sist : m;
                } else {
                    maksverdi = a[i];
                    m = i;
                }
            }
        }
    }
}

