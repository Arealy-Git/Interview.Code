package top200;

public class 跳台阶 {

    public int jumpFloor(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        return jumpFloor(target - 1)
                + jumpFloor(target - 2);
    }

}
