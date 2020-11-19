package data_structrue;

public class isHuiWen_Digui {
    public boolean isHuiWen(char[] c,int start,int end){
        if(start==end){
            return true;
        }
        if(start<end) {
            if (c[start] == c[end]) {
                start++;
                end--;
                return isHuiWen(c, start, end);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s="abcdefgfedcba";
        char[] c = s.toCharArray();
        isHuiWen_Digui i=new isHuiWen_Digui();
        boolean isHuiwen = i.isHuiWen(c, 0, c.length - 1);
        System.out.println(isHuiwen);
    }
}
