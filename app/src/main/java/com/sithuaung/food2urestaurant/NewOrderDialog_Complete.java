package com.sithuaung.food2urestaurant;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by sithuaung on 6/5/17.
 */

public class NewOrderDialog_Complete extends Dialog {
    public Activity activity;
    public Dialog dialog;
    public Button ok,reject;
    public NewOrderDialog_Complete(Activity a)
    {
        super(a);
        this.activity=a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pending_complete_alert);
        ok=(Button)findViewById(R.id.button);
        reject=(Button)findViewById(R.id.button1);


        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Fragment_Pending.recycler_adapter.restaurants.get(Fragment_Pending.pos_of_clicked).setStatus("Completed");
                Fragment_History.add(Fragment_Pending.recycler_adapter.restaurants.get(Fragment_Pending.pos_of_clicked));
                Fragment_Pending.recycler_adapter.remove(Fragment_Pending.pos_of_clicked);
                Toast.makeText(activity,"HEllO",Toast.LENGTH_LONG).show();
            }
        });


        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                Fragment_Pending.recycler_adapter.restaurants.get(Fragment_Pending.pos_of_clicked).setStatus("Rejected");
                Fragment_History.add(Fragment_Pending.recycler_adapter.restaurants.get(Fragment_Pending.pos_of_clicked));
                Fragment_Pending.recycler_adapter.remove(Fragment_Pending.pos_of_clicked);

            }
        });
    }

}
