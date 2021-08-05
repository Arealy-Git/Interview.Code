package top200;

public class t59_将字符串转化为整数 {

    public int atoi(String str) {
        //若字符串为空或去除前后空格后为空，返回0
        if (str == null || str.trim().length() == 0) {
            return 0;
        }
        //处理掉前后空格并转化为字符串数组
        char[] arr = str.trim().toCharArray();

        int sign = 1, index = 0;
        //判断正负号
        if (arr[0] == '+') {
            index++;
        }
        if (arr[0] == '-') {
            sign = -1;
            index++;
        }

        int num = 0;
        for (int i = index; i < arr.length; i++) {
            if (arr[i] - '0' >= 0 && arr[i] - '9' <= 0) {
                //如果当前运算会越界的时候，直接输出结果
                if (num >= Integer.MAX_VALUE / 10) {//注意此处得/10，否则马上要超范围时，下一此更新num会数字跳变
                    if (sign > 0) {
                        return Integer.MAX_VALUE;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                }

                num = 10 * num + arr[i] - '0';//数字放在判断超出范围之后进行，防止马上要超范围时u，
                //  数字更新带来符号跳变
            } else
                //如果是字母，跳出循环
                break;
        }

        return num * sign;
    }

}
