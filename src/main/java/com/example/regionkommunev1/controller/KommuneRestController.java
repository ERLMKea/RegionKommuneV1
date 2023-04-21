package com.example.regionkommunev1.controller;

import com.example.regionkommunev1.model.Kommune;
import com.example.regionkommunev1.service.ApiServiceGetKommuner;
import com.example.regionkommunev1.service.ServiceKommuner;
import com.example.regionkommunev1.service.ServiceKommunerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KommuneRestController {


    @Autowired
    ApiServiceGetKommuner apiServiceGetKommuner;

    @Autowired
    ServiceKommuner serviceKommuner;

    @GetMapping("/getkommuner")
    public List<Kommune> getRegioner() {
        List<Kommune> lstKommuner = apiServiceGetKommuner.getKommuner();
        return lstKommuner;
    }

    @GetMapping("/startbogstav/{c}")
    public List<Kommune> getKommunerStartsWith(@PathVariable Character c) {
        return serviceKommuner.getKommunerStartsWith(c);
    }



}
