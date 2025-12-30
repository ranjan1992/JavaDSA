package Arrays;

public class minimumSumSubArray {
    public static void main(String[] args) {
        int arr[] = {1,2,5,6,7,2};
        int target = 7;
        System.out.println(minimumSumSub(arr, target));


    }

    private static int minimumSumSub(int[] arr, int target) {
        int l=0, r=0;
        // int x = -1, y= -1;
        int curSum = 0;
        int minLength = Integer.MAX_VALUE;
        int n = arr.length;
        while(r<n) {
            curSum += arr[r];
            while (curSum >= target) {
                minLength = Math.min(minLength, r - l + 1);
 //                if (r - l + 1 < minLength) {
//                    minLength = r - l + 1;
//                    x = l;
//                    y = r;
//                    System.out.println(x+ "  " + y);
//                }
                curSum -= arr[l];
                l++;
            }
            r++;
        }
        if(minLength == Integer.MAX_VALUE){
            minLength = 0;
        }
        //System.out.println(x+ "  " + y);
        return minLength;
    }
}
