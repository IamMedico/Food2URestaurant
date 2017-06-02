package com.sithuaung.food2urestaurant;

/**
 * Created by sithuaung on 6/21/16.
 */
class Restaurant {
    int orderItemCount;
    int number;
    String status;
    String pickUpBy;
    String pickUpTime;
    String orderCode;


    public void setNumber(int number) {
        this.number = number;
    }

    public void setOrderItemCount(int orderItemCount) {
        this.orderItemCount = orderItemCount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPickUpBy(String pickUpBy) {
        this.pickUpBy = pickUpBy;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getNumber() {
        return number;
    }

    public int getOrderItemCount() {
        return orderItemCount;
    }

    public String getStatus() {
        return status;
    }

    public String getPickUpBy() {
        return pickUpBy;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }



    public String getOrderCode() {
        return orderCode;
    }

    Restaurant(String pick_up_time, String pick_up_by, int order_item_no, String order_code, String status, int order_id) {
        this.pickUpTime = pick_up_time;
        this.pickUpBy = pick_up_by;
        this.orderItemCount = order_item_no;
        this.orderCode = order_code;
        this.status = status;
        this.number=order_id;
    }
    Restaurant(){

    }
}