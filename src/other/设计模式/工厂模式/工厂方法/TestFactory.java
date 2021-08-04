package other.设计模式.工厂模式.工厂方法;

import other.设计模式.工厂模式.实例类.Car;

public class TestFactory {
    public static void main(String[] args) {
        Car bmw = new BMWFactory().getCarByFactory();
        bmw.getCar();
    }
}
