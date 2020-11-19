package data_structrue;

/**
 * 判断小串在大串中出现的次数
 */
public class Windows {
    public static int method(String s1,String s2){
        int len=s2.length();
        int i=0;
        int j=len-1;
        int count=0;
        while(j<s1.length()){
            String s=s1.substring(i,j+1);
            if(s.equals(s2)){
                count++;
            }
            i++;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s1="abcdefgabcdabcejptoavcabcabc";
        String s2="abc";
        int count=method(s1,s2);
        System.out.println(count);
    }

}
