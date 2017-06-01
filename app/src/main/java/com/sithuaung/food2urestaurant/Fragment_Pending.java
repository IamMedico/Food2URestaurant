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
 * Created by sithuaung on 5/30/17.
 */

public class Fragment_Pending  extends Fragment implements RVAdapter1.recycler_confirm_click {
    RecyclerView recyclerView;
    public static RVAdapter2 recycler_adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.fragment_pending,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.rec);

        recycler_adapter = new RVAdapter2(getRestaurant());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycler_adapter);
//        recycler_adapter.setRc(this);

        return view;

    }

    private List<Restaurant> getRestaurant(){
        Restaurant aa=new Restaurant();
        List<Restaurant> array_list=new ArrayList<>();


        return  array_list;
    }


    @Override
    public void onClick(int position, Restaurant restaurant) {
        recycler_adapter.remove(position);
    }

    public  static void add(Restaurant restaurant){
        recycler_adapter.add(restaurant);

    }

}
