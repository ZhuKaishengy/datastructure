package chapter02;

/**
 * 递归典型题：汉诺塔
 */
public class Honoi {

    /**
     * items个盘子，从a移动到c的算法
     * 当大于2个盘子，可以把上面的盘子当成一个处理
     * eg：三个盘子从a 到 c
     * 简化成：上面两个盘子从a到b，下面一个盘子从a 到 c， 上面的再移动回去
     * @param items
     * @param a
     * @param b
     * @param c
     */
    public void honoi(int items, String a, String b, String c){
        if (items == 1) {
            System.out.println("第1个盘子从" + a + "移动到" + c);
        } else {
            // 上面的盘子从a移动到b
            this.honoi(items-1, a, c, b);
            // 最下面的移动到c
            System.out.println("第" + items + "个盘子从" + a + "移动到" + c);
            // 上面的移动过去
            this.honoi(items-1, b, a, c);
        }
    }

    public static void main(String[] args) {
        Honoi honoi = new Honoi();
        honoi.honoi(3, "a", "b", "c");
    }
}
