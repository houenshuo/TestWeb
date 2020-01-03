package javacore.serializable;

import java.io.*;

public class javaISerializable implements ISerializable<User> {
    @Override
    public int writeObject(User user) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream =new ObjectOutputStream(new FileOutputStream(new File("user")));
            objectOutputStream.writeObject(user);
        }catch (IOException e){
            if (objectOutputStream!=null) {
                try {
                    objectOutputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return 1;
    }

    @Override
    public User readObject() {
        ObjectInputStream objectInputStream =null;
        try {
            objectInputStream =new ObjectInputStream(new FileInputStream(new File("user")));
            try {
                return (User)objectInputStream.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
            if (objectInputStream!=null){
                try {
                    objectInputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }
}
