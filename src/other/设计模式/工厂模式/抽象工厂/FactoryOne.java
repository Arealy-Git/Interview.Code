package other.设计模式.工厂模式.抽象工厂;

import other.设计模式.工厂模式.实例类.AirPlane;
import other.设计模式.工厂模式.实例类.BMW;
import other.设计模式.工厂模式.实例类.Car;
import other.设计模式.工厂模式.实例类.Plane;

public class FactoryOne implements Factory{

    @Override
    public Car getCarByFactory() {
        return new BMW();
    }

    @Override
    public Plane getPlaneByFactory() {
        return new AirPlane();
    }
}
