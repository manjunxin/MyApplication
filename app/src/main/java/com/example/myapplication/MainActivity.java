package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView myImg;
    //图片资源id数组
    private int[] imgs={R.drawable.img1,R.drawable.pineapple_pic,R.drawable.strawberry_pic,R.drawable.watermelon_pic};
    private int idx=0;

    private float startX;
    private float endX;
    //如何创建这个界面
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //图片控制对象
        myImg=(ImageView)findViewById(R.id.myImg);
        //默认取第一张图片的id
        myImg.setImageResource(imgs[idx]);
        //给图片控件添加触摸事件处理
        myImg.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                float x=event.getX();
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    startX=x;
                }
                if (event.getAction()==MotionEvent.ACTION_UP){
                    endX=x;
                    int sx=(int)startX;
                    int ex=(int)endX;
                    //判断左滑动100像素
                    if (ex-sx<0 && Math.abs(ex-sx)>100){
                        //图片处理
                        if (idx>0){
                            idx--;
                            myImg.setImageResource(imgs[idx]);
                        }else {
                            idx=0;
                            Toast.makeText(MainActivity.this, "这已经是第一张了", Toast.LENGTH_SHORT).show();
                        }
                    }
                    //判断右滑动100像素
                    if (ex-sx>0 && Math.abs(ex-sx)>100){
                        if (idx<imgs.length-1){
                            idx++;
                            myImg.setImageResource(imgs[idx]);
                        }else {
                            idx=imgs.length-1;
                            Toast.makeText(MainActivity.this, "这是最后一张了", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                return true;
            }
        });


    }
}


