package data_structrue;

public class QuanPailie {
    public static void quanPailie(char[] c,int decision){
        if(c==null||decision<0||decision>c.length-1){
            return;
        }
        if(decision==c.length-1){
            System.out.println(new String(c));
            return;
        }
        for (int i = decision; i <c.length ; i++) {
            swap(c,i,decision);
            quanPailie(c,decision+1);
            swap(c,i,decision);
        }

    }
    public static void swap(char[] c,int i,int j){
        char temp=c[i];
        c[i]=c[j];
        c[j]=temp;
    }

    public static void main(String[] args) {
        String s="abcd";
        char[] c = s.toCharArray();
        quanPailie(c,0);
    }
}
