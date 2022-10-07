package delkap_1;


class MaksSisteIndeks{

    public int maks(int[] a){

        //sjekker hvis tabellen a er tom
        if(a.length < 1){
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }

        //bruker første verdi i a som en største verdi foreløpig
        int maks = a[0];

        //bruker løkke for å finne største i tabellen a
        for(int i = 1; i < a.length; i++){
            if( a[i] >= a[maks]){
                maks = i;
            }
        }
        return maks;
    }
}

public class MaksVerdi{
    public static void main(String[] args){

        int[] a = {8,4,17,10,6,20,1,11,15,20,18,9,2,20,19};
        MaksSisteIndeks maksSisteIndeks = new MaksSisteIndeks();

        int sisteMaksVerdi = maksSisteIndeks.maks(a);
        System.out.print("Posisjonen til den siste maks verdien er " + sisteMaksVerdi + ".");
    }
}
