package other.设计模式.工厂模式.简单工厂;

public class testFactory {
    public static void main(String[] args) {
        Car car = CarFactor.carFactor(BYD.class);
        car.getCar();
    }
}
