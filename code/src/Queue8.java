public class Queue8 {
    int max = 8;
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args){
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("^^^^^^^^^^^^^^^^^^^^");
        System.out.println(count);
    }
    //编写一个方法放置第n个皇后
    private void check(int n){
        if(n == max){
            print();
            return;
        }
        for(int i = 0; i < max; i++){
            array[n] = i;
            if(judge(n)){
                check(n + 1);
            }
        }
    }
    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n){
        for(int i = 0; i < n; i++){
            if(array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }
    private void print(){
        count++;
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
