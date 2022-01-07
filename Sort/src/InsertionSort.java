import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: ZJH
 * @Date: 2022/01/04/10:11
 * @Description:
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,7,4,2,6,1,4,5,6,8,29};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            for(j = i - 1; j >= 0 && arr[j] > temp; j--){
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }
}
