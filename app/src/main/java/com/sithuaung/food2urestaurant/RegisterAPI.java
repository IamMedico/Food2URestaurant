package com.sithuaung.food2urestaurant;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by AungSi on 5/29/2017.
 */

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/inserts.php")
    public void insertUser(
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email,
            Callback<Response> callback);
    @FormUrlEncoded
    @POST("/login.php")
    public void Login(
            //@Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            // @Field("email") String email,
            Callback<Response> callback);

}
