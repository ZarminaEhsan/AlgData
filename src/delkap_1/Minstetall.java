package delkap_1;

class Minst{

    public int minst(int[] a){

        //sjekker hvis tabellen a er tom
        if(a.length < 1){
            throw new java.util.NoSuchElementException("Tabellen a er tom!");
        }

        //bruker første verdi i a som en minste verdi foreløpig
        int min = a[0];

        //bruker løkke for å finne minstetall i tabellen a
        for(int i = 1; i < a.length; i++){
            if( a[i] < a[min]){
                min = i;
            }
        }
        return min;
    }
}


public class Minstetall {
    public static void main(String[] args){

        int[] a = {8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};

        Minst minstetall = new Minst();
        int indeks = minstetall.minst(a);

        System.out.println("Indeksen til minstetallet er " + indeks + ".");
        System.out.println("Tallet er " + a[indeks] + ".");
    }
}
