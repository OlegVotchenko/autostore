package com.votchenko.autostore.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_CarBrand")
public class CarBrand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;
}
