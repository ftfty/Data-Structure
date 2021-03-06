import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args){
        int[] arr = {101, 34, 119, 1};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int arr[]){
        int temp = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
            for(int i = gap; i < arr.length; i++){
                for(int j = i - gap; j >=0; j -= gap){
                    if(arr[j] > arr[j + gap]){
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }
    public static void shellSort2(int arr[]){
        int temp = 0;
        for(int gap = arr.length / 2; gap > 0; gap /= 2){
//从第gap个元素，逐个对其所在的组进行直接插入排序
            for(int i = gap; i < arr.length; i++){
                int j = i;
                int tempe = arr[j];
                if(arr[j] < arr[j - gap]){
                    while(j - gap >= 0 && tempe < arr[j - gap]){
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    arr[j] = tempe;
                }
            }
        }
    }
}
