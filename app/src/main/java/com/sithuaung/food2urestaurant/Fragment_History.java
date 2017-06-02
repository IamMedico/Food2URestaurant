package com.sithuaung.food2urestaurant;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static com.sithuaung.food2urestaurant.MainActivity.ROOT_URL;

/**
 * Created by sithuaung on 6/2/17.
 */

public class Fragment_History extends Fragment implements RVAdapter1.recycler_confirm_click {
    RecyclerView recyclerView;
    Restaurant aa;
    List<Restaurant> orders;
    public static RVAdapter3 recycler_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.fragment_history,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.rec);

        recycler_adapter = new RVAdapter3(getRestaurant());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycler_adapter);


//        recycler_adapter.setRc(this);

        return view;

    }

    private List<Restaurant> getRestaurant(){
        aa=new Restaurant();
        orders=new ArrayList<>();

        return  orders;
    }


    //Our method to show list


    @Override
    public void onClick(int position, Restaurant restaurant) {
        recycler_adapter.remove(position);
    }

    public  static void add(Restaurant restaurant){
        recycler_adapter.add(restaurant);

    }

    public static int getCount(){
        return recycler_adapter.getItemCount();
    }

}
