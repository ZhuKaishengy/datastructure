package chapter07;

import lombok.ToString;

@ToString
public class Student {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * hash函数，直接定址法
     * @return
     */
    @Override
    public int hashCode(){
        return this.age % 10;
    }

}
