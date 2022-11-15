package kap1Del1;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.IntSummaryStatistics;

public class AvsnittElve {
    public static void main(String ... args)
    {
        int[] a = {8,3,5,7,9,6,10,2,1,4};

        IntStream s = Arrays.stream(a);
        System.out.printf("%-8s%3d\n", "maks: ", s.max().getAsInt());

        s = Arrays.stream(a);
        System.out.printf("%-8s%3d\n", "min: ", s.min().getAsInt());

        s = Arrays.stream(a);
        System.out.printf("%-8s%3d\n", "sum: ", s.sum());

        s = Arrays.stream(a);
        System.out.printf("%-8s%3.1f\n","snitt: ", s.average().getAsDouble());

        s = Arrays.stream(a);
        IntSummaryStatistics k =  s.summaryStatistics();
        System.out.printf("%-8s%3d\n", "maks: ", k.getMax());
        System.out.printf("%-8s%3d\n", "min: ", k.getMin());
        System.out.printf("%-8s%3d\n", "sum: ", k.getSum());
        System.out.printf("%-8s%3d\n", "antall: ", k.getCount());
        System.out.printf("%-8s%3.1f\n","snitt: ", k.getAverage());
    }
}
