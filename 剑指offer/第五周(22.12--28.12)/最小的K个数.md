# 剑指offer 40. 最小的K个数

### 题目地址：[最小的K个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)



### 题目描述：

>输入整数数组 `arr` ，找出其中最小的 `k` 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。



### 解答方法：

1. 

```java
class Solution {
    public int[] exchange(int[] nums) {
        //left : 偶数
        int left = 0,right = nums.length - 1;
        while(left < right){
            int temp;
            if(nums[left] % 2 == 0){
                temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            }else {
                left ++;
            }
            if(nums[right] %2 != 0){
                temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
            }else{
                right--;
            }
        }
        return nums;
    }
}
```