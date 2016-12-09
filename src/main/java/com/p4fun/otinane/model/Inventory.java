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
    private Long pk;

    private Long userId;
    private Long itemId;


    public Long getId() {
        return pk;
    }

    public void setId(Long id) {
        this.pk = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

}
