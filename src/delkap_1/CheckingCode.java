package delkap_1;

import java.util.NoSuchElementException;

public class CheckingCode {
    public static void main(String[] args){

        int[] a = {3,6,7,9,1};

        if(a.length < 1) {
            throw new NoSuchElementException("Tabellen a er tom!");
        }

        int tall1;
        int tall2;
        int maks = 0;

        for(int i = 0; i < a.length ; i++){

            tall1 = a[i];
            tall2 = a[i++];

            if(tall1 > tall2){
                tall2 = tall1;
                maks = tall2;
            }
        }
        System.out.println(maks);
    }
}

