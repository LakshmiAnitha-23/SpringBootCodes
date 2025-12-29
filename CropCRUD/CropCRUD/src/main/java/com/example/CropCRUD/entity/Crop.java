package com.example.CropCRUD.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "crops")
public class Crop
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String season;
    private double pricePerKg;

    public Crop() {}

    public Crop(String name, String season, double pricePerKg)
    {
        this.name = name;
        this.season = season;
        this.pricePerKg = pricePerKg;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(double pricePerKg) {
        this.pricePerKg = pricePerKg;
    }
}
