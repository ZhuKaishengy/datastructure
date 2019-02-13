package chapter07;

import org.junit.BeforeClass;
import org.junit.Test;

public class HashTableTest {

    private static Student stu1;
    private static Student stu2;

    @BeforeClass
    public static void init(){
        stu1 = new Student("zks", 25);
        stu2 = new Student("haha", 15);
    }

    @Test
    public void putAndGet() {
        HashTable hashTable = new HashTable();
        hashTable.put(stu1);
        hashTable.put(stu2);
        Student student = hashTable.get(new Student("haha", 25));
        System.out.println(student);
    }

}