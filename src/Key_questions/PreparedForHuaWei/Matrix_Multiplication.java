package Key_questions.PreparedForHuaWei;

/**
 * 矩阵相乘
 */
public class Matrix_Multiplication {
    public static void main(String[] args) {
        int[][] a1 = initArray(3, 4);
        int[][] a2 = initArray(4, 3);
        int[][] a3 = multiplication(a1, a2);
        for (int[] a : a3) {
            for (int i : a) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    private static int[][] initArray(int n,int m){
        int[][] a=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                a[i][j]= (int) (Math.random()*10);
            }
        }
        return a;
    }

    private static int[][] multiplication(int[][] a1, int[][] a2) {
        if (a1 == null || a2 == null) {
            return null;
        }
        if ((a1.length != a2[0].length) && a1[0].length != a2.length) {
            return null;
        }
        int[][] a3 = new int[a1.length][a2[0].length];
        int temp = 0;
        for (int i = 0; i < a1.length; i++) {
            for (int k = 0; k < a2[0].length; k++) {
                for (int j = 0; j < a1.length; j++) {
                    temp += a1[i][j] * a2[j][k];
                }
                a3[i][k]=temp;
                temp=0;
            }
        }
        return a3;
    }
}
