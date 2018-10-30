package com.example.one.tetris;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    static Activity splashActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        splashActivity = this;

        darkenBackground();
        startActivity();

    }

    /**
     * 设置背景灰色
     */
    public void darkenBackground(){

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = (float) 0.5;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);
    }

    /**
     * 跳转菜单Activity
     */
    public void startActivity(){
        final ProgressDialog dialog = ProgressDialog.show(SplashActivity.this, "", "loading...");
        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    //线程休眠
                    sleep(2000);
                    dialog.dismiss();
                    Intent intent = new Intent(SplashActivity.this,MenuActivity.class);
                    startActivity(intent);

                }catch (Exception e){
                    e.printStackTrace();
                }super.run();
            }
        };
        thread.start();
    }

}
