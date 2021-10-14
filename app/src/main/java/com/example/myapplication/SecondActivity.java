package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Log.i("LaunchMode","SecondActivity在"+getTaskId()+"栈中管理");
        btn2=(Button)findViewById(R.id.btn2);

        btn2.setOnClickListener(new MyClick());
    }
    class MyClick implements View.OnClickListener{
        public void onClick(View v) {
            //点击按钮后要执行的代码

        }
    }
}
