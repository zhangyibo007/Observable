package com.zhang.zs.zhangtest;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ReplayActivity extends BaseActivity {

    private RadioGroup anser;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replay);

        anser = (RadioGroup) findViewById(R.id.anser);

    }


    //根据消息发送消息
    public void response(View view) {

        int checkId = anser.getCheckedRadioButtonId();
        if (checkId == R.id.two) {
//            老师发送答题成功的消息
            Teacher.getInstance().postMessage(EventType.RESPONSE_SUCESS);
        } else if (checkId == R.id.three || checkId == R.id.four || checkId == R.id.five) {
//            老师发送答题失败的消息
            Teacher.getInstance().postMessage(EventType.RESPONSE_FAIL);
        } else {
            Toast.makeText(this, "请回答这个问题", Toast.LENGTH_SHORT).show();
            return;
        }

        finish();

    }


}
