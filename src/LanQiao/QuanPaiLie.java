package LanQiao;

/**
 * 全排列
 *
 */
public class QuanPaiLie {
    static int count=0;
    public static void paiLie(char[] c,int deep,int bound){
        if(deep==bound){ //到达最后一层
            for (int i = 0; i <c.length ; i++) {
                System.out.print(c[i]);
            }
            System.out.println();
            count++;
        }
        for (int i = deep; i <=bound ; i++) {
            swap(c,deep,i);
            paiLie(c,deep+1,bound);
            swap(c,i,deep);
        }
    }
    public static void swap(char[] c,int i,int j){
        char temp=c[j];
        c[j]=c[i];
        c[i]=temp;
    }

    public static void main(String[] args) {
        String s="abcdefg";
        paiLie(s.toCharArray(),0,s.length()-1);
        System.out.println(count);
    }
}
