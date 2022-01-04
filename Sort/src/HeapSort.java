import java.util.Arrays;

/**
 * @Author: ZJH
 * @Date: 2022/01/04/10:12
 * @Description:
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,12,3,7,4,2,6,1,4,5,6,8,29};
        heap_Sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void heap_Sort(int[] tree, int n){
        build_heap(tree, n);
        int i;
        for (i = n - 1; i >= 0; i--){
            swap(tree, i ,0);
            heapify(tree, i , 0);
        }
    }

    public static void build_heap(int[] tree, int n){
        int last_node = n - 1;
        int parent = (last_node - 1) / 2;
        int i;
        for (i = parent; i >= 0; i--) {
            heapify(tree, n , i);
        }
    }

    public static void heapify(int[] tree, int n, int i){
        if(i >= n){
            return;
        }
        int c1 = 2*i + 1;
        int c2 = 2*i + 2;
        int max = i;
        if(c1 < n && tree[c1] > tree[max]){
            max = c1;
        }
        if(c2 < n && tree[c2] > tree[max]){
            max = c2;
        }
        if(max != i){
            swap(tree, max, i);
            heapify(tree, n ,max);
        }
    }

    public static void swap(int[] tree, int max , int i){
        int temp = tree[max];
        tree[max] = tree[i];
        tree[i] = temp;
    }
}
