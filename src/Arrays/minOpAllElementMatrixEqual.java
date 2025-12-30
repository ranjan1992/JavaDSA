package Arrays;

import java.util.Arrays;

public class minOpAllElementMatrixEqual {
    public static void main(String[] args) {
        int a[][] = {{4,4,10}};
        int k = 2;
        System.out.println(makeMatrixEqual(a, k));
    }

    static int makeMatrixEqual(int a[][], int k){
        int n = a.length;
        if(n==0)return 0;
        int m = a[0].length;
        int total = n*m;
        int b[] = new int[total];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[i*m + j] = a[i][j];
            }
        }
        Arrays.sort(b);
        int median = b[total/2];
        System.out.println(median);

        for (int i = 0; i < total; i++) {
            System.out.println(i+" "+b[i] + " "+ makeMatrixEqualHelper(b,b[i],k));
        }
        return makeMatrixEqualHelper(b, median, k);
    }

    static int makeMatrixEqualHelper(int b[], int m, int k){
        int count=0;
        for (int i = 0; i <b.length ; i++) {
            count+=Math.abs(b[i]-m)/k;

        }
        return count;
    }
}
