import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int arr[] = {-9,78,0,23,-567,70,90,80,79,77,999,787,666,-987};
        quickSort(  arr,0, arr.length-1);
        System.out.println("arr="+ Arrays.toString(arr));
    }
    public static void sort(int left,int right,int[] array) {
        if (left>=right) return ;
        int start=left;
        int end=right;
        int flag=left;
        while(left<right) {
            while ((left<right)&&(array[right]>=array[flag])) {
                right--;
            }
            if (array[right]<array[flag]) {
                int tmp=array[right];
                array[right]=array[flag];
                array[flag]=tmp;
                flag=right;
            }
            while ((left<right)&&(array[left]<=array[flag])) {
                left++;
            }
            if (array[left]>array[flag]) {
                int tmp=array[left];
                array[left]=array[flag];
                array[flag]=tmp;
                flag=left;
            }
        }
        sort(start, left-1, array);
        sort(left+1, end, array);
    }

    public static void quickSort(int[] arr ,int left, int right){
        if (left >= right) return ;
        int l = left;
        int r = right;
        int mid = left;
        int temp = 0;
        while(l < r){
            while(arr[mid] <= arr[r] && l < r){
                r--;
            }
            if(arr[mid] > arr[r]){
                temp = arr[mid];
                arr[mid] = arr[r];
                arr[r] = temp;
                mid = r;
            }
            while(arr[mid] >= arr[l] && l < r){
                l++;
            }
            if(arr[mid] < arr[l]){
                temp = arr[mid];
                arr[mid] = arr[l];
                arr[l] = temp;
                mid = l;
            }
        }
        quickSort(arr, left, l -1);
        quickSort(arr, l + 1,right);
    }
}
