package com.example.HyderabadCRUD.entity;


import jakarta.persistence.*;

@Entity
@Table(name="hyderabad")
public class Hyderabad
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String areaName;
    private Long population;
    private String district;

    public Hyderabad() {}

    public Hyderabad(String areaName, Long population, String district)
    {
        this.areaName = areaName;
        this.population = population;
        this.district = district;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
