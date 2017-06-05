package com.sithuaung.food2urestaurant;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by sithuaung on 6/5/17.
 */

public class Restaurant_History  extends SugarRecord {
    @Unique
    String status;
    String pickUpTime;
    String pickUpBy;
    String orderCode;
    int orderItemCount;
    int number;


    // Default constructor is necessary for SugarRecord
    public Restaurant_History() {

    }

    public Restaurant_History(int number, String pickUpTime, String pickUpBy,int orderItemCount,String orderCode, String status) {
        this.number = number;
        this.pickUpTime = pickUpTime;
        this.pickUpBy = pickUpBy;
        this.orderItemCount = orderItemCount;
        this.orderCode = orderCode;
        this.status = status;
    }
}
