import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int arr[] = {3, 9, -1, 10, -2};
        boolean flag = false;
        int temp = 0;
        for(int j = 0; j < arr.length - 1; j++){
            for(int i = 0; i < arr.length -1 - j; i++){
                if(arr[i] > arr[i + 1]){
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if(flag == false){
                break;
            }else{
                flag = false;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
