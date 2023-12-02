package arrays.prefixSum;

public class MinTimeToCollectGarbage {

    public static void main(String[] args) {

        String[] garbage = {"MMM","PGM","GP"};
        int[] travel = {3,10};
        System.out.println(garbageCollection(garbage, travel));
    }
    public static int garbageCollection(String[] garbage, int[] travel) {

        int m = 0, p = 0, g = 0;
        int mi = -1, pi = -1, gi = -1;
        int garbages = 0;
        for ( int i=garbage.length-1; i>=0; i-- ) {

            String s = garbage[i];
            garbages += s.length();
            System.out.println(garbages);
            if ( mi == -1 && s.contains("M")  )
                mi = i;

            if ( pi == -1 && s.contains("P") )
                pi = i;

            if ( gi == -1 && s.contains("G"))
                gi = i;
        }
        int[] prefixSum = new int[travel.length];
        int sum = 0;
        for ( int i=0; i<travel.length; i++ ) {
            sum += travel[i];
            prefixSum[i] = sum;
        }


        m = ( mi == -1 || mi == 0) ? 0 : prefixSum[mi - 1];
        p = ( pi == -1 || pi == 0) ? 0 : prefixSum[pi - 1];
        g = ( gi == -1 || gi == 0) ? 0 : prefixSum[gi - 1];
        System.out.println("garbages: " + garbages);
        for (int i : prefixSum )
            System.out.print(i + " ");
        System.out.println();

        return m + p + g + garbages;
    }
}
