package com.p4fun.otinane.model;

/**
 * Created by Inverted Hell Workshop Death Crew on a cold and dreary day.
 */

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
