package com.votchenko.autostore.entities;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carBrandId", nullable = false)
    private CarBrand carBrand;

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "description")
    private String description;

    @Column(name = "yearFrom")
    private int yearFrom;

    @Column(name = "yearTo")
    private int yearTo;

    @ManyToMany
    @JoinTable(name = "tbl_Car_Item",
            joinColumns = @JoinColumn(name = "carId"),
            inverseJoinColumns = @JoinColumn(name = "itemId"))
    private Set<Item> item = new HashSet<>();

    public Set<Item> getItem() {
        return item;
    }

    public void setItem(Set<Item> item) {
        this.item = item;
    }

    public Car() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        if (yearFrom != car.yearFrom) return false;
        if (yearTo != car.yearTo) return false;
        if (carBrand != null ? !carBrand.equals(car.carBrand) : car.carBrand != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        return description != null ? description.equals(car.description) : car.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (carBrand != null ? carBrand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + yearFrom;
        result = 31 * result + yearTo;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carBrand=" + carBrand +
                ", model='" + model + '\'' +
                ", description='" + description + '\'' +
                ", yearFrom=" + yearFrom +
                ", yearTo=" + yearTo +
                '}';
    }
}
