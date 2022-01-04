import java.util.Arrays;

/**
 * @Author: ZJH
 * @Date: 2022/01/04/10:14
 * @Description:
 */
public class QSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,7,4,2,6,1,4,5,6,8,29};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high){
        if(low >= high) return;
        int l = low;
        int h = high;
        int curr = arr[l];
        while(l < h){
            while(l < h && curr <= arr[h]){
                h--;
            }
            if(curr > arr[h]){
                arr[l] = arr[h];
                l++;
            }
            while(l < h && curr >= arr[l]){
                l++;
            }
            if(curr < arr[l]){
                arr[h] = arr[l];
                h--;
            }
        }
        arr[l] = curr;
        quickSort(arr, low, l);
        quickSort(arr, l + 1, high);
    }
}
