package com.example.OTTCRUD.entity;

import jakarta.persistence.*;

@Entity
@Table(name= "ott_platform")
public class OttPlatform
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String subscriptionType;
    private double price;
    private String language;

    public OttPlatform() {}

    public OttPlatform(String name, String subscriptionType, double price, String language)
    {
        this.name = name;
        this.subscriptionType = subscriptionType;
        this.price = price;
        this.language = language;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
