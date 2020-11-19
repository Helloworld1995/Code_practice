package TestPkt;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<Integer> res=new ArrayList<>();
        for (Integer re : res) {
            System.out.print(re+",");
        }
    }
    private static void processor(List<Integer> res){
        for (int i = 0; i <10 ; i++) {
            res.add(i);
        }
    }
}
