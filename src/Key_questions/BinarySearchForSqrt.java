package Key_questions;

import java.util.Scanner;

public class BinarySearchForSqrt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sqrt = binarySearchSqrt(n);
        System.out.println(sqrt);
        int result2 = binarySearchSqrt02(1, n, n);
        System.out.println(result2);
        int result3 = Baoli(n);
        System.out.println(result3);
    }

    /**
     * 利用二分查找
     * @param n
     * @return
     */
    public static int binarySearchSqrt(int n){
        int l=1;
        int r=n;
        int middle=l;
        while(l<=r){
            middle=(r+l)>>1;
            int sqrt=n/middle;
            if(middle>sqrt){
                r=middle-1;
            }else if(middle<sqrt){
                l=middle+1;
            }else{
                return middle;
            }
        }
        return r;
    }

    /**
     * 递归
     * @param l
     * @param r
     * @param n
     * @return
     */
    public static int binarySearchSqrt02(int l,int r,int n){
        if(l>r) {
            return r;
        }
            int mid=(r+l)/2;
            int sqrt=n/mid;
            if(sqrt<mid){
                r=mid-1;
                return binarySearchSqrt02(l,r,n);
            }else if(sqrt>mid){
                l=mid+1;
                return binarySearchSqrt02(l,r,n);
            }else {
                return mid;
            }
    }

    /**
     * 暴力求解
     * @param n
     * @return
     */
    public static int Baoli(int n){
        int i=1;
        int j=0;
        while(i*i<=n){
            j=i;
            i++;
        }
        return j;
    }
}
