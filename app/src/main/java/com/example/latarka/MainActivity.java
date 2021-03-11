package com.example.latarka;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int alpha=255, red=255, green=255, blue=255;
    TextView tvLight;
    Button buttonWhite;
    Button buttonRed;
    Button buttonGreen;
    Button buttonBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLight= findViewById(R.id.textView);
        buttonWhite= findViewById(R.id.button);
        buttonRed= findViewById(R.id.button3);
        buttonGreen= findViewById(R.id.button2);
        buttonBlue= findViewById(R.id.button4);

        buttonWhite.setOnClickListener(this);
        buttonRed.setOnClickListener(this);
        buttonGreen.setOnClickListener(this);
        buttonBlue.setOnClickListener(this);

        SeekBar s=(SeekBar)findViewById(R.id.seekBar);
        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                alpha=255-progress;
                int color= Color.argb(alpha, red, green, blue);
                tvLight.setBackgroundColor(color);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==buttonWhite.getId())
        {
            red=255;
            green=255;
            blue=255;
        }
        else if(v.getId()==buttonRed.getId())
        {
            red=255;
            green=0;
            blue=0;
        }
        else if(v.getId()==buttonGreen.getId())
        {
            red=0;
            green=255;
            blue=0;
        }
        else if(v.getId()==buttonBlue.getId())
        {
            red=0;
            green=0;
            blue=255;
        }
        int color= Color.argb(alpha, red, green, blue);
        tvLight.setBackgroundColor(color);
    }
}