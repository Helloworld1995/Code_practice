package Key_questions;

import java.util.Scanner;

/**
 * 给定从左到右，从上到下的二维数组，查找给定数是否存在：时间复杂度 O(M + N)，空间复杂度 O(1)
 */
public class ArrSearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int width=sc.nextInt();
        int target=sc.nextInt();
        int[][] a=new int[len][width];
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <width ; j++) {
                a[i][j]=sc.nextInt();
            }
        }
        boolean result=find2(target,a);
        System.out.println(result);
    }
    public static boolean find(int target,int[][] a){
            for (int j = 0; j <a[0].length ; j++) {
                if(a[0][j]>target){
                    if(j==0) {
                        return false;
            }else{
                    for (int i = 0; i <a.length ; i++) {
                        if(a[i][j-1]==target){
                            return true;
                        }
                    }
                }
            }else{
                    for (int i = 0; i <a.length ; i++) {
                        if(a[i][a.length-1]==target){
                            return true;
                        }
                    }
                }
        }
            return false;
    }

    /**
     * 标准答案
     */
    public static boolean find2(int target,int[][] a){
        if(a.length==0||a==null){
            return false;
        }
        int row=a.length,cols=a[0].length;
        int r=row-1,c=0;//从左下角开始 or 从右上角开始
        while(c<=cols-1&&r>=0){
            if(target==a[r][c]){
                return true;
            }
            if(target>a[r][c]){
                c++;
            }else{
                r--;
            }
        }
        return false;
    }
}
