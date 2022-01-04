import java.util.Arrays;

/**
 * @Author: ZJH
 * @Date: 2022/01/04/10:13
 * @Description:
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,7,4,2,6,1,4,5,6,8,29};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        int i, j ,inc, key, n;
        n = arr.length;
        for (inc = n/2; inc > 0; inc /= 2){
            for(i = inc; i < n; i++){
                key = arr[i];
                for (j = i; j >= inc && key > arr[j-inc]; j -= inc){
                    arr[j] = arr[j - inc];
                }
                arr[j] = key;
            }
        }
    }
}
