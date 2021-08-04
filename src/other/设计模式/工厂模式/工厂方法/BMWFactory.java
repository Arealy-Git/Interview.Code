package other.设计模式.工厂模式.工厂方法;

import other.设计模式.工厂模式.实例类.BMW;
import other.设计模式.工厂模式.实例类.Car;

public class BMWFactory implements CarFactory {
    @Override
    public Car getCarByFactory() {
        return new BMW();
    }
}