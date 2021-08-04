package other.设计模式.工厂模式.抽象工厂;

import other.设计模式.工厂模式.实例类.Car;
import other.设计模式.工厂模式.实例类.Plane;

public interface Factory {
    public Car getCarByFactory();

    public Plane getPlaneByFactory();
}
