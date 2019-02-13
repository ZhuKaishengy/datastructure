package interview;

/**
 * double类型的浮点数进行运算，为什么会损失精度
 */
public class Question01 {

    public void example(){
        float f = 2.2f;
        double d = (double) f;
        System.out.println(d);
        f = 2.25f;
        d = (double) f;
        System.out.println(d);
    }

    /**
     * 此题考的是底层数据存储，
     * 浮点型数底层已2进制进行存储，精度丢失主要因为尾数位，若果转成二进制后尾数位是固定的，不会出现精度丢失，若尾数位是无穷的，出现精度丢失
     * 运算时采取 BigDecimal
     * 类型       符号位  指数位  尾数位   表示的数的范围
     * float       1      8      23         2^32 ~ 2^32 -1   -128~127
     * double      1      11     52         2^64 ~ 2^64 -1   -1024~1023
     *
     * ps:如何将一个十进制数转为二进制？
     * 整数/2取余数，直到0为止，将余数倒叙排列
     * 小数*2取整，直到1为止，按正序排列
     * eg:
     * 2.25
     *  符号位：0
     *  指数位算法： 转为二进制  10.01  1.001 ^1  0 00000001  00100...
     * @param args
     */
    public static void main(String[] args) {
        Question01 question01 = new Question01();
        question01.example();
    }
}
