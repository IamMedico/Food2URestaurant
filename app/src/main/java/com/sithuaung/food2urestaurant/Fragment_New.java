package com.sithuaung.food2urestaurant;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by sithuaung on 5/29/17.
 */

public class Fragment_New extends Fragment implements RVAdapter1.recycler_confirm_click {
    RecyclerView recyclerView;
    public static RVAdapter1 recycler_adapter;
    Restaurant aa;
    List<Restaurant> array_list;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View  view=inflater.inflate(R.layout.fragment_new,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.rec);

        recycler_adapter = new RVAdapter1(getRestaurant());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycler_adapter);
        recycler_adapter.setRc(this);

        return view;

    }

    public List<Restaurant> getRestaurant(){

         array_list=new ArrayList<>();
        for (int i = 1; i < 30; i++) {
            aa=new Restaurant();
            aa.setOrder_item_no(String.valueOf(i));
            aa.setPick_up_time(String.valueOf(i));
            aa.setPick_up_by("Ko Ko");
            aa.setOrder_id(String.valueOf(i));
            aa.setOrder_code("A123"+i);
            aa.setStatus("Complete");
           array_list.add(aa);
        }

        return  array_list;
    }


    @Override
    public void onClick(int position, Restaurant restaurant) {
           recycler_adapter.remove(position);
           Fragment_Pending.add(restaurant);
           MainActivity.badge_new.setText(String.valueOf(Fragment_New.recycler_adapter.getItemCount()));
           MainActivity.badge_pending.setText(String.valueOf(Fragment_Pending.recycler_adapter.getItemCount()));
    }
}