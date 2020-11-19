package Key_questions.PreparedForHuaWei;

import java.util.Arrays;

public class LeetCode6 {
    public static void main(String[] args) {
        String s="LEETCODEISHIRING";
        LeetCode6 lc=new LeetCode6();
        lc.convert(s, 5);
    }
    private void convert(String s,int numRows){
        int len=s.length();
        int j=numRows-2;
        int i=numRows+j;
        int m=len/i;
        int h=numRows;
        int w=0;
        if(m>0){
            w+=(m*(numRows-1));
        }
        m=len%i;
        if(m>0){
            w+=1;
        }
        if(m>numRows){
            w+=(m-numRows);
        }
        char[][] c=new char[w][h];
        Arrays.fill(c,'.');
        w-=1;
        while(w>0){

        }
    }
}
