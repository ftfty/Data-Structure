# 剑指offer 57. 和为s的两个数字

### 题目地址：[和为s的两个数字](https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/)



### 题目描述：

>输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。



### 解答方法：

1. 

- 双指针
- 因为数组是有序的
- 当大于target，right--
- 当小于target，left++

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0,right = nums.length - 1;
        while(left < right){
            if(nums[left] + nums[right] == target){
                return new int[]{nums[left],nums[right]};
            }else if(nums[left] + nums[right] > target){
                right --;
            }else{
                left ++;
            }
        }
        return null;
    }
}
```