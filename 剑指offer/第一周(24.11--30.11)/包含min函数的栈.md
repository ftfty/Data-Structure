# 剑指offer 30. 包含min函数的栈



### 题目地址：[包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)



### 题目描述：

>定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。



### 解答方法：

1. 

```java
class MinStack {
    node first ;
    class node{
        int value;
        node next;
        node(int value){
            this.value = value;
            this.next = null;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {
    }
//push的时候用头插法，添加在在first后面
    public void push(int x) {
        if(first == null) {
            first = new node(x);
        }else if(first.value > x){
            first.value = x;
        }
        node t = new node(x);
        node temp = first.next;
        first.next = t;
        t.next = temp;
    }
//pop检查将要弹出的值是否和first中存储的值相等
//如果相等，且链表不为空，遍历列表找到新的最小值保存在first中
//链表为空，first也置空
    public void pop() {
        if(first.next.value == first.value && first.next.next != null){
            node temp = first.next.next;
            int min = temp.value;
            while(temp != null){
                if(temp.value < min){
                    min = temp.value;
                }
                temp = temp.next;
            }
            first.value = min;
        }else if(first.next.value == first.value && first.next.next == null){
            first =  null;
            return;
        }
        first.next = first.next.next;
    }
//top操作就返回first后一个结点的值
    public int top() {
        return first.next.value;
    }
//min返回first中存储的值
    public int min() {
        return first.value;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
```

![image-20211125181715944](images/image-20211125181715944.png)

>改进思路
>
>1. 在node中添加一个`int min`,这样，pop时候就不用在遍历了，也不需要first结点了
>
>思路2：
>
>用两个栈完成这道题：
>
>栈A负责pop，push，top操作
>
>栈B负责min操作
>
>当栈B为空，或者栈顶元素大于push的值的时候入栈
>
>而当栈A和栈B的栈顶元素相等，且要进行pop操作的时候，A,B栈同时pop