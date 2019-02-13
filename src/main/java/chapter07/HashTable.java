package chapter07;

/**
 * 哈希表的实现
 */
public class HashTable {

    /**
     * 链表 + 数组
     */
    Node[] values = new Node[100];

    public void put(Student stu) {
        int index = stu.hashCode();
        if (values[index] == null) {
            // first init, create node and put val
            values[index] = new Node(stu, stu.getAge());
        }else {
            values[index].add(stu);
        }
    }

    public Student get(Student stu){
        int index = stu.hashCode();
        if (values[index] == null) {
            return null;
        }else {
            return values[index].get(stu);
        }
    }
}
