package Key_questions.slidingWindows;

/**
 * 给定m个不重复的字符 [a,b,c,d,……]，
 * 以及一个长度为n的字符串 s，
 * 问能否在这个字符串中找到一个长度为m的连续子串，
 * 使得这个子串刚好由上面m个字符组成，
 * 顺序无所谓，返回任意满足条件的一个子串的起始位置，
 * 未找到返回-1。
 */
public class FindSubStrIndex {
    public static void main(String[] args) {
        FindSubStrIndex findSubStrIndex=new FindSubStrIndex();
        String s="tbcacbdata";
        char[] a={'a','b','c','d'};
        int result=findSubStrIndex.check(s,a);
        System.out.println(result);
    }
    public int check(String s,char[] a){
        if(a.length>s.length()){
            return -1;
        }
        int i=0,j=0;
        j=a.length-1;
        while(i<=j&&j<s.length()){
            if(judge(s.substring(i,j+1),a)){
                return i;
            }
            i++;
            j++;
        }
        return -1;
    }
    public boolean judge(String s,char[] a){
        for (int i = 0; i <a.length ; i++) {
            if(s.indexOf(a[i])==-1){
                return false;
            }
        }
        return true;
    }
}
