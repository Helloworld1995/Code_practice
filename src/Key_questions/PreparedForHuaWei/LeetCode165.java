package Key_questions.PreparedForHuaWei;

public class LeetCode165 {
    public int compareVersion(String version1,String version2){
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i=0,j=0;
        int len1=arr1.length;
        int len2=arr2.length;
        while(i<len1&&j<len2){
            int k1=Integer.valueOf(arr1[i]);
            int k2=Integer.valueOf(arr2[j]);
            if(k1>k2){
                return 1;
            }else if(k1<k2){
                return -1;
            }else{
                i++;
                j++;
            }
        }
        while(i<len1){
            if(Integer.valueOf(arr1[i])>0){
                return 1;
            }
            i++;
        }
        while(j<len2){
            if(Integer.valueOf(arr1[j])>0){
                return -1;
            }
            j++;
        }
        return 0;
    }


    public static void main(String[] args) {
        LeetCode165 leetCode165=new LeetCode165();
        System.out.println(leetCode165.compareVersion("version1 = \"0.1\"", "version2 = \"1.1\""));
    }
}
