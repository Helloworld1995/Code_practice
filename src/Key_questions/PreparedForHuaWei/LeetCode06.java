package Key_questions.PreparedForHuaWei;

public class LeetCode06 {
    public static void main(String[] args) {
        LeetCode06 l6=new LeetCode06();
        System.out.println(l6.convert("LEETCODEISHIRING", 3));
    }
    public String convert(String s,int numRows){
        if(numRows==1){
            return s;
        }
        char[] cs=s.toCharArray();
        StringBuffer[] lines=new StringBuffer[numRows];
        for (int i = 0; i <numRows ; i++) {
            lines[i]=new StringBuffer();
        }
        int index=0;
        boolean flag=true;
        for(int i=0;i<s.length();i++){
            lines[index].append(cs[i]);
            if(index==0){
                index++;
                flag=true;
            }else if(index==numRows-1){
                flag=false;
                index--;
            }else{
                if(flag){
                    index++;
                }else{
                    index--;
                }
            }
        }
        StringBuffer res=new StringBuffer();
        for(StringBuffer str:lines){
            res.append(str);
        }
        return res.toString();
    }
}
