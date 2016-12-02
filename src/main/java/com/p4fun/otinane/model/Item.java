package com.p4fun.otinane.model;

import javax.persistence.*;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */
@Entity
@Table(name = "item")
public class Item {
    private long id;
    private String name;
    private double latitude;
    private double longitude;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
