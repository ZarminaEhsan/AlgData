package delkap_1;

import java.text.DecimalFormat;

public class HarmoniskeTall {

    public static void main(String[] args){
        int n = 638;
        double resultat = harmonisk(n);
        System.out.println("Det Harmoniske tallet blir " + resultat);


        //n = 1000 også gir 0.577... løsningen hadde 638
        double eulerResultat = euler(n);
        System.out.println("N må være "+ n + " for at vi får "  + eulerResultat);

        //skriver ut tabell 1.1.6
        String utskrift = permutasjonSnitt();
        System.out.println(utskrift);

    }

    /*
    lag metode som skal returnere harmoniske tall
    Hn er invers summen av tallene opptil 1 dvs. 1 + 1/2 + 1/3 + ... + 1/n
    */

    public static double harmonisk(int n){

        double sum = 0.0;

        for(int i = 1; i <= n; i++){
            sum += 1.0 / i;

        }
        return sum;
    }

    /*
    lag metode som returnerer differansen mellom Hn og log(n)
    bruk Math.log(n)
    hvor stor må n være for at euler(n) skal returnere et tall som starter med 0.577
    */

    public static double euler(int n){
        double hn = harmonisk(n);
        double diff = hn - Math.log(n);
        return diff;
    }

    /*
    lag en programbit som gir resultatene  i Tabell 1.1.6
    */

    public static String permutasjonSnitt(){

        double n = 10;
        double gjennomsnitt;
        DecimalFormat df = new DecimalFormat("#.#");
        String ut = "";

        for (double i = n; i <= n * 1000_000 ; i *= 10 ){
            gjennomsnitt = Math.log(i) - 0.423;
            ut += df.format(gjennomsnitt) + " " + " når n er " + i + "\n";
        }
        return ut;
    }
}

//sjekker commits