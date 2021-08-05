package 整合.模拟;

public class 判断一个字符串是否是合法的ipv4地址 {

    public static boolean Isipv4(String ipv4) {
        //字符串为空或者空串
        if (ipv4 == null || ipv4.length() == 0) {
            return false;
        }
        //因为java doc里已经说明, split的参数是reg, 即正则表达式, 如果用"|"分割, 则需使用"\\|"
        String[] parts = ipv4.split("\\.");
        //分割开的数组根本就不是4个数字
        if (parts.length != 4) {
            return false;
        }
        for (int i = 0; i < parts.length; i++) {
            try {
                int n = Integer.parseInt(parts[i]);
                //数字不在正确范围内
                if (n < 0 || n > 255 || (n != 0 && parts[i].charAt(0) == '0') || (n == 0 && parts[i].length() > 1)) {
                    return false;
                }
            }
            //转换数字不正确
            catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

}
