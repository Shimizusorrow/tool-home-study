package com.example.newstudy.clone;

import java.io.*;

/**
 * @author Shimizu
 * @date 2021-05-27 15:00
 */
public class ClassRoom implements Serializable {
    private static final long serialVersionUID = 2770869193824789963L;
    private Desk desk;

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public ClassRoom myClone() {
        ClassRoom classRoom = null;
        try {
            // 将该对象序列化成流,因为写在流里的是对象的一个拷贝，而原对象仍然存在于JVM里面。所以利用这个特性可以实现对象的深拷贝
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            // 将流序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            classRoom = (ClassRoom) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return classRoom;
    }
}
