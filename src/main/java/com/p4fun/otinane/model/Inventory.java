package com.p4fun.otinane.model;

import javax.persistence.*;

/**
 * Created by Hrystos on 7/12/2016.
 */

@Entity
@Table(name= "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pk;

    private int userId;
    private int itemId;


    public int getId() {
        return pk;
    }

    public void setId(int id) {
        this.pk = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

}
