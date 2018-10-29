package com.example.one.tetris;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class BattleActivity extends AppCompatActivity implements View.OnClickListener{

    private MediaPlayer mp_click;
    private MediaPlayer mp_quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_battle);

        mp_click = MediaPlayer.create(this,R.raw.audio_click);
        mp_quit = MediaPlayer.create(this,R.raw.audio_quit);

        Button campaign = (Button)findViewById(R.id.btn_campaign);
        Button marathon = (Button)findViewById(R.id.btn_marathon);
        Button back = (Button)findViewById(R.id.btn_back);

        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"SFSlapstickComicShaded.ttf");

        campaign.setTypeface(typeface);
        marathon.setTypeface(typeface);
        back.setTypeface(typeface);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_campaign:
                mp_click.start();
                Toast.makeText(this,"Campaign",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_marathon:
                mp_click.start();
                Toast.makeText(this,"Marathon",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_back:
                mp_quit.start();
                this.finish();
                break;

            default:
                break;
        }
    }
}
