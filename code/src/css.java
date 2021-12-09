import java.util.Scanner;

public class css {
    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }
        public static int reverse(int x) {
            boolean flag = false;
            int s = x;
            String str = new String();
            boolean falg = false;
            if(s >= Math.pow(2,31) && s <= (-1) * Math.pow(2, 31) - 1 || s == 0){
                return 0;
            }
            if(s < 0){
                falg = true;
                s *= -1;
            }
            int num = 1;
            int temp = 10;
            long result = 0;
            str = String.valueOf(s);
            int l = str.length() - 1;
            StringBuffer sb = new StringBuffer(str);
            sb.reverse();
            str = sb.toString();
            result = Long.parseLong(str);
            if(result >= Integer.MAX_VALUE || result <= (-1) * Math.pow(2, 31) - 1 || s == 0){
                return 0;
            }else{
                if(falg == true) result *= -1;
                System.out.println(result);
                System.out.println(result >= Integer.MAX_VALUE);
                return (int)result;
            }
        }

}
