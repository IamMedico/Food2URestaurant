package com.sithuaung.food2urestaurant;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by AungSi on 5/25/2017.
 */

public interface BooksAPI {
    @FormUrlEncoded
    @POST("/ordertest.php")
    public void getOrders(
            @Field("imei") String imei,
            Callback<List<Restaurant>> response);
}
