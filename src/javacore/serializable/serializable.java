package javacore.serializable;

import java.io.IOException;

public class serializable {
    public static void main(String[] args) {
        ISerializable iSerializable =new javaISerializable();
        User user =new User();
        user.setAge(20);
        user.setName("hh");
        user.setSex("nan");
        try {
            iSerializable.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
         user = (User) iSerializable.readObject();
        System.out.println(user.getName()+user.getSex()+user.getAge());
    }

}
