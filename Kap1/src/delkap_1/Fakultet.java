package delkap_1;

public class Fakultet {
    public static void main(String[] args){
        int n = 4;
        long fakultet = fak(n);
        System.out.print(fakultet);
    }

    public static long fak(int n){

        int tall;
        int fak = 1;

        if(n == 1 || n == 0 ){
            return 1;
        }

        for(int i = n; i > 1; i -= 2){
            tall = i * (i - 1);
            fak *= tall;
        }

        return fak;
    }
}
