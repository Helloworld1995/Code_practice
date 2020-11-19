package Key_questions.PreparedForHuaWei;
import java.util.*;

public class MaxNumberInShops {
    public static void main(String[] args) {
            String s="a,2,c|c,1,a";
            int i = maxNumOfCustomer(s);
    }
    public static int maxNumOfCustomer(String customerLogs){
        String[] logs = customerLogs.split("\\|");
        List<String> logList = new ArrayList<>();
        for (String log : logs) {
            logList.add(log);
        }
        Collections.sort(logList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] temp1=o1.split(",");
                String[] temp2=o2.split(",");
                int t1=Integer.parseInt(temp1[1]);
                int t2=Integer.parseInt(temp2[1]);
                if(t1>t2){
                    return 1;
                }else if(t2>t1){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        int l1=0;
        int l2=0;
        int count=1;
        int maxCount=0;
        while(l1<logList.size()&&l2<logList.size()){
            String[] temp1=logList.get(l1).split(",");
            String[] temp2=logList.get(l2).split(",");
            int t1=Integer.parseInt(temp1[2]);
            int t2=Integer.parseInt(temp2[1]);
            if(t2<t1){
                count++;
                l2++;
            }else{
                l1++;
            }
            if(maxCount<count){
                maxCount=count;
            }
            count=0;
        }
        return maxCount;
    }
}
