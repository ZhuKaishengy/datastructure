package chapter07;

import lombok.Data;
import lombok.ToString;

/**
 * 单项链表
 */
@Data
@ToString
public class Node {

    private Student value;
    /**
     * 这里key也相当于传入参数的age
     */
    private Integer key;
    private Node next;

    public Node(Student value, Integer key) {
        this.value = value;
        this.key = key;
    }

    public void add(Student student){

        if (this.next == null) {
            Node node = new Node(student,student.getAge());
            this.next = node;
            this.next.key = student.getAge();
        } else {
            this.next.add(student);
        }

    }

    /**
     * 当前节点为根节点，递归查找元素，根据key
     * @param student
     * @return
     */
    public Student get(Student student){
        if (student.getAge() == this.getKey()) {
            // find it
            return this.getValue();
        }
        if (this.getNext() != null) {
            return this.getNext().get(student);
        }
        return null;
    }
}
