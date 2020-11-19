package Test;

import java.io.*;

public class InputOutPut {
    public static void main(String[] args) throws IOException {
        File file=new File("C:\\Users\\Administrator\\Desktop\\索引优化.docx");
        BufferedReader bf=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
        String s="";
        while(null!=(s=bf.readLine())){
            System.out.println(s);
        }
    }
}
