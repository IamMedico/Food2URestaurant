package com.sithuaung.food2urestaurant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifTextView;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static com.sithuaung.food2urestaurant.R.id.time;

/**
 * Created by sithuaung on 5/29/17.
 */

public class LogInActivity extends AppCompatActivity {
    Button log_in;
    EditText txtusername,txtpassword;
    Intent insertPage;
    String output = "";
    TelephonyManager mngr;
    ImageView img;
    String signal = "0";
    public static final String ROOT_URL = "https://baccivorous-servos.000webhostapp.com/";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtusername=(EditText)findViewById(R.id.username);
        txtpassword=(EditText)findViewById(R.id.password);
        log_in = (Button) findViewById(R.id.login_btn);


        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtusername.getText().toString().equals("") && txtpassword.getText().toString().equals(""))
                    Toast.makeText(LogInActivity.this,"Please Fill All Blanks",Toast.LENGTH_SHORT).show();
                logIn();

            }
        });


        //  img.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.move));
//
//        final Timer t = new Timer();
//        t.scheduleAtFixedRate(new TimerTask() {
//
//                                  @Override
//                                  public void run() {
//                                      runOnUiThread(new Runnable() {
//
//                                          @Override
//                                          public void run() {
//                                              img = (ImageView) findViewById(R.id.img);
//                                              img.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.move));
//                                          }
//
//                                      });
//                                  }
//
//                              },
////Set how long before to start calling the TimerTask (in milliseconds)
//                0,
////Set the amount of time between each execution (in milliseconds)
//                5000);


    }
    private void logIn() {
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL) //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        RegisterAPI api = adapter.create(RegisterAPI.class);

        //Defining the method insertuser of our interface
        api.Login(

                //Passing the values by getting it from editTexts
                txtusername.getText().toString(),
                txtpassword.getText().toString(),
                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
                        BufferedReader reader = null;

                        //An string to store output from the server


                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(output.equals("success"))  {
                            insertPage=new Intent(LogInActivity.this,SplashActivity.class);
                            startActivity(insertPage);
                        }

                        //Displaying the output as a toast
                        Toast.makeText(LogInActivity.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(LogInActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
}
