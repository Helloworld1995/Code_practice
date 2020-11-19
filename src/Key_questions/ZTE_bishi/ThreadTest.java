package Key_questions.ZTE_bishi;

public class ThreadTest {
    public static void main(String[] args) {
        TestString ts=new TestString();
        StringBuilder tsBuilder=new StringBuilder();
        StringBuffer tsBuffer=new StringBuffer();
        for (int i = 0; i <1000 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j <1000 ; j++) {
                        ts.append(1);
                        tsBuilder.append("1");
                        tsBuffer.append("1");
                        System.out.println(ts.getNum()==tsBuilder.length());
                        System.out.println(ts.getNum()==tsBuffer.length());
                        System.out.println(tsBuilder.length()==tsBuffer.length());
                        System.out.println("---------------------------");
                    }
                }
            }).start();
        }
    }
}
class TestString{
    private Integer n=0;
    public Integer getNum(){
        return n;
    }
    public void setNume(Integer n){
        this.n=n;
    }
    public synchronized  void append(Integer n){
        this.n=this.n+n;
    }

}
