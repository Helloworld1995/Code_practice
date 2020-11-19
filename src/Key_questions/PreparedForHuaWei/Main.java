package Key_questions.PreparedForHuaWei;

public class Main {
    public static void main(String[] args) {
        String s="  abc               aa  bc    d   eee            ";
        int l=0,r=0;
        int len=s.length();
        while(l<len&&r<len+1&&l<=r){
            if(r==len) {
                String str = s.substring(l, r);
                System.out.print(str + " ");
            }
            if(r<len&&s.charAt(r)==' '){
                if(s.charAt(l)!=' ') {
                    String str = s.substring(l, r);
                    System.out.print(str+" ");
                }
                while(r<len&&s.charAt(r)==' '){
                    r++;
                }
                l=r;
            }else{
                r++;
            }
        }
    }
}
