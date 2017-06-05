package com.sithuaung.food2urestaurant;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
    public static int pos_of_clicked=0;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.fragment_pending,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.rec);

        recycler_adapter = new RVAdapter2(getRestaurant());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recycler_adapter);
        recyclerView.addOnItemTouchListener(new Fragment_Pending.RecyclerTouchListener(getActivity(), recyclerView, new Fragment_Pending.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                NewOrderDialog_Complete dd = new NewOrderDialog_Complete(getActivity());
                dd.show();
                pos_of_clicked=position;
            }

            @Override
            public void onLongClick(View view, int position) {


            }
        }));


//        recycler_adapter.setRc(this);

        return view;

    }



    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private Fragment_Pending.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Fragment_Pending.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }

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

    public static int getCount(){
        return recycler_adapter.getItemCount();
    }

}
