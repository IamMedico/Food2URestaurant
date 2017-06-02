package com.sithuaung.food2urestaurant;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by HtinShar on 6/1/2017.
 */

public class NewOrderDialog extends Dialog implements View.OnClickListener{
    public Activity activity;
    public Dialog dialog;
    public Button ok,reject;
    public NewOrderDialog(Activity a)
    {
        super(a);
        this.activity=a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.new_order_alert);
        ok=(Button)findViewById(R.id.button);
        reject=(Button)findViewById(R.id.button1);


      ok.setOnClickListener(this);
        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

            }
        });
    }

    @Override
    public void onClick(View v) {
        dismiss();
        Toast.makeText(activity,"HEllO",Toast.LENGTH_LONG).show();
        final Dialog dialog = new Dialog(activity);
        dialog.setContentView(R.layout.order_confirm_time);
        // Custom Android Allert Dialog Title
        dialog.setTitle("Order လာယူရမည့္အခ်ိန္ကိုေရြးေပးပါ");
        Button dialogButtonOk = (Button) dialog.findViewById(R.id.button);
        // Click cancel to dismiss android custom dialog box
        // Your android custom dialog ok action
        // Action for custom dialog ok button click
        dialogButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Fragment_Pending.add(Fragment_New.recycler_adapter.restaurants.get(Fragment_New.pos_of_clicked));
               Fragment_New.recycler_adapter.remove(Fragment_New.pos_of_clicked);

            }
        });
     dialog.show();
    }
}
