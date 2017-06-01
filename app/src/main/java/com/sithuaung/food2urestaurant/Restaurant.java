package com.sithuaung.food2urestaurant;

/**
 * Created by sithuaung on 6/21/16.
 */
class Restaurant {
         String order_id;
    String pick_up_time;
    String pick_up_by;
    String order_item_no;
    String order_code;
    String status;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {

        this.order_id = order_id;
    }


    public void setPick_up_time(String pick_up_time) {
        this.pick_up_time = pick_up_time;
    }

    public void setPick_up_by(String pick_up_by) {
        this.pick_up_by = pick_up_by;
    }

    public void setOrder_item_no(String order_item_no) {
        this.order_item_no = order_item_no;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPick_up_time() {

        return pick_up_time;
    }

    public String getPick_up_by() {
        return pick_up_by;
    }

    public String getOrder_item_no() {
        return order_item_no;
    }

    public String getOrder_code() {
        return order_code;
    }

    public String getStatus() {
        return status;
    }

    Restaurant(String pick_up_time, String pick_up_by, String order_item_no, String order_code, String status, String order_id) {
        this.pick_up_time = pick_up_time;
        this.pick_up_by = pick_up_by;
        this.order_item_no = order_item_no;
        this.order_code = order_code;
        this.status = status;
        this.order_id=order_id;
    }
    Restaurant(){

    }
}