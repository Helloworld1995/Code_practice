package Key_questions.PreparedForHuaWei;

public class LeetCode08 {

    public static void main(String[] args) {
        LeetCode08 l8=new LeetCode08();
        System.out.println(l8.myAtoi("  00000000000012345"));
    }

    public int myAtoi(String s){
        if(s.equals("")){
            return 0;
        }
        String max=String.valueOf(Integer.MAX_VALUE);
        String min=String.valueOf(Integer.MIN_VALUE).substring(1);
        int len=s.length();
        int tag=1;
        int index=0;
        while(index<len&&s.charAt(index)==' '){
            index++;
        }
        if(index<len){
            char ch=s.charAt(index);
            if(ch!='-'&&ch!='+'&&!Character.isDigit(ch)){
                return 0;
            }else if(ch=='-'){
                if(len==1){
                    return 0;
                }
                tag=-1;
                index++;
            }else if(ch=='+'){
                if(len==1){
                    return 0;
                }
                index++;
            }
        }
        if(index<len){
            if(!Character.isDigit(s.charAt(index))){
                return 0;
            }else{
                while(index<len&&s.charAt(index)=='0'){
                    index++;
                }
            }
        }else{
            return 0;
        }

        StringBuffer res=new StringBuffer();
        while(index<len){
            char ch=s.charAt(index);
            if(Character.isDigit(ch)) {
                res.append(ch);
            }else{
                break;
            }
            index++;
        }
        int len1=res.length();
        if(tag==1){
            if(len1>max.length()){
                return Integer.MAX_VALUE;
            }else if(len1==max.length()){
                for (int i = 0; i <len1 ; i++) {
                    if(res.charAt(i)>max.charAt(i)){
                        return Integer.MAX_VALUE;
                    }
                }
                return Integer.valueOf(res.toString());
            }else{
                return Integer.valueOf(res.toString());
            }
        }else if(tag==-1){
            if(len1>min.length()){
                return Integer.MIN_VALUE;
            }else if(len1==min.length()) {
                for (int i = 0; i <len1 ; i++) {
                    if(res.charAt(i)>min.charAt(i)){
                        return Integer.MIN_VALUE;
                    }
                }
                return tag*Integer.valueOf(res.toString());
            }else{
                return tag*Integer.valueOf(res.toString());
            }
        }
        return 0;
    }
}
