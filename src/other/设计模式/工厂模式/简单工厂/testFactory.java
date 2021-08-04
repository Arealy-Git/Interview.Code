package other.设计模式.工厂模式.简单工厂;

import other.设计模式.工厂模式.实例类.BYD;
import other.设计模式.工厂模式.实例类.Car;

public class testFactory {
    public static void main(String[] args) {
        Car car = CarFactor.carFactor(BYD.class);
        car.getCar();
    }
}
