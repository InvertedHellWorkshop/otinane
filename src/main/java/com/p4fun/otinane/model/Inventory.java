package com.p4fun.otinane.model;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import javax.persistence.*;

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
