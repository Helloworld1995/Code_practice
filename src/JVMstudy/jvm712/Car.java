package JVMstudy.jvm712;

public class Car {
    public static void main(String[] args) {
        Car car1=new Car();
        Car car2=new Car();
        Car car3=new Car();
        Class<? extends Car> aClass1 = car1.getClass();
        Class<? extends Car> aClass2 = car2.getClass();
        Class<? extends Car> aClass3 = car3.getClass();
        System.out.println(aClass1==aClass2);
        System.out.println(aClass2==aClass3);
        ClassLoader classLoader = aClass1.getClassLoader();
        System.out.println(classLoader);
        while(classLoader.getParent()!=null){
            classLoader=classLoader.getParent();
            System.out.println(classLoader);
        }

    }
}
