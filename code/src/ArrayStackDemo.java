import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args){
        ArrayStack arrayStack = new ArrayStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("show: 显示栈");
            System.out.println("exit");
            System.out.println("push");
            System.out.println("pop");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.list();
                    break;
                case "push":
                    int value = scanner.nextInt();
                    arrayStack.push(value);
                    break;
                case "pop":
                    try{
                        int res = arrayStack.pop();
                        System.out.println(res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                case "exit":
                   scanner.close();
                   loop = false;
                   break;
                default:
                    break;
            }
        }
    }
}
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top = -1;
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(int value){
        if(isFull()){
            System.out.println("full");
            return;
        }
        top++;
        stack[top] = value;
    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("empty");
        }
        int value = stack[top];
        top--;
        return value;
    }
    public void list(){
        if(isEmpty()){
            System.out.println("empty");
            return;
        }
        for(int i = top; i >= 0; i--){
            System.out.println(stack[i]);
        }
    }
}
