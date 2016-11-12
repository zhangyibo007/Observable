package com.zhang.zs.zhangtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Observable;

public class MainActivity extends BaseActivity {

    private ImageView image;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
    }


    public void reply(View v) {

        //跳转也去答题
        startActivity(new Intent(this, ReplayActivity.class));
    }

    /**
     * 根据接收到的消息去做相关的功能
     * @param observable
     * @param data
     */
    @Override
    public void update(Observable observable, Object data) {
        if (data instanceof String) {
            String message = (String) data;
//            接收到成功消息就显示成功的图片 ，失败就显示失败的图片
            if (EventType.RESPONSE_SUCESS.equals(message)) {
                image.setBackgroundResource(R.drawable.name_ok);

            } else if (EventType.RESPONSE_FAIL.equals(message)) {
                image.setBackgroundResource(R.drawable.name_err);
            }

        }


    }
}
