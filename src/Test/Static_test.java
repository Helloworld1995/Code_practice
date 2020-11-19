package Test;

public class Static_test {
    public static void main(String[] args) {
        father f=new child();
    }
}
class father{
    {
        System.out.println("father not static area");
    }
    static {
        System.out.println("father static area");
    }
}
class child extends father{
    {
        System.out.println("child not static area");
    }
    static {
        System.out.println("child static area");
    }
}
