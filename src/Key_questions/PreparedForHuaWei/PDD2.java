package Key_questions.PreparedForHuaWei;

import java.util.Scanner;

public class PDD2 {
    public void test(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int cout = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String a = in.next();
            int b = in.nextInt();
            int temp = m;
            switch (a){
                case "|":
                    m = m | b;
                    break;
                case "&":
                    m = m & b;
                    break;
                case "^":
                    m = m ^ b;
                    break;
            }
            if(temp != m){
                cout ++;
                sb.append(a+" "+b+"\n");
            }
        }
        System.out.println(cout);
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        PDD2 pdd=new PDD2();
        pdd.test();
    }
}
