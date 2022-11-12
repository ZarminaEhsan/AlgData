package kap1;

import java.text.DecimalFormat;

public class HarmoniskTall {
    public static void main(String[] args){

        int n = 638;

        String pattern = ".###";
        DecimalFormat numberFormat = new DecimalFormat(pattern);
        double nr = harmonisk(n);

        System.out.println("Det n-te harmoniske tallet blir " + numberFormat.format(nr));
        System.out.println("Differanse blir " + euler(n));

        tabell();
    }

    public static double harmonisk(int n){
        double hn = 0.0;
        for(int  i = 1; i <= n ; i++){
            hn += 1.0 / i;
        }
        return hn;
    }

    public static double euler(int n){
        return harmonisk(n) - Math.log(n);
    }

    public static void tabell(){

        int n = 10;
        double resultat;

        String pattern = ".#";
        DecimalFormat numberFormat = new DecimalFormat(pattern);

        for(int i = 1; i <= 7 ; i++){

            resultat = Math.log(n) - 0.423;

            System.out.print(" Tallet " + n + " gir " + numberFormat.format(resultat) + "\n");
            n *= 10;
        }
    }
}
