package com.votchenko.autostore.entities;


import javax.persistence.*;

@Entity
@Table(name = "tbl_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carBrand_id", nullable = false)
    private  CarBrand carBrand;

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

//    @OneToOne
//    @JoinColumn(name = "carBrand_id" )
//    private long carBrand_id;

    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;

    @Column(name = "yearFrom")
    private int yearFrom;

    @Column(name = "yearTo")
    private int yearTo;

    public Car(CarBrand carBrand, String model, String description, int yearFrom, int yearTo) {
        this.carBrand = carBrand;
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
