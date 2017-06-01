package com.sithuaung.food2urestaurant;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifTextView;

import static com.sithuaung.food2urestaurant.R.id.time;

/**
 * Created by sithuaung on 5/29/17.
 */

public class LogInActivity extends AppCompatActivity {
    Button log_in;
    ImageView img;
    String signal = "0";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        log_in = (Button) findViewById(R.id.login_btn);

      //  img.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.move));

        final Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {

                                  @Override
                                  public void run() {
                                      runOnUiThread(new Runnable() {

                                          @Override
                                          public void run() {
                                              img = (ImageView) findViewById(R.id.img);
                                              img.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.move));
                                          }

                                      });
                                  }

                              },
//Set how long before to start calling the TimerTask (in milliseconds)
                0,
//Set the amount of time between each execution (in milliseconds)
                5000);


        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogInActivity.this, SplashActivity.class);
                startActivity(i);
                signal = "1";
            }
        });


    }
}
