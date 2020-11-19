package DesighModel.Decorator;

public class Client {
    public static void main(String[] args) {
        Car car=new Car();
        car.move();
        FlyCar flyCar=new FlyCar(car);
        flyCar.move();

        System.out.println("##############");
        WaterCar superCar=new WaterCar(flyCar);
        superCar.move();
        System.out.println("%%%%%%%%%%%%%%");
        FlyCar superCar1=new FlyCar(new WaterCar(car));
        superCar1.move();
    }
}
