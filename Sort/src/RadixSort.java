import java.util.Arrays;

/**
 * @Author: ZJH
 * @Date: 2022/01/04/10:13
 * @Description:
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,7,4,2,6,1,4,5,6,8,29,120,11,13};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketCounts[digitOfElement]] = arr[j];
                bucketCounts[digitOfElement]++;
            }
            int index = 0;
            for (int j = 0; j < bucketCounts.length; j++) {
                if(bucketCounts[j] != 0){
                    for (int k = 0; k < bucketCounts[j]; k++) {
                        arr[index++] = bucket[j][k];
                    }
                }
                bucketCounts[j] = 0;
            }
        }
    }
}
