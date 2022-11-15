package kap1Del1;



public class MaksTall {

    private static String makstall(int[] a){

        int maks = a[0];
        int antall = 0;

        for(int i = 1; i < a.length; i++ ){
            if(a[i] > maks){
                maks = a[i];
                antall++;
            }
        }
        String utskrift = "Makstall blir " + maks + " og antall er " + antall;
        return utskrift;
    }

    public static void main(String[] args){

        int[] tallArray = {16,3,8,19,22,7,26};
        String makstall = makstall(tallArray);
        System.out.print(makstall);
    }
}


