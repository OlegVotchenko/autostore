package com.votchenko.autostore.services;

import com.votchenko.autostore.dao.CarBrandDAO;
import com.votchenko.autostore.entities.CarBrand;
import com.votchenko.autostore.enums.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrandService {

    private CarBrandDAO carBrandDAO;

    @Autowired
    public CarBrandService(CarBrandDAO carBrandDAO) {
        this.carBrandDAO = carBrandDAO;
    }

    public List<CarBrand> findAll(){
        return carBrandDAO.findAll();
    }

    public boolean save(CarBrand carBrand){

        carBrandDAO.save(carBrand);
        return true;
    }

    public Result deleteCarBrand(long id){
        return this.carBrandDAO.delete(id);
    }


}
