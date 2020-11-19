package Key_questions.PreparedForHuaWei;
public class Testing {
    public int countSubstrings(String s) {
        int len=s.length();
        int count=0;
        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                if(isHuiwen(i,j,s)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isHuiwen(int l,int r,String s){
        int len=r-l+1;
        if(len==1){
            return true;
        }
        int middle=l+len/2;
        int left=middle-1;
        int right=middle+1;
        if(len%2==0){
            middle=l+len/2-1;
            left=middle;
            right=middle+1;
        }
        while(left>=l&&right<=r){
            if(s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Testing t=new Testing();
        int count = t.countSubstrings("fdsklf");
        System.out.println(count);
    }
}