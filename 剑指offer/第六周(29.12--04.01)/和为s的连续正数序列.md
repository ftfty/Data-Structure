# 剑指offer 57 - II. 和为s的连续正数序列



### 题目地址：[和为s的连续正数序列](https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/)



### 题目描述：

输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。



### 解答方法：

1. 

```java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            if((n & 1) == 1) {
                res++;
            }
            n >>>= 1;
        }
        return res;
    }
}
```

