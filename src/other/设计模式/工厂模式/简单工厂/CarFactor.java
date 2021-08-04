package other.设计模式.工厂模式.简单工厂;

import other.设计模式.工厂模式.实例类.BMW;
import other.设计模式.工厂模式.实例类.BYD;
import other.设计模式.工厂模式.实例类.Car;

public class CarFactor {
    public static Car carFactor(Class<?> tClass) {
        if (tClass.getName().equals(BMW.class.getName())) {
            return new BMW();
        }
        if (tClass.getName().equals(BYD.class.getName())) {
            return new BYD();
        }
        return null;
    }
}
