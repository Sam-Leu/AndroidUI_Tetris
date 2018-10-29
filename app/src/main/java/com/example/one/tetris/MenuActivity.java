package com.example.one.tetris;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mp_click;
    private MediaPlayer mp_quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_menu);

        SplashActivity.splashActivity.finish();

        mp_click = MediaPlayer.create(this,R.raw.audio_click);
        mp_quit = MediaPlayer.create(this,R.raw.audio_quit);


        Button start = (Button)findViewById(R.id.btn_start);
        Button battle = (Button)findViewById(R.id.btn_battle);
        Button stars = (Button)findViewById(R.id.btn_stars);
        Button options = (Button)findViewById(R.id.btn_options);
        Button quit = (Button)findViewById(R.id.btn_quit);

        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"SFSlapstickComicShaded.ttf");

        start.setTypeface(typeface);
        battle.setTypeface(typeface);
        stars.setTypeface(typeface);
        options.setTypeface(typeface);
        quit.setTypeface(typeface);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_start:
                mp_click.start();
                Toast.makeText(this,"Start",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_battle:
                mp_click.start();
                Intent intent = new Intent(MenuActivity.this,BattleActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_stars:
                mp_click.start();
                Toast.makeText(this,"Stars",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_options:
                mp_click.start();
                Toast.makeText(this,"Options",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_quit:
                mp_quit.start();
                this.finish();
                break;

            default:
                break;
        }
    }
}
