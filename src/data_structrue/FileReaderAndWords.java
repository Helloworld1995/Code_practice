package data_structrue;

import java.io.*;

/**
 * 从文件中读取内容并统计有多少个单词
 */
public class FileReaderAndWords {
    public static void main(String[] args) throws IOException {
        String path="C:/Users/Administrator/Desktop/test.txt";
        readFile2(path);
    }

    /**
     * 字符输入
     * @param s
     * @throws IOException
     */
    public static void readFile(String s) throws IOException {
        File file=new File(s);
        BufferedReader br=new BufferedReader(new FileReader(file));
        String lines="";
        String line="";
        while(null!=(line=br.readLine())){
            lines+=line;
        }
        br.close();
        System.out.println(lines);
        statisWords(lines);
    }

    /**
     * 字节流输入
     * @param s
     * @throws IOException
     */
    public static void readFile2(String s) throws IOException {
        File file=new File(s);
        BufferedInputStream br=new BufferedInputStream(new FileInputStream(file));
        String lines="";
        int len=0;
        byte[] b=new byte[64];
        while(-1!=(len=br.read(b))){
            String segment=new String(b,0,len);
            lines+=segment;
            System.out.println(len);
        }
        br.close();
        System.out.println(lines);
        statisWords(lines);
        writeFile(lines);
        writeFile2("C:/Users/Administrator/Desktop/ftest.txt",lines);
    }

    /**
     * 统计单词
     * @param words
     */
    public static void statisWords(String words){
        String[] wordsArr = words.split(" ");
        System.out.println("一共有"+wordsArr.length+"个单词");
    }

    /**
     * 简单写入文件
     * @param s
     * @throws IOException
     */
    public static void writeFile(String s) throws IOException {
        String wpath="C:/Users/Administrator/Desktop/ftest.txt";
        FileWriter fw=new FileWriter((wpath));
        PrintWriter pw=new PrintWriter(fw,true);
        pw.println(s);
        pw.close();
        fw.close();
    }

    /**
     * 输出流写入文件
     * @param s
     * @param content
     */
    public static void writeFile2(String s,String content){
        FileOutputStream fo=null;
        BufferedOutputStream bo=null;
        try {
            fo=new FileOutputStream(new File(s),true);
            bo=new BufferedOutputStream(fo);
            bo.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bo.close();
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
