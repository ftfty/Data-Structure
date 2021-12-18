# 剑指offer 40. 最小的K个数

### 题目地址：[最小的K个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)



### 题目描述：

>输入整数数组 `arr` ，找出其中最小的 `k` 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。



### 解答方法：

1. 

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public void quickSort(int[] arr , int left , int right){
        if(left > right) return;
        int l = left;
        int r = right;
        int mid = l;
        while (l < r){
            while (arr[mid] <= arr[r] && l < r){
                r--;
            }
            if(arr[mid] > arr[r]){
                int temp = arr[mid];
                arr[mid] = arr[r];
                arr[r] = temp;
            }
            while (arr[mid] >= arr[r] && l < r){
                l++;
            }
            if(arr[mid] < arr[r]){
                int temp = arr[mid];
                arr[mid] = arr[l];
                arr[l] = temp;
            }
            mid = left;
        }
        quickSort(arr,left,mid-1);
        quickSort(arr,mid+1,right);
    }
}
```

> 快排优化
>
> - 不需要对整个数组进行 O(NlogN)*O*(Nl**o**gN) 的排序
> - 找到下标为k的，返回返回前面的所有数值
>
> ```java
>     public int[] getLeastNumbers(int[] arr, int k) {
>         if (arr.length == 0 || k == 0) return new int[0];
> 
>         return quickSort(arr, 0, arr.length - 1, k - 1);
>     }
> 
>     public int[] quickSort(int[] arr, int left, int right, int k) {
>         int j = partition(arr, left, right);
>         if (j == k) {
> 
>             return Arrays.copyOf(arr, j + 1);
>         }
>         return j > k ? quickSort(arr, left, j - 1, k) : quickSort(arr, j + 1, right, k);
> 
>     }
> 
>     public int partition(int arr[], int left, int right) {
>         int l = left;
>         int r = right;
>         int mid = l;
>         while (l < r) {
>             while (arr[r] >= arr[mid] && l < r) {
>                 r--;
>             }
>             if (arr[r] < arr[mid]) {
>                 int tmp = arr[r];
>                 arr[r] = arr[mid];
>                 arr[mid] = tmp;
>             }
>             while (arr[r] <= arr[mid] && l < r) {
>                 l++;
>             }
>             if (arr[mid] > arr[r]) {
>                 int tmp = arr[l];
>                 arr[l] = arr[mid];
>                 arr[mid] = tmp;
>             }
>             mid = left;
>         }
>         return mid;
>     }
> 
> 
> //    public int partition(int arr[], int left, int right){
> //        int l = left;
> //        int r = right + 1;
> //        int v = arr[left];
> //        while(true){
> //            while(--r >= left && arr[r] > v);
> //            while(++l <= right && arr[l] < v);
> //            if(l >= r) break;
> //            int tmp = arr[r];
> //            arr[r] = arr[l];
> //            arr[l] = tmp;
> //        }
> //        arr[left] = arr[r];
> //        arr[r] = v;
> //        return l;
> //    }
> ```

> 思路二：大根堆
>
> ```java
> class Solution {
>     public int[] getLeastNumbers(int[] arr, int k) {
>         if(k == 0 || arr.length == 0){
>             return new int[0];
>         }
>         int i = 0;
>         int[] result = new int[k];
>         while(i < k){
>             result[i] = arr[i];
>             i++;
>         }
>         bulidHeap(result);
>         while(i < arr.length){
>             if(result[0] > arr[i]){
>                 result[0] = arr[i];
>                 heapify(result, 0);
>             }
>             i++;
>         }
>         return result;
>     }
> 
>     public void bulidHeap(int[] arr){
>         int last = arr.length/2 - 1;
>         for(int i = last; i >=0; i--){
>             heapify(arr, i);
>         }
>     }
> 
>     public void heapify(int[] arr, int n){
>         if(n >= arr.length) return;
>         int c1 = n * 2 + 1;
>         int c2 = n * 2 + 2;
>         int max = n;
>         int len = arr.length;
>         if(c1 < len && arr[c1] > arr[max]){
>             max = c1;
>         }
>         if(c2 < len && arr[c2] > arr[max]){
>             max = c2;
>         }
>         if(max != n){
>             swap(arr, max, n);
>             heapify(arr, max);
>         }
>     }
> 
>     public void swap(int[] arr, int i, int j){
>         int temp = arr[i];
>         arr[i] = arr[j];
>         arr[j] = temp;
>     }
> ```

> 思路三：二叉搜索树
>
> ```java
> class Solution {
>     public int[] getLeastNumbers(int[] arr, int k) {
>         if(k == 0 || arr.length == 0){
>             return new int[0];
>         }
>         TreeMap<Integer,Integer> map = new TreeMap<>();
>         int cnt = 0;
>         for(int num : arr){
>             if(cnt < k){
>                 map.put(num, map.getOrDefault(num, 0)+1);
>                 cnt++;
>                 continue;
>             }
> 
>             Map.Entry<Integer,Integer> entry = map.lastEntry();
>             if(entry.getKey() > num){
>                 map.put(num, map.getOrDefault(num, 0) + 1);
>                 if(entry.getValue() == 1){
>                     map.pollLastEntry();
>                 }else{
>                     map.put(entry.getKey(), entry.getValue() - 1);
>                 }
>             }
>         }
>         int[] res = new int[k];
>         int n = 0;
>         for(Map.Entry<Integer,Integer> entry : map.entrySet()){
>             int freq = entry.getValue();
>             while(freq-- > 0){
>                 res[n++] = entry.getKey();
>             }
>         }
>         return res;
>     }
> }
> ```

> 思路四：计数排序
>
> ```java
> class Solution {
>     public int[] getLeastNumbers(int[] arr, int k) {
>         if(arr == null || k <= 0) {
>             return new int[0];
>         }
>         int[] counter = new int[10001];
>         for(int num : arr){
>             counter[num] += 1;
>         }
>         int[] res = new int[k];
>         int n = 0;
>         for(int i = 0; i < 10001; i++){
>             while(counter[i]-- > 0 && n < k){
>                 res[n++] = i;
>             }
>             if(n == k) break;
>         }
>         return res;
>     }
> }
> ```

