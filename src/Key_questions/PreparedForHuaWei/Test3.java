package Key_questions.PreparedForHuaWei;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Test3 {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
        List<Book> boolist=new ArrayList<>();
        int num=sc.nextInt();
        sc.nextLine();
        String[] dict=new String[num];
        for (int i = 0; i <num ; i++) {
            dict[i]=sc.nextLine();
        }
        for (int i = 0; i <dict.length ; i++) {
            String[] s = dict[i].split(",");
            long id=Long.parseLong(s[0]);
            int category=Integer.parseInt(s[1]);
            int words=Integer.parseInt(s[2]);
            Date updatetime= simpleDateFormat.parse(s[3]);
            Book book=new Book(id,category,words,updatetime);
            boolist.add(book);
        }
        Collections.sort(boolist);
        for (Book book : boolist) {
            System.out.println(book.toString());
        }
    }
}
class Book implements Comparable<Book>{
    long id;
    int category;
    int words;
    Date updatetime;
    public Book(long id,int category,int words,Date updatetime){
        this.id=id;
        this.category=category;
        this.words=words;
        this.updatetime=updatetime;
    }

    @Override
    public int compareTo(Book o) {
        if(this.category>o.category){
            return 1;
        }else if(this.category==o.category){
            if(this.updatetime.getTime()>o.updatetime.getTime()){
                return 1;
            }else if(this.updatetime.getTime()==o.updatetime.getTime()){
                if(this.words>o.words){
                    return 1;
                }else if(this.words==o.words){
                    if(this.id>o.id){
                        return 1;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }
    public String toString(){
        return String.valueOf(id);
    }
}
