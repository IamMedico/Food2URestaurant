package com.sithuaung.food2urestaurant;


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
public class RVAdapter1 extends RecyclerView.Adapter<RVAdapter1.PersonViewHolder>{
    List<Restaurant> restaurants;
    recycler_confirm_click rc;



    RVAdapter1(List<Restaurant> restaurants){
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
        personViewHolder.restaurant_name.setText(restaurants.get(i).restaurant_name);
        personViewHolder.delivery_accept_time.setText(restaurants.get(i).delivery_accept_time);
        personViewHolder.restaurant_type.setText(restaurants.get(i).restaurant_type);
        personViewHolder.service_price.setText(restaurants.get(i).service_price);
        personViewHolder.waiting_time.setText(restaurants.get(i).waiting_time);
//        personViewHolder.restaurant_photo.setImageResource(restaurants.get(i).restaurant_photo);

        personViewHolder.confrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rc.onClick(i,restaurants.get(i));
            }
        });

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView restaurant_name;
        TextView delivery_accept_time;
        TextView restaurant_type;
        TextView service_price;
        TextView waiting_time;
        ImageView restaurant_photo;
        Button confrim;


        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            restaurant_name = (TextView)itemView.findViewById(R.id.restaurant_name);
            delivery_accept_time = (TextView)itemView.findViewById(R.id.delivery_accept_time);
            restaurant_type = (TextView)itemView.findViewById(R.id.restaurant_type);
            service_price = (TextView)itemView.findViewById(R.id.service_price);
            waiting_time = (TextView)itemView.findViewById(R.id.waiting_time);
            restaurant_photo = (ImageView)itemView.findViewById(R.id.restaurant_photo);
            confrim = (Button) itemView.findViewById(R.id.confirm);

        }
    }


    interface recycler_confirm_click {

        void onClick(int position,Restaurant restaurant);

    }

    public  void remove(int position){
        restaurants.remove(position);
        notifyDataSetChanged();

    }


}
