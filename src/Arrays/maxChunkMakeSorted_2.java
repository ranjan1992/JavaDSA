package Arrays;

public class maxChunkMakeSorted_2 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 4};
        System.out.println(maxChunksToSorted(arr));  // Output: 4
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        // Create maxLeft array where maxLeft[i] represents the maximum value from arr[0] to arr[i]
        maxLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        }

        // Create minRight array where minRight[i] represents the minimum value from arr[i] to arr[n-1]
        minRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], arr[i]);
        }

        // Count the number of chunks
        int chunks = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxLeft[i] <= minRight[i + 1]) {
                chunks++;
            }
        }

        // The last chunk is always counted, so add 1 to the chunk count
        return chunks + 1;
    }
}
