package ClonePkt;

import java.io.Serializable;

public class CloneTest implements Cloneable{
    private int age;
    private Dog dog;

    public CloneTest(int age, Dog dog) {
        this.age = age;
        this.dog = dog;
    }

    public int getAge() {
        return age;
    }

    public CloneTest setAge(int age) {
        this.age = age;
        return this;
    }

    public Dog getDog() {
        return dog;
    }

    public CloneTest setDog(Dog dog) {
        this.dog = dog;
        return this;
    }

    @Override
    public CloneTest clone() {
        CloneTest ct=null;
        try {
            ct= (CloneTest) super.clone();
            ct.dog = (Dog) this.getDog().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return ct;
    }

    @Override
    public String toString() {
        return "CloneTest{" +
                "age=" + age +
                ", dog=" + dog +
                '}';
    }

    public static void main(String[] args) {
        Dog dog=new Dog("大黄",3);
        CloneTest ct=new CloneTest(100,dog);
        System.out.println(ct);
        try {
            CloneTest o = (CloneTest) ct.clone();
            o.setAge(88);
            o.setDog(new Dog("小黑",2));
            System.out.println(o);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class Dog implements Cloneable {
    private String dogName;
    private int dogAge;

    public Dog(String dogName, int dogAge) {
        this.dogName = dogName;
        this.dogAge = dogAge;
    }

    public String getDogName() {
        return dogName;
    }

    public Dog setDogName(String dogName) {
        this.dogName = dogName;
        return this;
    }

    public int getDogAge() {
        return dogAge;
    }

    public Dog setDogAge(int dogAge) {
        this.dogAge = dogAge;
        return this;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                ", dogAge=" + dogAge +
                '}';
    }

    @Override
    protected Dog clone() throws CloneNotSupportedException {
        return (Dog) super.clone();
    }
}
