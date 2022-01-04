import java.util.Arrays;

/**
 * @Author: ZJH
 * @Date: 2022/01/04/10:12
 * @Description:
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,1,7,4,2,6,1,4,5,6,8,29};
        mergeSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);

    }

    public static void merge(int[] arr, int start, int mid, int end){
        int Actr = start;
        int Bctr = mid + 1;
        int Cctr = 0;
        int[] temp = new int[end - start + 1];
        while(Actr <= mid && Bctr <= end){
            if(arr[Actr] <= arr[Bctr]){
                temp[Cctr++] = arr[Actr++];
            }
            else{
                temp[Cctr++] = arr[Bctr++];
            }
        }

        while(Actr <= mid){
            temp[Cctr++] = arr[Actr++];
        }
        while(Bctr <= end){
            temp[Cctr++] = arr[Bctr++];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[start++] = temp[i];
        }
    }
}
