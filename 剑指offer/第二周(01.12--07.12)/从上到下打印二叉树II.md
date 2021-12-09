# 剑指offer 32 - II. 从上到下打印二叉树



### 题目地址：[从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)



### 题目描述：

>从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。



### 解答方法：

1. 

- 每次循环queue.size次
- 把每层放在一个数组中
- 循环结束后添加在返回的list中
- 注意：for循环的条件要是 i=queue.size() ,并且i--，因为size值随时都可能变化，只有最开始的值才是这一层结点数

```java
/**
 * Definition for a binary tree node.
  
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(0);
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> linkedList = new ArrayList<>();
            for(int i =  queue.size() ; i > 0; i--){
                TreeNode temp = queue.poll();
                linkedList.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            list.add(linkedList);
        }
        return list;
    }
}
```