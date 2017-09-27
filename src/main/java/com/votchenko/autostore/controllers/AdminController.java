package com.votchenko.autostore.controllers;

import com.votchenko.autostore.entities.CarBrand;
import com.votchenko.autostore.enums.Result;
import com.votchenko.autostore.services.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final CarBrandService carBrandService;

    @Autowired
    public AdminController(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }

    @RequestMapping
    public String Index() {
        return "index";
    }
    @RequestMapping(value = "carBrandList", method = RequestMethod.GET)
    public String CarBrandList(ModelMap model) {
        List<CarBrand> carBrandList = carBrandService.findAll();
        if (carBrandList == null) {
            return "errorPage";
        }

        model.put("carBrandList", carBrandList);
        return "admin/carBrandList";
    }

    @RequestMapping(value = "deleteCarBrand/{carBrandId}")
    public String deleteCarBrand(@PathVariable("carBrandId") Long carBrandId, ModelMap modelMap) {
        Result result = this.carBrandService.deleteCarBrand(carBrandId);
        if (result == Result.ERROR) {
            modelMap.put("error", "This passport is linked to student or teacher");
        }
        return "redirect:/admin/carBrandList";
    }
}
