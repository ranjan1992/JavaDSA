package Arrays;

import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {
        int arr[] = {6,1,2,3,4,5};
        waveArray(arr);
        printArray(arr);
    }

    static void waveArray(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=1;i<n;i+=2){
            swap(arr, i, i-1);
        }

    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }


    static void printArray(int[] arr){
    for(int ele: arr){
        System.out.println(ele);
    }
    }

}
