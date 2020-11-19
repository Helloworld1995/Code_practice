package Key_questions;

/**
 * 奇数位于偶数前面，相对位置不变
 */
public class JiBeforeOu {
    public int[] ajust(int[] a){
       int[] a2=new int[a.length];
       int j=0;
        for (int i = 0; i <a.length ; i++) {
            if(a[i]%2!=0){
                a2[j]=a[i];
                j++;
            }
        }
        for (int i = 0; i <a.length ; i++) {
            if(a[i]%2==0){
                a2[j]=a[i];
                j++;
            }
        }
        return a2;
    }

    /**
     * 冒泡思想
     * @param a
     */
    public void ajust01(int[] a){
        for (int i = 0; i < a.length; i++) {
            if(a[i]%2==0){
                for (int j = i; j <a.length-1 ; j++) {
                    if(a[j+1]%2!=0){
                        int temp=a[j+1];
                        a[j+1]=a[j];
                        a[j]=temp;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        JiBeforeOu jo=new JiBeforeOu();
        int[] a={1,2,3,4,5,6,7,8,9,10,11};
        int[] a2=jo.ajust(a);
        for (int i : a2) {
            System.out.print(i+",");
        }
        jo.ajust01(a);
        System.out.println();
        for (int i : a) {
            System.out.print(i+",");
        }
    }
}
