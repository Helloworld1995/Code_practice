package Key_questions;
/**
 * 找到前重复次数最多的元素(桶)
 */
public class FindTopKRepeated {
    public static void main(String[] args) {
        int[] a={1,1,1,2,2,2,4,4,3,3,3,5,5,6,7,8,9};
        int[] temp=new int[a.length];
        for (int i = 0; i <a.length ; i++) {
            temp[a[i]]++;
        }
        int max=-1;
        int maxValue=-1;
        for (int i = 0; i <temp.length ; i++) {
            if(temp[i]>max){
                max=temp[i];
                maxValue=i;
            }
        }
        System.out.println(maxValue);
    }
}
