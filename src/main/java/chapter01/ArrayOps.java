package chapter01;

import org.junit.Test;

public class ArrayOps {

    private MyArrayList<String> list;
    private MyArrayList<Integer> nums = new MyArrayList<>();
    {
        list = new MyArrayList<>();
    }

    /**
     * 数组的添加：手动实现arraylist添加
     */
    @Test
    public void test1(){
        list.add("a").add("b").add("c");
        System.out.println(list);
        System.out.println("list size:" + list.size());
        String str0 = list.get(0);
        System.out.println("str0:" + str0);
        list.set(0, "aa");
        String str0New = list.get(0);
        System.out.println("str0:" + str0New);
    }

    /**
     * 数组删除元素，手动实现arraylist删除
     */
    @Test
    public void test2(){
        list.add("1").add("2").add("3").remove(0);
        System.out.println(list);
   }

    /**
     *  说明Java中引用数据类型的传递方式为引用传递，类似于指针
     */
    @Test
    public void test3(){
        Person p1 = new Person().setId("1").setName("zks").setDesc("zks123");
        System.out.println(p1);
        this.changeVo(p1);
        System.out.println(p1);
    }

    /**
     * 线性查找
     */
    @Test
    public void test4(){
        list.add("a").add("b").add("c");
        int index = list.indexOf("b");
        System.out.println(index);
    }

    /**
     * 二分法查找
     */
    @Test
    public void test5(){
       nums.add(1).add(2).add(3).add(4).add(5);
        int indexOf = nums.binaryIndexOf(7, MyArrayList.Sort.Increase);
        System.out.println(indexOf);
    }

    private void changeVo(Person p1) {

        p1.setId("2").setName("haha").setDesc("haha123");
    }


}
