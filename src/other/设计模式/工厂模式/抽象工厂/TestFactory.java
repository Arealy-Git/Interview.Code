package other.设计模式.工厂模式.抽象工厂;

import other.设计模式.工厂模式.实例类.Car;
import other.设计模式.工厂模式.实例类.Plane;

public class TestFactory {
    public static void main(String[] args) {
        Car byd = new FactoryTwo().getCarByFactory();
        byd.getCar();
        Plane airPlane = new FactoryOne().getPlaneByFactory();
        airPlane.getPlane();
    }
}
