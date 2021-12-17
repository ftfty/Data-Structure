# 剑指offer 54. 二叉搜索树的第k大节点

### 题目地址：[二叉搜索树的第k大节点](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)



### 题目描述：

>给定一棵二叉搜索树，请找出其中第k大的节点。



### 解答方法：



> 二叉搜索树又称为二叉排序树，它或者是一棵空树，或者是具有以下性质的二叉树：
>
> - 若它的左子树不为空，则左子树上所有结点的值都小于根结点的值。
> - 若它的右子树不为空，则右子树上所有结点的值都大于根结点的值。
> - 它的左右子树也分别是二叉搜索树。



1. 就是中序遍历，然后通过链表取值

```java
class Solution {
    List<TreeNode> list =new LinkedList<>();
    public int kthLargest(TreeNode root, int k) {
        InOrder(root);
        return list.get(list.size()-k).val;
    }
    public void InOrder(TreeNode root){
        if(root == null)return;
        if(root.left != null) InOrder(root.left);
        list.add(root);
        if(root.right != null) InOrder(root.right);
    }
}
```

> 思路二：
>
> ```java
> class Solution {
>     int n,res;
>     public int kthLargest(TreeNode root, int k) {
>         n = k;
>         dfs(root);
>         return res;
>     }
>     public void dfs(TreeNode root){
>         if(root == null) return;
>         dfs(root.right);
>         if(n == 0) return;
>         if((n-=1) == 0) {
>             res = root.val;
>             return;
>         }
>         dfs(root.left);
>     }
> }
> ```
>
> 