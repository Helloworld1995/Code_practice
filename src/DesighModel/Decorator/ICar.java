package DesighModel.Decorator;

/**
 * 抽象构建
 */
public interface ICar {
    void move();
}

/**
 * 具体构建角色（真实对象）
 */
class Car implements ICar{
    @Override
    public void move() {
        System.out.println("陆地上跑");
    }
}

/**
 * 装饰角色
 */
class SuperCar implements ICar{
    ICar car;
    public SuperCar(ICar car){
        super();
        this.car=car;
    }


    @Override
    public void move() {
        car.move();
    }
}
//具体装饰对象
class FlyCar extends SuperCar{
    public FlyCar(ICar car){
        super(car);
    }
    @Override
    public void move() {
     super.move();
     this.fly();
    }
    public void fly(){
        System.out.println("天上飞");
    }
}
class WaterCar extends SuperCar{
    public WaterCar(ICar car){
        super(car);
    }
    @Override
    public void move() {
        super.move();
        this.swim();
    }

    public void swim(){
        System.out.println("水里游");
    }
}