package javacore.serializable;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ISerializable<T> {
    int writeObject(T t) throws IOException;
    T readObject();
}
