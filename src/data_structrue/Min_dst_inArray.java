package data_structrue;

/**
 * 求数组中两个数的最小距离
 */
public class Min_dst_inArray {
    public static int dist(int n1,int n2,int[] arr){
        int n1_index=-1;
        int n2_index=-1;
        int min_dist=Integer.MAX_VALUE;
        for (int i = 0; i <arr.length ; i++) {
          if(n1==arr[i]){
              n1_index=i;
              if(n2_index>=0){
                  if(min_dist>Math.abs(n1_index-n2_index)){
                      min_dist=Math.abs(n1_index-n2_index);
                  }
              }
          }
            if(n2==arr[i]){
                n2_index=i;
                if(n1_index>=0){
                    if(min_dist>Math.abs(n1_index-n2_index)){
                        min_dist=Math.abs(n1_index-n2_index);
                    }
                }
            }
        }
        return min_dist;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{10,9,7,6,8,0,3,3,4,3,7,6,5,3,6,0};
        int dist = dist(10,0,arr);
        System.out.println(dist);
    }
}
