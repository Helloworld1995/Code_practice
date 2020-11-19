package Key_questions;

/**
 * 旋转数组。
 */
public class ReverseStr {
    public static void main(String[] args) {
        String s="I am a student";
        String result=reverseSentence(s);
        System.out.println(result);
    }
    public static String reverseSentence(String s){
        char[] chars = s.toCharArray();
        int n=chars.length;
        int i=0;
        int j=0;
        while(j<=n){
            if(j==n||chars[j]==' '){
                reverse(chars,i,j-1);
                i=j+1;
            }
            j++;
        }
        reverse(chars,0,n-1);
        return new String(chars);
    }
    public static void reverse(char[] chars,int i,int j){
        while(i<j){
            char temp=chars[i];
            chars[i]=chars[j];
            chars[j]=temp;
            i++;
            j--;
        }
    }
}
