package Key_questions.dynamic;

/**
 * 背包问题
 */
public class Package_Problem {
    public static void main(String[] args) {
        int[] w={1,4,3};
        int[] val={1500,3000,2000};
        int m=4;//背包的容量
        int n=val.length;//物品的个数
        int[][] v=new int[n+1][m+1];
        int[][] path=new int[n+1][m+1];
        //v[i][j]表示前i个物品能够装入容量为j的背包中的最大价值
        for (int i = 0; i <v.length ; i++) {
            v[i][0]=0; //将第一列设置为0
        }
        for (int i = 0; i <v[0].length ; i++) {
            v[0][i]=0;
        }
        for (int i = 1; i <v.length ; i++) {
            for (int j = 1; j <v[0].length ; j++) {
                if(w[i-1]>j){
                    v[i][j]=v[i-1][j];
                }else{
                    if(v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }
                }
            }
        }
        for (int i = 0; i <v.length ; i++) {
            for (int j = 0; j <v[i].length ; j++) {
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }
    }


}
