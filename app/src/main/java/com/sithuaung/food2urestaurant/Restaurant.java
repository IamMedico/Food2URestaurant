package com.sithuaung.food2urestaurant;

/**
 * Created by sithuaung on 6/21/16.
 */
class Restaurant {
    String restaurant_name;
    String restaurant_type;
    String waiting_time;
    String delivery_accept_time;
    String service_price;

    int restaurant_photo;

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public String getRestaurant_type() {
        return restaurant_type;
    }

    public String getWaiting_time() {
        return waiting_time;
    }

    public String getDelivery_accept_time() {
        return delivery_accept_time;
    }

    public String getService_price() {
        return service_price;
    }

    public int getRestaurant_photo() {
        return restaurant_photo;
    }

    public void setRestaurant_name(String restaurant_name) {

        this.restaurant_name = restaurant_name;
    }

    public void setRestaurant_type(String restaurant_type) {
        this.restaurant_type = restaurant_type;
    }

    public void setWaiting_time(String waiting_time) {
        this.waiting_time = waiting_time;
    }

    public void setDelivery_accept_time(String delivery_accept_time) {
        this.delivery_accept_time = delivery_accept_time;
    }

    public void setService_price(String service_price) {
        this.service_price = service_price;
    }

    public void setRestaurant_photo(int restaurant_photo) {
        this.restaurant_photo = restaurant_photo;
    }

    Restaurant(String restaurant_name, String delivery_accept_time, String restaurant_type, String service_price, String waiting_time, int restaurant_photo) {
        this.restaurant_name = restaurant_name;
        this.delivery_accept_time = delivery_accept_time;
        this.restaurant_type = restaurant_type;
        this.service_price = service_price;
        this.waiting_time = waiting_time;
        this.restaurant_photo = restaurant_photo;
    }
    Restaurant(){

    }
}