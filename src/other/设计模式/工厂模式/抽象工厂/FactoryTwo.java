package other.设计模式.工厂模式.抽象工厂;

import other.设计模式.工厂模式.实例类.BYD;
import other.设计模式.工厂模式.实例类.BattlePlane;
import other.设计模式.工厂模式.实例类.Car;
import other.设计模式.工厂模式.实例类.Plane;

public class FactoryTwo implements Factory {

    @Override
    public Car getCarByFactory() {
        return new BYD();
    }

    @Override
    public Plane getPlaneByFactory() {
        return new BattlePlane();
    }
}
