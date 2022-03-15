# 剑指offer 57 - II. 和为s的连续正数序列



### 题目地址：[和为s的连续正数序列](https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/)



### 题目描述：

输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。



### 解答方法：

1. 滑动窗口

```java
class Solution {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 1; i < target; i++) {
            int l = i, r = l, sum = 0, count = 0;
            while (r < target) {
                sum += r;
                if (sum < target) {
                    r++;
                } else if (sum > target) {
                    break;
                } else {
                    int[] tmp = new int[r - l + 1];
                    for (int j = i; j <= r; j++) {
                        tmp[count++] = j;
                    }
                    res.add(tmp);
                    break;
                }
            }
        }
        return res.toArray(new int[0][]);
    }
}
```

- l 取值取到 target / 2 就可以
- 不用外层再加个循环， l 指针移动 
