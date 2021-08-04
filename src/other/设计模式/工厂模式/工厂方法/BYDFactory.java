package other.设计模式.工厂模式.工厂方法;

import other.设计模式.工厂模式.实例类.BYD;
import other.设计模式.工厂模式.实例类.Car;

public class BYDFactory implements CarFactory {
    @Override
    public Car getCarByFactory() {
        return new BYD();
    }
}
