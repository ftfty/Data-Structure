import java.util.Scanner;

/**
 * @Author: ZJH
 * @Date: 2021/12/19/14:04
 * @Description:
 */
public class PREV282 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[i][0] = arr[i][i] = 1;
            for (int j = 1; j <= i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
       a: for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                sum++;
                if(arr[i][j] == n){
                    System.out.println(sum);
                    break a;
                }
            }
        }

    }

}
