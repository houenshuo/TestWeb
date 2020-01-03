package javacore.serializable;

import java.io.*;

public class User implements Serializable {
    private String name;
    private int age;
    private transient String sex;// ObjectOutputStream 不会对这个字段处理

    /**
     * 必须写对private void writeObject(java.io.ObjectOutputStream outputStream)
     * 因为ObjectOutputStream在初始化话的时候 会创建一个writeObjectMethod=反射private void writeObject(java.io.ObjectOutputStream outputStream)对象
     * 所以 会调用这个writeObject方法，此时便可以无视transient修饰 写入内存
     * @param outputStream
     * @throws IOException
     */
    private void writeObject(java.io.ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(sex);
    }

    /**
     * 读取writeObjectMethod.writeObject（对象）的对象
     * 可以是数组、字符串、引用等等
     * @param inputStream
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(java.io.ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        sex =(String)inputStream.readObject();
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
