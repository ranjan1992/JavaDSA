package DynamicProgramming_Standard;

public class ClimbStairsProblem{
    public static void main(String[] args) {
        System.out.println(nCr(4,2));
    }
    static int nCr(int n, int r) {
        if(n==r || r==0) return 1;
        return nCr(n-1, r-1) + nCr(n-1, r);
    }
}
