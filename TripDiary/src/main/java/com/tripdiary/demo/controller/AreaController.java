package com.tripdiary.demo.controller;

import com.tripdiary.demo.mapper.AreaMapper;
import com.tripdiary.demo.model.CONTINENTS;
import com.tripdiary.demo.model.COUNTRIES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class AreaController {

    @Autowired
    AreaMapper areaMapper;

    @GetMapping("/read")
    public String readAll(Model model) {

        List<CONTINENTS> a = areaMapper.getAll();

        // key("data"), value(a)
        model.addAttribute("data", a);
        return "Continents";
    }

    @GetMapping("/read/{continentId}")
    public String readContinentId(Model model, @PathVariable("continentId") int continentId) {

        CONTINENTS continent = areaMapper.getContinent(continentId);
        //List<COUNTRIES> countries = areaMapper.getAllCountries();
        List<COUNTRIES> countries = areaMapper.getCountries(continentId);

        model.addAttribute("continent", continent);
        model.addAttribute("countries", countries);
        return "Countries";
    }

    @GetMapping("/read/{continentName}")
    public String readContinentName(Model model, @PathVariable("continentName") String continentName
            , @RequestParam("continentId") int continentId) {

        CONTINENTS continent = areaMapper.getContinent(continentId);
        List<COUNTRIES> countries = areaMapper.getCountriesConId(continentName);

        model.addAttribute("continent", continent);
        model.addAttribute("countries", countries);
        return "Countries";
    }

    @PostMapping("/insert")
    public String addCountry(Model model, @RequestParam("countryName") String countryName, @RequestParam("continentId") int continentId
    ) {

        //, @RequestParam("cityName") String cityName, @RequestParam("countryId") int countryId

        areaMapper.insertCountry(countryName, continentId);
        //areaMapper.insertCity(cityName, countryId);

        //return "redirect:/home/read";
        return "redirect:/home/read/" + continentId;
    }
}
