package LanQiao;

/**
 * 删除字符串中重复的字符
 */
public class EliminateRepeatedStr {
    public static void main(String[] args) {
        String s="good";
        char[] cs = s.toCharArray();
        for (int i = 0; i <cs.length-1 ; i++) {
            if(cs[i]=='\0'){
                continue;
            }
            for (int j = i+1; j <cs.length ; j++) {
                if(cs[j]=='\0'){
                    continue;
                }
                if(cs[j]==cs[i]){
                    cs[j]='\0';
                }
            }
        }
        int l=0;
        for (int i = 0; i <cs.length ; i++) {
            if(cs[i]!='\0'){
                cs[l++]=cs[i];
            }
        }
        System.out.println(new String(cs,0,l));

    }
}
