import java.util.Arrays;

/**
 * @Author: ZJH
 * @Date: 2022/01/04/10:14
 * @Description:
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,7,4,2,6,1,4,5,6,8,29};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void countingSort(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int[] temp = new int[max+1];

        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]] += 1;
        }

        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            while (temp[i]-- != 0){
                arr[index++] = i;
            }
        }
    }
}
