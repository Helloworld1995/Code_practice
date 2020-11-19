package Key_questions;

/**
 * 找到最长回文字串
 */
public class LongestHuiwen {
    public static void main(String[] args) {
        String s="12345432125676898676";
        boolean flag=false;
        int max=-1;
        String str="";
        for (int i = 1; i <s.length()-1 ; i++) {
            int left=i-1;
            int right=i+1;
            while(left>=0&&right<=s.length()-1){
               if(s.charAt(left)!=s.charAt(right)) {
                   break;
               }
                flag=true;
                left--;
                right++;
            }
            if(flag==true) {
                String sub = s.substring(left+1, right);
                if (sub.length() >= max) {
                    max = sub.length();
                    str = sub;
                }
            }
        }
        System.out.println(str);
    }
}
