package com.example.newstudy.clone;

import org.junit.jupiter.api.Test;

/**
 * 补充Clone知识
 *
 * @author Shimizu
 * @date 2021-05-27 14:22
 */
public class CloneTest {
    /**
     * 浅拷贝测试学习 基础类型
     */
    @Test
    void shallowClone() {
        Student stu1 = new Student();
        stu1.setNumber(12345);
        Student stu2 = (Student) stu1.clone();

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());

        stu2.setNumber(54321);

        System.out.println("学生1:" + stu1.getNumber());
        System.out.println("学生2:" + stu2.getNumber());

        System.out.println(stu1 == stu2); // false
    }

    public class Student implements Cloneable {
        private int number;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        protected Object clone() {
            Student stu = null;
            try {
                stu = (Student) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return stu;
        }
    }

    /*---------------------------------样例二-------------------------------*/

    /**
     * 浅拷贝测试学习 引用类型
     */
    @Test
    void shallowClone2() {
        Address address = new Address();
        address.setAdd("杭州市");
        Student2 student2 = new Student2();
        student2.setAddress(address);
        student2.setNumber(1);
        Student2 clone = (Student2) student2.clone();

        System.out.println("学生1:" + student2.getNumber() + ",地址:" + student2.getAddress().getAdd());
        System.out.println("学生2:" + clone.getNumber() + ",地址:" + clone.getAddress().getAdd());

        address.setAdd("西湖区");
        /**
         * Address 类没有实现clone方法
         * 原因是浅复制只是复制了addr变量的引用，并没有真正的开辟另一块空间，将值复制后再将引用返回给新对象。
         */
        System.out.println("学生1:" + student2.getNumber() + ",地址:" + student2.getAddress().getAdd());
        System.out.println("学生2:" + clone.getNumber() + ",地址:" + clone.getAddress().getAdd());
    }

    public class Address {
        private String add;

        public String getAdd() {
            return add;
        }

        public void setAdd(String add) {
            this.add = add;
        }
    }

    public class Student2 implements Cloneable {
        private int number;
        private Address address;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        @Override
        protected Object clone() {
            Student2 stu = null;
            try {
                stu = (Student2) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return stu;
        }
    }

    /*------------------------------样例三------------------------------------*/

    /**
     * 将Address 也可以复制化
     */
    @Test
    void DeepClone() {
        Address2 address = new Address2();
        address.setAddress("杭州市");
        Student3 student3 = new Student3();
        student3.setAddress(address);
        student3.setNumber(1);
        Student3 clone = (Student3) student3.clone();

        System.out.println("学生1:" + student3.getNumber() + ",地址:" + student3.getAddress().getAddress());
        System.out.println("学生2:" + clone.getNumber() + ",地址:" + clone.getAddress().getAddress());

        address.setAddress("西湖区");

        System.out.println("学生1:" + student3.getNumber() + ",地址:" + student3.getAddress().getAddress());
        System.out.println("学生2:" + clone.getNumber() + ",地址:" + clone.getAddress().getAddress());
    }

    public class Address2 implements Cloneable {
        private String address;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        protected Object clone() {
            Address2 address2 = null;
            try {
                address2 = (Address2) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return address2;
        }
    }

    public class Student3 implements Cloneable {
        private int number;
        private Address2 address;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public Address2 getAddress() {
            return address;
        }

        public void setAddress(Address2 address) {
            this.address = address;
        }

        @Override
        protected Object clone() {
            Student3 stu = null;
            try {
                stu = (Student3) super.clone(); //浅复制
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            stu.address = (Address2) address.clone(); //深度复制
            return stu;
        }
    }
    /*------------------------------样例------------------------------------*/

}
