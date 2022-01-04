import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: ZJH
 * @Date: 2022/01/04/14:22
 * @Description:
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,7,4,2,6,1,4,5,6,8,29};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }

        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<>(arr.length + 1));
        }

        for (int i = 0; i < arr.length; i++) {
            int res = (arr[i] - min) / arr.length;
            bucket.get(res).add(arr[i]);
        }

        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }

        int index = 0;
        for (int i = 0; i < bucket.size(); i++) {
            for (int j = 0; j < bucket.get(i).size(); j++) {
                arr[index++] = bucket.get(i).get(j);
            }
        }
    }
}
