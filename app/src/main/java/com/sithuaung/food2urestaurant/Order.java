package com.sithuaung.food2urestaurant;

/**
 * Created by AungSi on 5/30/2017.
 */
public class Order {
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
}
