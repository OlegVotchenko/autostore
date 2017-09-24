package com.votchenko.autostore.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;


    @OneToOne
    @JoinColumn(name = "carBrand_id" )
    private long carBrand_id;

    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;

    @Column(name = "yearFrom")
    private int yearFrom;

    @Column(name = "yearTo")
    private int yearTo;

    public Car(long carBrand_id, String model, String description, int yearFrom, int yearTo) {
        this.carBrand_id = carBrand_id;
        this.model = model;
        this.description = description;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCarBrand_id() {
        return carBrand_id;
    }

    public void setCarBrand_id(long carBrand_id) {
        this.carBrand_id = carBrand_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(int yearFrom) {
        this.yearFrom = yearFrom;
    }

    public int getYearTo() {
        return yearTo;
    }

    public void setYearTo(int yearTo) {
        this.yearTo = yearTo;
    }
}
