package com.zhang.zs.zhangtest;

import android.app.Activity;
import android.os.Bundle;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by zs on 2016/11/12.
 */
public  class BaseActivity extends Activity implements Observer{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this instanceof Observer){
            //将要接收消息的学生添加
            Teacher.getInstance().addObserver(this);
        }

    }

    //接受到消息的回调方法，就是学生接受到消息后做出的反映
    @Override
    public void update(Observable observable, Object data) {

    }


}
