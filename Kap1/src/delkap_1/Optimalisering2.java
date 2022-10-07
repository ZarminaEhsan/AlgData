package delkap_1;

public class Optimalisering2 {

    public static void main(String[] args){

        int[] a = {6, 1, 2, 7, 5};

        int indeks = maks(a);
        System.out.println("Indeksen til største verdien er " + indeks + " som har verdi " + a[indeks]);
    }

    public static int maks(int[] a){

        int sist = a.length - 1;
        int m = 0;

        //maksverdi i foreløpig
        int maksverdi = a[0];

        // temp mein basically tabell ki last value hai which is 5v in this case
        int temp = a[sist];

        //maks value jo hum ny assume ki hai usko last mein shift ker rahy hain
        a[sist] = maksverdi;

        for (int i = 1; ; i++) {
            if (a[i] >= maksverdi) {
                if (i == sist) {

                    //legger siste verdien tilbake
                    a[sist] = temp;

                    return temp > maksverdi ? sist : m;
                } else if(a[i] > maksverdi){
                    maksverdi = a[i];
                    a[sist] = maksverdi;
                    m = i;
                }
            }
        }
    }
}
