import java.util.Arrays;

/**
 * @Author: ZJH
 * @Date: 2022/01/04/10:11
 * @Description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,7,4,2,6,1,4,5,6,8,29};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if(arr[j - 1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
