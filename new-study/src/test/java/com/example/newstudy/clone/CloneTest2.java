package com.example.newstudy.clone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 通过实现序列化的方式 实现深度clone
 *
 * @author Shimizu
 * @date 2021-05-27 14:59
 */
public class CloneTest2 {
    @Test
    void cloneBySerializable() {
        ClassRoom classRoom = new ClassRoom();
        Desk desk = new Desk();
        desk.setNumber("1");
        classRoom.setDesk(desk);
        ClassRoom clone = classRoom.myClone();
        Assertions.assertEquals(clone.getDesk().getNumber(), classRoom.getDesk().getNumber());
        desk.setNumber("2");
        Assertions.assertEquals("2", classRoom.getDesk().getNumber());
        Assertions.assertEquals("1", clone.getDesk().getNumber());
    }
}
