import java.util.Arrays;

/**
 * @Author: ZJH
 * @Date: 2022/01/04/10:11
 * @Description:
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,7,4,2,6,1,4,5,6,8,29};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int max = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[max] < arr[j]){
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
    }
}
