package com.sithuaung.food2urestaurant;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by AungSi on 5/31/2017.
 */

public class CustomDialogClass extends Dialog implements View.OnClickListener{
    public Activity activity;
    public Dialog dialog;
    public Button gotit;
    public CustomDialogClass(Activity a)
    {
        super(a);
        this.activity=a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.orderalert);
        gotit=(Button)findViewById(R.id.btnalertok);
        gotit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        dismiss();
    }
}
