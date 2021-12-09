# 剑指offer 32 - III. 从上到下打印二叉树



### 题目地址：[从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)



### 题目描述：

>请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。



### 解答方法：

1. 

- 相对上一题，增加了一个变量，去隔一层进行倒序打印
- 新增一个栈来完成倒序操作

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        int n = 2;
        if(root != null) queue.add(root);
        while(!queue.isEmpty()){
            Stack<Integer> list1 = new Stack<>();
            List<Integer> list2 = new ArrayList<>();
            TreeNode temp;
            for(int i = queue.size(); i > 0; i--){
                temp = queue.poll();
                if(n % 2 != 0){
                    list1.push(temp.val);
                }else{
                    list2.add(temp.val);
                }
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            if(n % 2 != 0){
                for (int i = list1.size(); i > 0 ; i--) {
                    list2.add(list1.pop());
                }
            }
            n += 1;
            list.add(list2);
        }
        return list;
    }
}
```

> 改进思路：
>
> - 用linkedlist 的 addlast 就可以实现尾部插入，不需要使用栈，即思路二
>
> 
>
> 思路二：层序遍历 + 双端队列
>
> 1. ```java
>    tmp.addFirst(node.val)
>    ```
>
> 思路三：层序遍历 + 双端队列（奇偶层逻辑分离）
>
> ```java 
> class Solution {
>     public List<List<Integer>> levelOrder(TreeNode root) {
>         Deque<TreeNode> deque = new LinkedList<>();
>         List<List<Integer>> res = new ArrayList<>();
>         if(root != null) deque.add(root);
>         while(!deque.isEmpty()) {
>             // 打印奇数层
>             List<Integer> tmp = new ArrayList<>();
>             for(int i = deque.size(); i > 0; i--) {
>                 // 从左向右打印
>                 TreeNode node = deque.removeFirst();
>                 tmp.add(node.val);
>                 // 先左后右加入下层节点
>                 if(node.left != null) deque.addLast(node.left);
>                 if(node.right != null) deque.addLast(node.right);
>             }
>             res.add(tmp);
>             if(deque.isEmpty()) break; // 若为空则提前跳出
>             // 打印偶数层
>             tmp = new ArrayList<>();
>             for(int i = deque.size(); i > 0; i--) {
>                 // 从右向左打印
>                 TreeNode node = deque.removeLast();
>                 tmp.add(node.val);
>                 // 先右后左加入下层节点
>                 if(node.right != null) deque.addFirst(node.right);
>                 if(node.left != null) deque.addFirst(node.left);
>             }
>             res.add(tmp);
>         }
>         return res;
>     }
> }
> 
> ```
>
> 
>
> 思路四：层序遍历 + 倒序
>
> 1. 每次循环结束后，进行个判断，然后倒序
>
> > ```java
> > if(res.size() % 2 == 1) Collections.reverse(tmp);            res.add(tmp);
> > ```
>
> 