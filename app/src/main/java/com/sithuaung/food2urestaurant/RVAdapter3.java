package com.sithuaung.food2urestaurant;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sithuaung on 6/17/16.
 */
public class RVAdapter3 extends RecyclerView.Adapter<RVAdapter3.PersonViewHolder>{
    List<Restaurant> restaurants;
    recycler_confirm_click rc;



    RVAdapter3(List<Restaurant> restaurants){
        this.restaurants = restaurants;
    }

    public void setRc(recycler_confirm_click rc) {
        this.rc = rc;
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, final int i) {
        personViewHolder.order_no.setText(String.valueOf(restaurants.get(i).getNumber()));
        personViewHolder.pick_up_time.setText(restaurants.get(i).pickUpTime);
        personViewHolder.pick_up_by.setText(restaurants.get(i).getPickUpBy());
        personViewHolder.order_item_count.setText(String.valueOf(restaurants.get(i).getOrderItemCount()));
        personViewHolder.order_code.setText(restaurants.get(i).getOrderCode());
        personViewHolder.status.setText(restaurants.get(i).getStatus());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView order_no;
        TextView pick_up_time;
        TextView pick_up_by;
        TextView order_item_count;
        TextView order_code;
        TextView status;


        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            order_no = (TextView)itemView.findViewById(R.id.order_no);
            pick_up_time = (TextView)itemView.findViewById(R.id.pick_up_time);
            pick_up_by = (TextView)itemView.findViewById(R.id.pick_up_by);
            order_item_count = (TextView)itemView.findViewById(R.id.order_item_count);
            order_code = (TextView)itemView.findViewById(R.id.order_code);
            status = (TextView) itemView.findViewById(R.id.status);
//            confrim = (Button) itemView.findViewById(R.id.confirm);

        }
    }


    interface recycler_confirm_click {

        void onClick(int position,Restaurant restaurant);

    }

    public  void remove(int position){
        restaurants.remove(position);
        notifyDataSetChanged();

    }

    public  void add(Restaurant res){
        restaurants.add(res);
        notifyDataSetChanged();

    }



}
