package com.sithuaung.food2urestaurant;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

import static com.sithuaung.food2urestaurant.MainActivity.ROOT_URL;


/**
 * Created by sithuaung on 5/29/17.
 */

public class Fragment_New extends Fragment implements RVAdapter1.recycler_confirm_click {
    RecyclerView recyclerView;
    public static RVAdapter1 recycler_adapter;
    public static List<Restaurant> orders;
    public static int pos_of_clicked = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rec);

        getOrders();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                NewOrderDialog dd = new NewOrderDialog(getActivity());
                dd.show();
                pos_of_clicked = position;
            }

            @Override
            public void onLongClick(View view, int position) {


            }
        }));

//        recycler_adapter.setRc(this);

        return view;

    }


    @Override
    public void onClick(int position, Restaurant restaurant) {
        recycler_adapter.remove(position);
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private Fragment_New.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final Fragment_New.ClickListener clickListener) {
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


    private void getOrders() {
        //While the app fetched data we are displaying a progress dialog
        final ProgressDialog loading = ProgressDialog.show(getContext(), "Fetching Data", "Please wait...", false, false);

        //Creating a rest adapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();

        //Creating an object of our api interface
        BooksAPI api = adapter.create(BooksAPI.class);
        TelephonyManager tm = (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        String identifier = tm.getDeviceId();
        //Defining the method
        api.getOrders(
                identifier,
                new Callback<List<Restaurant>>() {
                    @Override
                    public void success(List<Restaurant> list, Response response) {
                        //Dismissing the loading progressbar
                        loading.dismiss();

                        //Storing the data in our list
                        orders = list;

                        //Calling a method to show the list

                        // showList();
                        if (list.size() != 0) {
                            CustomDialogClass dialog = new CustomDialogClass(getActivity());
                            dialog.show();
                            MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), R.raw.alert_new);
                            mediaPlayer.start();
                            showList();
                        } else Toast.makeText(getActivity(), "Hi", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //you can handle the errors here
                    }
                });

    }

    private void showList() {
        // String array to store all the book names
        ArrayList<Restaurant> items = new ArrayList<>();

        // Traversing through the whole list to get all the names
        for (int i = 0; i < orders.size(); i++) {
            Restaurant item = new Restaurant();
            //Storing names to string array
            item.setNumber(orders.get(i).number);
            item.setPickUpTime(orders.get(i).pickUpTime);
            item.setPickUpBy(orders.get(i).pickUpBy);
            item.setOrderCode(orders.get(i).orderCode);
            item.setOrderItemCount(orders.get(i).orderItemCount);
            item.setStatus(orders.get(i).status);
            items.add(item);

        }

        recycler_adapter = new RVAdapter1(items);
        recyclerView.setAdapter(recycler_adapter);

    }

}