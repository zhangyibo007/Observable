package com.zhang.zs.zhangtest;

import java.util.Observable;

/**
 * Created by zs on 2016/11/12.
 * 老师类，老师就是给自己的学生传播知识，让自己的学生收益。
 * 这里老师就好像是一个消息的发送者，可以认为，老师就是被观察者
 * 这里继承系统的Observable类
 * name_ok.由于在同一时间段，只能有一个老师给学生传递知识，所以我们要把老师类（被观察者，事件发送源）
 * 对象设计成单例模式
 */
public class Teacher extends Observable {
    private Teacher() {

    }

    private static Teacher teacher = null;

    public static Teacher getInstance() {
        if (teacher == null) {
            synchronized (Teacher.class) {
                if (teacher == null) {
                    teacher = new Teacher();
                }
            }

        }
        return teacher;

    }

    public void postMessage(String eventtype) {

        setChanged();
        notifyObservers(eventtype);

    }


}
