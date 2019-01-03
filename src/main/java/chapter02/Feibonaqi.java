package chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归典型题： 斐波那契数列
 */
public class Feibonaqi {

    int first = 1;
    int second = 1;
    int correntCount = 2;
    List<Integer> result = new ArrayList<>(10);
    {
        result.add(1);
        result.add(1);
    }

    /**
     * 生成n项斐波那契额数列
     * @param count
     */
    public void generate(int count){

       int next = first + second;
       correntCount ++;
       result.add(next);
       // 递归的终止条件
       if (correntCount == count) {
           return ;
       }
       first = second;
       second = next;
       generate(count);
    }

    /**
     * 获取第i个数列的值
     * @param num
     * @return
     */
    public int get(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }
        int first = get(num - 2);
        int second = get(num -1);
        return first + second;
    }

    public static void main(String[] args) {
        Feibonaqi feibonaqi = new Feibonaqi();
        feibonaqi.generate(10);
        System.out.println(feibonaqi.result);
        int num10 = feibonaqi.get(10);
        System.out.println(num10);
    }
}
