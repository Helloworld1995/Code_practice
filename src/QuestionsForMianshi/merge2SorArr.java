package QuestionsForMianshi;

/**
 * 合并两个有序数组,将两个数组合并后放到第三个大数组
 */
public class merge2SorArr {
    public static void main(String[] args) {
        int[] a1={1,2,5,7,8,9,12,15};
        int[] a2={2,4,5,6,7,8,13,16,17,20};
        int[] newArr=new int[a1.length+a2.length];
        merge(a1,a2,newArr);
        for (int i : newArr) {
            System.out.print(i+" ");
        }
    }
    public static void merge(int[] a1,int[] a2,int[] newArr) {
        int i=0;
        int j=0;
        int k=0;
        while(j<a2.length&&i<a1.length){
            if(a2[j]<a1[i]){
                newArr[k++]=a2[j++];
            }else if(a2[j]>=a1[i]){
                newArr[k++]=a1[i++];
            }
        }
        while(i<a1.length&&k<newArr.length){
            newArr[k++]=a1[i++];
        }
        while(j<a2.length&&k<newArr.length){
            newArr[k++]=a2[j++];

        }
    }

}
